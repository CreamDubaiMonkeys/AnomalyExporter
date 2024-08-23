package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.Role;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class User {
    /*
    * class user {
    - id: INT <<PK>>
    - created_at : TIMESTAMP
    - updated_at : TIMESTAMP
    + username: VARCHAR(50)
    + email: VARCHAR(100)
    + password_hash: VARCHAR(255)
    + first_name: VARCHAR(50)
    + last_name: VARCHAR(50)
    + role : ENUM('user', 'admin')
}*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Created at Timestamp
    private Timestamp created_at;
    //Updated at Timestamp
    private Timestamp updated_at;
    //Username
    private String username;
    //Email
    private String email;
    //First Name
    private String first_name;
    //Last Name
    private String last_name;
    //Role
    private Role role;

    @OneToMany(mappedBy = "emitter")
    private List <Notification> notifications;

    @OneToMany(mappedBy = "author")
    private List <Comment> comments;

    @OneToMany(mappedBy = "user")
    private List <UserEvent> userEvents;

    @OneToMany(mappedBy = "creator")
    private List <Event> events;

    @OneToMany(mappedBy = "receiver")
    private List <NotificationUser> notificationUsers;
}
