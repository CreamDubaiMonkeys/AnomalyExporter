package com.example.EventOrganizerBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventOrganizerBack.model.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

}
