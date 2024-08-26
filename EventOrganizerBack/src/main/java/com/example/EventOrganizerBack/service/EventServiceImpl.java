package com.example.EventOrganizerBack.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(
            String eventTitle,
            String eventDescription,
            Date eventDate,
            Time eventTime,
            Integer eventCapacity,
            User eventCreator,
            Boolean eventIsPrivate,
            String eventLocation,
            Boolean eventIs_private) {
        Event event = new Event();
        event.setTitle(eventTitle);
        event.setDescription(eventDescription);
        event.setDate(eventDate);
        event.setTime(eventTime);
        event.setCapacity(eventCapacity);
        event.setCreator(eventCreator);
        event.setIs_private(eventIs_private);
        event.setLocation(eventLocation);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        event.setCreated_at(now);
        event.setUpdated_at(now);

        return eventRepository.save(event);
    }

    @Override
    public Event getEventByUserId(int userId) {
        return null;
    }

}
