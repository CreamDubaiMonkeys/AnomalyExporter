package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.model.User;

public interface UserService {

    User getUserByUsername(String username);
    User getUserByEmail(String email);

}
