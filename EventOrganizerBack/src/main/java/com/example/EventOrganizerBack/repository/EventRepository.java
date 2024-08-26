package com.example.EventOrganizerBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventOrganizerBack.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOwnerId(int id);

}
