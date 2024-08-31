package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.model.Notification;
import com.example.EventOrganizerBack.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;
    private UserService userService;

    public NotificationServiceImpl(NotificationRepository notificationRepository, UserService userService) {
        this.userService = userService;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification createNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setEvent(notificationDto.getEvent());
        notification.setType(notificationDto.getType());
        notification.setCreated_at(new java.sql.Timestamp(System.currentTimeMillis()));
        notification.setEmitter(notificationDto.getEmitter());
    return notificationRepository.save(notification);
    }
}
