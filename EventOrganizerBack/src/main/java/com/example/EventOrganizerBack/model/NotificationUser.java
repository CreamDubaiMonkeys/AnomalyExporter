package com.example.EventOrganizerBack.model;

import jakarta.persistence.*;

@Entity
public class NotificationUser {

    /*
    * class notification_user {
    - id: INT <<PK>>
    - notification_id: INT <<FK>>
    - receiver_id: INT <<FK>>
    - is_read: BOOLEAN
}
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "notification_id" , referencedColumnName = "id")
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "receiver_id" , referencedColumnName = "id")
    private User receiver;

}
