package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(event, org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting event");
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Object> getEventsByCreatorId(@PathVariable Integer id) {
        try{
            if (eventService.getAllCreatorEvents(id).isEmpty()) {
                return new ResponseEntity<>("No events found", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(eventService.getAllCreatorEvents(id), org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while getting events");
        }
    }

    @GetMapping("/all")
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Integer id) {
        try{
            Event deletedEvent = eventService.deleteEvent(id);
            return new ResponseEntity<>(deletedEvent, org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while deleting event");
        }
    }
}
