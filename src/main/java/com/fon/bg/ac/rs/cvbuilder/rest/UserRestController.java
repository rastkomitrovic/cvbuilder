package com.fon.bg.ac.rs.cvbuilder.rest;

import com.fon.bg.ac.rs.cvbuilder.entity.User;
import com.fon.bg.ac.rs.cvbuilder.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserRestController {

    @Resource
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
