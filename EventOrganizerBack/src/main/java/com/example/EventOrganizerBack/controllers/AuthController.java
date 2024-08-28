package com.example.EventOrganizerBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventOrganizerBack.dto.RegisterDto;
import com.example.EventOrganizerBack.dto.ResponseDto;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    // private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>(new ResponseDto("Username already exists"), HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword_hash(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirst_name(registerDto.getFirst_name());
        user.setLast_name(registerDto.getLast_name());
        user.setEmail(registerDto.getEmail());

        userRepository.save(user);        
        
        return new ResponseEntity<>(new ResponseDto("User registered successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerInfo() {
        return new ResponseEntity<>("Tis the register endpoint, try POSTing to it", HttpStatus.OK);
    }
}
