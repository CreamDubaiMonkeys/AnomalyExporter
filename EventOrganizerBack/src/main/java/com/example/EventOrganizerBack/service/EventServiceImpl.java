package com.example.EventOrganizerBack.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.repository.EventRepository;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


    @Override

    public Event createEvent(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
    
    
        return eventRepository.save(event);

    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public Event getEventById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(Integer id, Event eventDetails) {
        Event event = getEventById(id);
        if (event !=null){
            event.setTitle(eventDetails.getTitle());
            event.setDescription(eventDetails.getDescription());
            event.setDate(eventDetails.getDate());
            event.setLocation(eventDetails.getLocation());
            return eventRepository.save(event);

        }
        return null;
              
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
