package com.example.EventOrganizerBack.services;

import org.springframework.stereotype.Service;

import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.model.UserEvent;
import com.example.EventOrganizerBack.repository.UserEventRepository;

@Service
public class UserEventServiceImpl implements UserEventService {
    private UserEventRepository userEventRepository;

    public UserEventServiceImpl(UserEventRepository userEventRepository){
        this.userEventRepository = userEventRepository;
    }

    @Override
    public UserEvent createUserEvent(Event event, User user) {
        UserEvent userEvent = new UserEvent();
        userEvent.setEvent(event);
        userEvent.setUser(user);

        return userEventRepository.save(userEvent);
    }
    
}
