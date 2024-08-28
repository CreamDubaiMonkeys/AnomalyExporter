import { Component, NgModule } from '@angular/core';
import { NgForm } from '@angular/forms'
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpProviderService } from '../service/http-provider.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOption, MatSelect } from '@angular/material/select';
import { RouterModule } from '@angular/router'



@Component({
  selector: 'app-event-create',
  standalone: true,
  imports: [
    
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelect,
    CommonModule,
    MatOption,
    RouterModule
],
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css'],
})
export class EventCreateComponent {
eventCreate() {
throw new Error('Method not implemented.');
}
  event = {
    title: '',
    description: '',
    date: '',
    location: ''
  };

  confirmationMessage!: string;
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


  constructor(private eventService: HttpProviderService) { }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.event.title = form.value.title;
      this.event.description = form.value.description;
      this.event.date = form.value.date;
      this.event.location = form.value.location
    

      this.eventService.postEvent(this.event);
      this.confirmationMessage = 'Event created successfully!';
      form.reset();
    }
  }
}
