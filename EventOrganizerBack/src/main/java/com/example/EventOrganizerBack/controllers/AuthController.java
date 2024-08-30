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

import com.example.EventOrganizerBack.controllers.utils.ResponseWrapper;
import com.example.EventOrganizerBack.dto.LoginDto;
import com.example.EventOrganizerBack.dto.RegisterDto;
import com.example.EventOrganizerBack.dto.UserDto;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.repository.UserRepository;
import com.example.EventOrganizerBack.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    // private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
            PasswordEncoder passwordEncoder, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<ResponseWrapper<UserDto>> login(@Valid @RequestBody LoginDto loginDto){
        User userToLog;
        String identifier = loginDto.getIdentifier();

        //Check if received identifier exists
        if(userRepository.existsByUsername(identifier)) {
            userToLog = userService.getUserByUsername(identifier);
        } else if(userRepository.existsByEmail(loginDto.getIdentifier())) {
            userToLog = userService.getUserByEmail(identifier);
        } else {
            return new ResponseEntity<>(
                new ResponseWrapper<UserDto>("Unknown email / username", null), HttpStatus.BAD_REQUEST);
        }

        //Check password
        if (!passwordEncoder.matches(loginDto.getPassword(), userToLog.getPassword_hash())){
            return new ResponseEntity<>(
                new ResponseWrapper<UserDto>("Wrong password", null), HttpStatus.UNAUTHORIZED
            );
        }

        //Return user session information
        UserDto userToLogDto = new UserDto();
        userToLogDto.setId(userToLog.getId());
        userToLogDto.setUsername(userToLog.getUsername());
        
        return new ResponseEntity<>(
            new ResponseWrapper<UserDto>("Connection success", userToLogDto), HttpStatus.ACCEPTED
        ); 
        
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<ResponseWrapper<UserDto>> register(@Valid @RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>(
                    new ResponseWrapper<UserDto>("Username already exists", null), HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword_hash(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirst_name(registerDto.getFirst_name());
        user.setLast_name(registerDto.getLast_name());
        user.setEmail(registerDto.getEmail());

        user = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return new ResponseEntity<>(
                new ResponseWrapper<UserDto>("User registered successfully", userDto), HttpStatus.CREATED);
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerInfo() {
        return new ResponseEntity<>("Tis the register endpoint, try POSTing to it", HttpStatus.OK);
    }
}
