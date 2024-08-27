package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.repository.EventRepository;
import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }
    @Override
    public   Event createEvent(EventDto toAddEvent){
        Event event = new Event();
        if(toAddEvent != null){
            event.setCreator(userRepository.findById(toAddEvent.getCreatorId()).orElse(null));
            event.setDate(toAddEvent.getDate());
            event.setTime(toAddEvent.getTime());
            event.setCapacity(toAddEvent.getCapacity());
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            event.setCreated_at(timestamp);
            event.setUpdated_at(timestamp);
            event.setIs_private(toAddEvent.getIs_private());
            event.setDescription(toAddEvent.getDescription());
            event.setTitle(toAddEvent.getTitle());
            event.setLocation(toAddEvent.getLocation());
            eventRepository.save(event);
        }

        return event;
    }
}
