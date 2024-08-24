package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.NotificationType;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "emitter_id" , referencedColumnName = "id")
    private User emitter; //

    @ManyToOne
    @JoinColumn(name = "event_id" , referencedColumnName = "id")
    private Event event; //

    @OneToMany(mappedBy = "notification")
    private List<NotificationUser> notificationUsers;

    private Timestamp created_at;

    private NotificationType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<NotificationUser> getNotificationUsers() {
        return notificationUsers;
    }

    public void setNotificationUsers(List<NotificationUser> notificationUsers) {
        this.notificationUsers = notificationUsers;
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
