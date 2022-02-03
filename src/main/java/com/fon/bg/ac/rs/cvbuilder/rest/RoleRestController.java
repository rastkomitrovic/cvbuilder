package com.fon.bg.ac.rs.cvbuilder.rest;

import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/v1/roles")
public class RoleRestController {

    @Resource
    private RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<Iterable<Role>> getAllRoles(){
        return ResponseEntity.ok(roleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Role>> getRoleById(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok(roleRepository.save(role));
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        return ResponseEntity.ok(roleRepository.save(role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable("id") Long id){
        roleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
