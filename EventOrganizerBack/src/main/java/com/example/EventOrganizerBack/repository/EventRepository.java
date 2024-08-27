package com.example.EventOrganizerBack.repository;

import com.example.EventOrganizerBack.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByCreatorId(Integer creatorId);
    // find all events except the ones created by the user where is_private is false
    List<Event> findAllByCreatorIdNot(Integer creatorId);
}
