import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { AuthentificationService } from '../../service/authentification.service';
import { HttpProviderService } from '../../service/http-provider.service';
import { Notification } from '../../interface/Notification';

@Component({
  selector: 'app-notification-list',
  standalone: true,
  imports: [MatListModule, MatIconModule, CommonModule],
  templateUrl: './home-notifications.component.html',
  styleUrl: './home-notifications.component.css',
})
export class HomeNotificationsComponent implements OnInit {
  httpOptionsParams = {
    id: '',
  };
  notifications: Notification[] = [
    
  ];
  ngOnInit(): void {
    this.httpOptionsParams.id = this.authService.getId().toString();
    this.initialiseNotifications();
  }
  constructor(
    private httpProviderService: HttpProviderService,
    private authService: AuthentificationService
  ) {}
  initialiseNotifications() {
    this.httpProviderService
      .getMyNotifications(this.httpOptionsParams)
      .subscribe(
        (res) => {
          this.notifications = res.body;
        },
        (error) => {
          console.error('Error fetching notifications:', error);
        }
      );
  }
  deleteNotification(notification: Notification) {
    console.log('Deleted Notification:', notification);
    this.notifications.splice(this.notifications.indexOf(notification), 1);
    // call the service to delete the notification
  }
}
