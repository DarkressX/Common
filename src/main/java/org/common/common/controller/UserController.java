package org.common.common.controller;

import org.common.common.model.User;
import org.common.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<User> getUser(@RequestParam(required = true) Long userId) {
        return new ResponseEntity<>(userRepository.findById(userId).get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam(required = true) Long userId) {
        userRepository.deleteById(userId);
    }

}