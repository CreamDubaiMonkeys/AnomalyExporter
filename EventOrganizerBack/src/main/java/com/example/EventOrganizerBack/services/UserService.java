package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.model.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<String> getUserNames();
}
