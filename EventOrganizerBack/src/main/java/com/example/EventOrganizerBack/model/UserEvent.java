package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.UserEventStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // user
    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;
    // event
    @ManyToOne
    @JoinColumn(name = "event_id" , referencedColumnName = "id")
    private Event event;

    private Timestamp invited_at;
    private Timestamp responded_at;
    private UserEventStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Timestamp getInvited_at() {
        return invited_at;
    }

    public void setInvited_at(Timestamp invited_at) {
        this.invited_at = invited_at;
    }

    public Timestamp getResponded_at() {
        return responded_at;
    }

    public void setResponded_at(Timestamp responded_at) {
        this.responded_at = responded_at;
    }

    public UserEventStatus getStatus() {
        return status;
    }

    public void setStatus(UserEventStatus status) {
        this.status = status;
    }
}
