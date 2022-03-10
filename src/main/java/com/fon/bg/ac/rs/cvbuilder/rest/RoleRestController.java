package com.fon.bg.ac.rs.cvbuilder.rest;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.service.impl.RoleService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/roles")
public class RoleRestController {

    @Resource
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoleDTO>> getRoleById(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO role) {
        return ResponseEntity.ok(roleService.save(role));
    }

    @PutMapping
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO role) {
        return ResponseEntity.ok(roleService.update(role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable("id") Long id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
