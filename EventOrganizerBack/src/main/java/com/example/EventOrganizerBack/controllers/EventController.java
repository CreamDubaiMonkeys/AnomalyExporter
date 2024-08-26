package com.example.EventOrganizerBack.controllers;


import java.util.List;

import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.service.EventService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<EventDto> createEvent(@RequestParam("title") String eventTitle,
            @RequestParam("description") String eventDescription,
            @RequestParam("date") Date eventDate,
            @RequestParam("time") Time eventTime,
            @RequestParam("capacity") Integer eventCapacity,
            @RequestParam("creator") User eventCreator,
            @RequestParam("is_private") Boolean eventIsPrivate,
            @RequestParam("location") String eventLocation,
            @RequestParam("is_private") Boolean eventIs_private) {
        Event createdEvent = eventService.createEvent(eventTitle, eventDescription, eventDate, eventTime, eventCapacity,
                eventCreator, eventIsPrivate, eventLocation, eventIs_private);
        EventDto eventDto = new EventDto();
        return ResponseEntity.ok(eventDto);
    }
}


