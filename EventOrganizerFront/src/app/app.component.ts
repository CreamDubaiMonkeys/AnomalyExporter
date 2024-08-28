import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { RouterModule } from '@angular/router';
import { CalendarModule } from './calendar/calendar.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    InscriptionComponent,
    CommonModule,
    RouterModule, 
    LoginComponent, 
    CalendarModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'EventOrganizerFront';
  emails: string[] = [
    'rania.baziz1@gmail.com',
    'adamifnou@gmail.com',
    'guy.mabyalaht@gmail.com',
    'quent1_jarry@hotmail.com',
    'carolepigna@gmail.com',
    'rosaline.kuy@gmail.com',
    'anliatmohamed@gmail.com',
    'tohami-bahaa@outlook.fr',
    'gcbiyoghe@gmail.com',
    'hatem.adresse@gmail.com',
    'nawell.belcaid@gmail.com',
    'tbbarry8@gmail.com',
    'user13@example.com',
    'user14@example.com',
    'user15@example.com',
    'user16@example.com',
    'user17@example.com',
    'user18@example.com',
    'user19@example.com',
    'user20@example.com'
  ];

  confirmationMessage: string | null = null;

  
  EventOrganizerFront() {
    
    this.confirmationMessage = 'Event created successfully';
  }
  
}
