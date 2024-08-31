package com.example.EventOrganizerBack.repository;

import com.example.EventOrganizerBack.model.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationUserRepository extends JpaRepository <NotificationUser, Integer> {
List<NotificationUser> findAllByReceiverId(Integer receiverId);
}
