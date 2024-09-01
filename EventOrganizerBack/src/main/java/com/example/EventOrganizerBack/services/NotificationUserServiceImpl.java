package com.example.EventOrganizerBack.services;

import com.example.EventOrganizerBack.constants.NotificationType;
import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.dto.NotificationUserDto;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.Notification;
import com.example.EventOrganizerBack.model.NotificationUser;
import com.example.EventOrganizerBack.model.User;
import com.example.EventOrganizerBack.repository.NotificationUserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NotificationUserServiceImpl implements NotificationUserService {
    private NotificationUserRepository notificationUserRepository;
    private UserService userService;


    public NotificationUserServiceImpl(NotificationUserRepository notificationUserRepository, UserService userService) {
        this.userService = userService;
        this.notificationUserRepository = notificationUserRepository;
    }

    @Override
    public void createNotificationUser(Notification notification, Integer userId) {
        NotificationUser notificationUser = new NotificationUser();
        notificationUser.setReceiver(userService.getUserById(userId));
        notificationUser.setNotification(notification);
        notificationUser.setIs_read(false);
        notificationUserRepository.save(notificationUser);

    }
    @Override
    public List<NotificationUserDto> getAllNotificationsByUserId(Integer userId){
        List<NotificationUser> notificationUsers = notificationUserRepository.findAllByReceiverId(userId);


        List<NotificationUserDto> notificationDtos = new ArrayList<>();
       for(NotificationUser notificationUser : notificationUsers){
            //if the emmitter is the same as the receiver, we don't want to show the notification
            /*if(Objects.equals(notificationUser.getNotification().getEmitter().getId(), userId)){
                continue;
            }*/
            User emitter = notificationUser.getNotification().getEmitter();
            Event event = notificationUser.getNotification().getEvent();
            LocalDateTime created_at = notificationUser.getNotification().getCreated_at().toLocalDateTime();
            NotificationType type = notificationUser.getNotification().getType();
            NotificationUserDto notificationUserDto = new NotificationUserDto();
            notificationUserDto.setEmitter(emitter.getUsername());
            notificationUserDto.setDate(created_at.toLocalDate().toString());
            notificationUserDto.setTime(created_at.toLocalTime().toString());
            notificationUserDto.setType(type.name());
            notificationUserDto.setEventTitle(event.getTitle());

            notificationDtos.add(notificationUserDto);
       }
        return notificationDtos;
    }
}
