package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.repository.EventRepository;
import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Event createEvent(@RequestBody EventDto toAddEvent){
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

    @Override
    public Event updateEvent(@RequestBody EventDto toUpdateEvent, @PathVariable Integer id){
        Event event = eventRepository.findById(id).orElse(null);
        if(event != null){
            event.setCreator(userRepository.findById(toUpdateEvent.getCreatorId()).orElse(null));
            event.setDate(toUpdateEvent.getDate());
            event.setTime(toUpdateEvent.getTime());
            event.setCapacity(toUpdateEvent.getCapacity());
            event.setCreated_at(event.getCreated_at());
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            event.setUpdated_at(timestamp);
            event.setIs_private(toUpdateEvent.getIs_private());
            event.setDescription(toUpdateEvent.getDescription());
            event.setTitle(toUpdateEvent.getTitle());
            event.setLocation(toUpdateEvent.getLocation());
            eventRepository.save(event);
        }
        return event;
    }

    @Override
    public Event getEventById(Integer id){
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> getAllCreatorEvents(Integer creatorId){
        return eventRepository.findAllByCreatorId(creatorId);
    }

    @Override
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(Integer id){
        eventRepository.findById(id).ifPresent(eventRepository::delete);
    }

    @Override
    public List<Event> getAllPublicEventsExceptMine(Integer userId){
        List<Event> events = eventRepository.findAllByCreatorIdNot(userId);

        //filter events with creator id
        if (! events.isEmpty()){
            //remove private events
            events.removeIf(event -> event.getIs_private());//Method interface Event::getIs_private

        }else{
           //send empty list if no
            events = null;
        }

        return events;
    }
}
