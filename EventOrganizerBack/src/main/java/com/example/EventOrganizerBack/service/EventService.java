package com.example.EventOrganizerBack.service;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;


public interface EventService {
    Event getEventByUserId(int userId);
    Event createEvent(EventDto eventDto);

}
