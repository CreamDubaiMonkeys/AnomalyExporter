package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.dto.NotificationUserDto;
import com.example.EventOrganizerBack.model.Notification;
import com.example.EventOrganizerBack.model.NotificationUser;

import java.util.List;

public interface NotificationUserService {
    void createNotificationUser(Notification notification, Integer userId);
    List<NotificationUserDto> getAllNotificationsByUserId(Integer userId);
}
