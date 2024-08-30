package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.dto.EventWithUsersDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.model.UserEvent;
import com.example.EventOrganizerBack.services.EventService;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody EventDto eventDto) {
                /*
        * Note important :
        * run a post request to add user before running a post request to add event
        * and use this json format for the post request
        *
        {
        "creatorId": 1,
        "description": "description",
        "date": "2021-05-05",
        "time": "12:00:00",
        "capacity": 10,
        "is_private": false,
        "title": "titre",
        "location":"location"
        }

        * */
        try{
            Event createdEvent = eventService.createEvent(eventDto);
            return new ResponseEntity<>(createdEvent, org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating event");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEvent(@RequestBody EventDto eventDto, @PathVariable Integer id) {
        try{
            Event updatedEvent = eventService.updateEvent(eventDto, id);
            return new ResponseEntity<>(updatedEvent, org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while updating event");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable Integer id) {
        try{
            Event event = eventService.getEventById(id);
            List<User> participants = new ArrayList<>();
            for(UserEvent userEvent: event.getUserEvents()) {
                participants.add(userEvent.getUser());
            }

            EventWithUsersDto eventWithUsers = new EventWithUsersDto(event, participants);
            return new ResponseEntity<>(eventWithUsers, org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting event");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getEventsByCreatorId(@RequestParam Integer id) {
        try{
            if (eventService.getAllCreatorEvents(id).isEmpty()) {
                return new ResponseEntity<>("No events found", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(eventService.getAllCreatorEvents(id), org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting events");
        }
    }

    @GetMapping("/super_all")
    public ResponseEntity<Object> getAllEvents() {
        try{
            if (eventService.getAllEvents().isEmpty()) {
                return new ResponseEntity<>("No events found", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(eventService.getAllEvents(), org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting events");
        }
    }
    @GetMapping("/all_public_events_except_mine")
    public ResponseEntity<Object> getAllPublicEventsExceptMine(@RequestParam Integer id) {
        try{
            if (eventService.getAllPublicEventsExceptMine(id).isEmpty()) {
                return new ResponseEntity<>("No events found", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(eventService.getAllPublicEventsExceptMine(id), org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting events");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Integer id) {
        try{
            eventService.deleteEvent(id);
            return new ResponseEntity<>( org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while deleting event");
        }
    }
}
