import { Component } from '@angular/core';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './app.component.html',
  providers: [
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' } }
  ],
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CreateEvent';
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

  
  createEvent() {
    
    this.confirmationMessage = 'Event created successfully';
  }
  
}
