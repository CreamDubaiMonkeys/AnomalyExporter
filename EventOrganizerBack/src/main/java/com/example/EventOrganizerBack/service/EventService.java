package com.example.EventOrganizerBack.service;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public interface EventService {
    Event getEventByUserId(int userId);

    Event createEvent(String eventTitle, String eventDescription, Date eventDate, Time eventTime, Integer eventCapacity,
            User eventCreator, Boolean eventIsPrivate, String eventLocation, Boolean eventIs_private);

}
