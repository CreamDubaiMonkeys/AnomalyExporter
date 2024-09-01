package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.model.UserEvent;

public interface UserEventService {
    UserEvent createUserEvent(Event event, User user);
}
