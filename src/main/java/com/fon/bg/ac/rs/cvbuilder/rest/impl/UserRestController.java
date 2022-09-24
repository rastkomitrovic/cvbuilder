package com.fon.bg.ac.rs.cvbuilder.rest.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.user.*;
import com.fon.bg.ac.rs.cvbuilder.service.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/v1/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserRestController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Grabs a user with a specified Id")
    public ResponseEntity<Optional<FindUserDTO>> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    @Operation(summary = "Registers a new user")
    public ResponseEntity<Object> registerUser(@RequestBody @Valid RegisterUserDTO registerUserDto) {
        userService.registerUser(registerUserDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin")
    @Operation(summary = "Admin user creation. Allows setting of roles")
    public ResponseEntity<Object> adminUserRegister(@RequestBody @Valid AdminUserRegisterDTO adminUserRegisterDto) {
        userService.adminUserRegister(adminUserRegisterDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Updates an existing user")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDto) {
        userService.updateUser(updateUserDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin")
    @Operation(summary = "Admin user update. Allows updating roles")
    public ResponseEntity<Object> adminUserUpdate(@RequestBody @Valid AdminUserUpdateDTO adminUserUpdateDTO) {
        userService.adminUserUpdate(adminUserUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deactivates users account")
    public ResponseEntity<Object> deactivateUserAccount(@PathVariable("id") Long id) {
        userService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{page}/{size}/{sort}")
    public ResponseEntity<Page<FindUserDTO>> findPage(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("sort") String sort) {
        return ResponseEntity.ok(userService.findPage(PageRequest.of(page, size, Sort.by(sort))));
    }

    @PostMapping("/search/{page}/{size}/{sort}")
    public ResponseEntity<Page<FindUserDTO>> searchPage(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("sort") String sort, @RequestBody String searchParam) {
        return ResponseEntity.ok(userService.searchPage(PageRequest.of(page, size, Sort.by(sort)), searchParam));
    }
}
