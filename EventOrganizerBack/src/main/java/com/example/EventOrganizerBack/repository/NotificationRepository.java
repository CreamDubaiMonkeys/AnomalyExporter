package com.example.EventOrganizerBack.repository;

import com.example.EventOrganizerBack.dto.NotificationDto;
import com.example.EventOrganizerBack.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository <Notification, Integer> {

}
