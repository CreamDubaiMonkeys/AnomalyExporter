package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.model.Notification;

public interface NotificationService {
    Notification createNotification(NotificationDto notificationDto);
}
