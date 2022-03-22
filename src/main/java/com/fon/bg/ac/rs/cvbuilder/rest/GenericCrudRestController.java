package com.fon.bg.ac.rs.cvbuilder.rest;

import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

// T - DTO class
// S - Service class
public abstract class GenericCrudRestController<T,S extends GenericCrudService<?,T,Long,?,?>> {

    @Autowired
    protected S service;

    @GetMapping
    @Operation(summary = "Finds all instance of this entity")
    public ResponseEntity<List<T>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Finds an entity with specified id")
    public ResponseEntity<Optional<T>> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Saves an entity")
    public ResponseEntity<T> save(@RequestBody @Valid T object){
        return ResponseEntity.ok(service.save(object));
    }

    @PutMapping
    @Operation(summary = "Updates an entity")
    public ResponseEntity<T> update(@RequestBody @Valid T object){
        return ResponseEntity.ok(service.update(object));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an entity with a specified id")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
