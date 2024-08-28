package com.example.EventOrganizerBack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterDto {
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;
    
    @NotBlank(message = "first_name is required")
    private String first_name;
    
    @NotBlank(message = "last_name is required")
    private String last_name;
    
    @NotBlank(message = "email is required")
    @Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
        message = "Invalid email format"
    )
    private String email;
}
