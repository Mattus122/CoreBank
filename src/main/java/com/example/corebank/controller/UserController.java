package com.example.corebank.controller;

import com.example.corebank.dto.RegisterRequest;
import com.example.corebank.exception.AgeException;
import com.example.corebank.model.User;
import com.example.corebank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers(){
        return userService.returnAllUser();

    }
    @PostMapping("/users")
    ResponseEntity<String> addUser(@RequestBody RegisterRequest registerRequest) throws Exception {
        return userService.add(registerRequest);
    }
    @PutMapping("/users/{uuid}")
    ResponseEntity<User> updateUser(@RequestBody User newUserData , @PathVariable UUID uuid){
        return userService.update(newUserData , uuid);
    }


}
