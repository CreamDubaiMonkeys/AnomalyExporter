package com.example.EventOrganizerBack.dto;

import com.example.EventOrganizerBack.constants.NotificationType;
import com.example.EventOrganizerBack.model.Event;
import com.example.EventOrganizerBack.model.User;

import java.sql.Timestamp;

public class NotificationDto {
    private User emitter;
    private Event event;
    private Timestamp created_at;
    private NotificationType type;

    public User getEmitter() {
        return emitter;
    }

    public void setEmitter(User emitter) {
        this.emitter = emitter;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
