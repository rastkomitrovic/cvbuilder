package com.fon.bg.ac.rs.cvbuilder.rest;

import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// T - DTO class
// S - Service class
public abstract class GenericPagingRestController<T,S extends GenericPagingService<?,T,Long,?,?>> extends GenericCrudRestController<T,S> {

    @GetMapping("/search/{page}/{size}/{sort}")
    public ResponseEntity<Page<T>> findPage(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("sort") String sort){
        return ResponseEntity.ok(service.findPage(PageRequest.of(page,size, Sort.by(sort))));
    }

    @PostMapping("/search/{page}/{size}/{sort}")
    public ResponseEntity<Page<T>> searchPage(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("sort") String sort, @RequestBody String searchParam){
        return ResponseEntity.ok(service.searchPage(PageRequest.of(page,size,Sort.by(sort)),searchParam));
    }
}
