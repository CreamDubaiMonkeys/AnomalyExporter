package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.constants.NotificationType;
import com.example.EventOrganizerBack.dto.EventDto;
import com.example.EventOrganizerBack.dto.EventWithParticipentListDto;
import com.example.EventOrganizerBack.dto.EventWithUsersDto;
import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.Notification;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.model.UserEvent;
import com.example.EventOrganizerBack.services.EventService;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import com.example.EventOrganizerBack.services.NotificationService;
import com.example.EventOrganizerBack.services.NotificationUserService;
import com.example.EventOrganizerBack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final NotificationService notificationService;
    private final UserService userService;
    private final NotificationUserService notificationUserService;

    @Autowired
    public EventController(EventService eventService,
                           NotificationService notificationService,
                           UserService userService,
                           NotificationUserService notificationUserService) {
        this.eventService = eventService;
        this.notificationService = notificationService;
        this.userService = userService;
        this.notificationUserService = notificationUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody EventWithParticipentListDto eventWithParticipentListDto) {

        try{

            EventDto eventDto = new EventDto();
            eventDto.setCreatorId(eventWithParticipentListDto.getCreatorId());
            eventDto.setDescription(eventWithParticipentListDto.getDescription());
            eventDto.setDate(eventWithParticipentListDto.getDate());
            eventDto.setTime(eventWithParticipentListDto.getTime());
            eventDto.setCapacity(eventWithParticipentListDto.getCapacity());
            eventDto.setIs_private(eventWithParticipentListDto.getIs_private());
            eventDto.setTitle(eventWithParticipentListDto.getTitle());
            eventDto.setLocation(eventWithParticipentListDto.getLocation());


            List <String> participents = eventWithParticipentListDto.getParticipents();

            Event createdEvent = eventService.createEvent(eventDto);
            //creat notification using notification service
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setEvent(createdEvent);
            notificationDto.setType(NotificationType.INVITATION);
            // create Timestamp for now
            notificationDto.setCreated_at(new java.sql.Timestamp(System.currentTimeMillis()));
            notificationDto.setEmitter( userService.getUserById(eventWithParticipentListDto.getCreatorId()));
            //create notification
            Notification notification = notificationService.createNotification(notificationDto);
            //loop through participents and create notificationUser for each
            for(String participent: participents) {
                Integer userId = userService.getUserByUsername(participent).getId();
                //if participent is the same as the creator, we don't want to write the notification
                if (Objects.equals(userId, eventWithParticipentListDto.getCreatorId())) {
                    continue;
                }
                notificationUserService.createNotificationUser(notification, userId);
            }
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
