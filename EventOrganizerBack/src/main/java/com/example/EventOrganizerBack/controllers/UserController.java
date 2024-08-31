package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user_names")
    public ResponseEntity<Object> getUserNames(){
        return ResponseEntity.ok(userService.getUserNames());
    }
}
