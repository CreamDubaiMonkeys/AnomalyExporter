package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.Rating;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comment {
    /*

class comment {
    - id: INT <<PK>>
    - event_id: INT <<FK>>
    - author_id: INT <<FK>>
    - content: TEXT
    - created_at : TIMESTAMP
    - updated_at : TIMESTAMP
    + rating: INT(1-5)
}*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id" , referencedColumnName = "id")
    private User author; //

    @ManyToOne
    @JoinColumn(name = "event_id" , referencedColumnName = "id")
    private Event event; //

    private String content;

    private Timestamp created_at;

    private Timestamp updated_at;

    //Rating ENUM
    private Rating rating;



}
