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
    id: 1,
    title: '',
    description: '',
    date: '',
    location: '',
    email:''
  };

  confirmationMessage!: string;
  
  EventOrganizerFront() {
    
    this.confirmationMessage = 'Event created successfully';
  }
  
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
