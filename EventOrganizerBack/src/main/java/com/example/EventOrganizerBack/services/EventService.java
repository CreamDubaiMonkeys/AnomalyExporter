package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;

public interface EventService {
    Event createEvent(EventDto addedEvent);
}
