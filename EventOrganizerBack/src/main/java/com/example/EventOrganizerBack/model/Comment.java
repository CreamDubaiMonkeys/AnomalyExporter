package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.Rating;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id" , referencedColumnName = "id")
    private User author; //

    @ManyToOne
    @JoinColumn(name = "event_id" , referencedColumnName = "id")
    private Event event; //

    @Lob
    private String content; //To map a TEXT column in the database using JPA,
    // you can use the @Lob annotation on a String field in your entity class.
    // This tells JPA to map the field to a TEXT type in the database.

    private Timestamp created_at;

    private Timestamp updated_at;

    //Rating ENUM
    private Rating rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
