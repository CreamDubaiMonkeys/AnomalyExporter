package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Created at Timestamp
    private Timestamp created_at;

    //Updated at Timestamp
    private Timestamp updated_at;
    //Username

    @Column(length = 50)
    private String username;

    //Email
    @Column(length = 100)
    private String email;

    //Password Hash
    private String password_hash;

    //First Name
    @Column(length = 50)
    private String first_name;

    //Last Name
    @Column(length = 50)
    private String last_name;

    //Role
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "emitter")
    private List <Notification> notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List <Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List <UserEvent> userEvents;
    
    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private List <Event> events;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List <NotificationUser> notificationUsers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<NotificationUser> getNotificationUsers() {
        return notificationUsers;
    }

    public void setNotificationUsers(List<NotificationUser> notificationUsers) {
        this.notificationUsers = notificationUsers;
    }
}
