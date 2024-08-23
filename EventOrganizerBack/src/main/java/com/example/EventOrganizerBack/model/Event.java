package com.example.EventOrganizerBack.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Event {
    /*
    * class event {
    - id: INT <<PK>>
    - created_by: INT <<FK>>
    - description: TEXT
    - date: DATE
    - time: TIME
    - capacity: INT
    - is_private: BOOLEAN
    - created_at : TIMESTAMP
    - updated_at : TIMESTAMP
    + title: VARCHAR(100)
    + location: VARCHAR(255)
}*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "created_by" , referencedColumnName = "id")
    private User creator;

    private String description;
    private Date date; // used java.sql.Date instead of java.util.Date might cause issues
    private Time time; // used java.sql.Time
    private Integer capacity;
    private Boolean is_private;
    private Timestamp created_at; // used java.sql.Timestamp
    private Timestamp updated_at; // used java.sql.Timestamp
    private String title;
    private String location;

    @OneToMany(mappedBy = "event")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    @OneToMany(mappedBy = "event")
    private List<UserEvent> userEvents;

}
