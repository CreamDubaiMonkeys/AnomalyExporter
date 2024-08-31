import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
export interface Notification {
  id: number;
  type: string;
  emitter: string;
  eventTitle: string;
  date: string;
  time: string;
}
@Component({
  selector: 'app-notification-list',
  standalone: true,
  imports: [MatListModule, MatIconModule, CommonModule],
  templateUrl: './home-notifications.component.html',
  styleUrl: './home-notifications.component.css',
})
export class HomeNotificationsComponent {
  notifications: Notification[] = [
    {
      id: 1,
      type: 'invitation',
      emitter: 'John Doe',
      eventTitle: 'Event 1',
      date: '2021-10-10',
      time: '10:00:00',
    },
    {
      id: 2,
      type: 'invitation',
      emitter: 'Jane Doe',
      eventTitle: 'Event 2',
      date: '2021-10-10',
      time: '10:00:00',
    },
    {
      id: 3,
      type: 'invitation',
      emitter: 'Jade Doe',
      eventTitle: 'Event 3',
      date: '2021-10-10',
      time: '10:00:00',
    },
  ];

  constructor() {}
  initialiseNotifications() {}
  deleteNotification(notification: Notification) {
    console.log('Deleted Notification:', notification);
    this.notifications.splice(this.notifications.indexOf(notification), 1);
    // call the service to delete the notification
  }
}
