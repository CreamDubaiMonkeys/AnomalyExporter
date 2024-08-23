package com.example.EventOrganizerBack.model;

import com.example.EventOrganizerBack.constants.NotificationType;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Notification {

    /*
    class notification {
    - id: INT <<PK>>
    - emitter_id: INT <<FK>>
    - event_id: INT <<FK>>
    - created_at : TIMESTAMP
    - type: ENUM('invitation', 'reminder', 'update')
}
    * */
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

}
