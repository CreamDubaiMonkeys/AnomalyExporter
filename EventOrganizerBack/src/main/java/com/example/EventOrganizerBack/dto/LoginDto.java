package com.example.EventOrganizerBack.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message="username or password required")
    private String identifier;

    @NotBlank(message = "password is required")
    private String password;
}
