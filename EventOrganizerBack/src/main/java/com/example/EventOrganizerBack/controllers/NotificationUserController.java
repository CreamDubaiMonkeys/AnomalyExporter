package com.example.EventOrganizerBack.controllers;

import com.example.EventOrganizerBack.services.NotificationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NotificationUserController {
    private final NotificationUserService notificationUserService;

    @Autowired
    public NotificationUserController(NotificationUserService notificationUserService) {
        this.notificationUserService = notificationUserService;
    }

    @GetMapping("/notifications")
    public ResponseEntity<Object> getNotifications(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(notificationUserService.getAllNotificationsByUserId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e);
        }
    }
}
