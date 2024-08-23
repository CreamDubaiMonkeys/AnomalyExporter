package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.UserEventStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class UserEvent {

    /*class user_event {
    - id: INT <<PK>>
    - user_id: INT <<FK>>
    - event_id: INT <<FK>>
    - invited_at: TIMESTAMP
    - responded_at: TIMESTAMP
    + status: ENUM('invited', 'accepted', 'declined', 'canceled')
}*/
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



}
