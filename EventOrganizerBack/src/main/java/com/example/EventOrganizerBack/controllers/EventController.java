package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
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

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody EventDto eventDto) {
        try{
            Event createdEvent = eventService.createEvent(eventDto);
            return new ResponseEntity<>(createdEvent, org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating event");
        }
    }
}
