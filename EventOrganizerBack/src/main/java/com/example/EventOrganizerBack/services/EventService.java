package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(EventDto addedEvent);
    Event updateEvent(EventDto updatedEvent, Integer id);
    Event getEventById(Integer id);
    List<Event> getAllCreatorEvents(Integer userId);
    List<Event> getAllEvents();
    void deleteEvent(Integer id);
    List<Event> getAllPublicEventsExceptMine(Integer userId);
}
