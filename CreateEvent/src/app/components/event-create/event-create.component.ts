import { Component } from '@angular/core';
import { NgForm } from '@angular/forms'
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent {
  event = {
    title: '',
    description: '',
    date: '',
    location: ''
  };

  confirmationMessage!: string;

  constructor(private eventService: EventService) { }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.eventService.createEvent(this.event);
      this.confirmationMessage = 'Event created successfully!';
      form.reset();
    }
  }
}
