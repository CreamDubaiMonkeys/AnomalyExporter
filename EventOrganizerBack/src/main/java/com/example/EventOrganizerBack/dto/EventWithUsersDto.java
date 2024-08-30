package com.example.EventOrganizerBack.dto;

import lombok.Data;

import java.util.List;

import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;

@Data
public class EventWithUsersDto {
    private Event event;
    private List<User> participants;

    public EventWithUsersDto(Event event, List<User> participants){
        this.event = event;
        this.participants = participants;
    }
}
