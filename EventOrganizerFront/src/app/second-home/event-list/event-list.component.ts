
import {  NgFor } from '@angular/common';
import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { MatListItem, MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [MatListModule, MatListItem,NgFor],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css',
})
export class EventListComponent<T> implements OnInit, OnChanges {
  @Input() events: T[] = [];

  ngOnInit(): void {
    this.initializeEvents();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['events']) {
      this.initializeEvents();
    }
  }

  initializeEvents(): void {
    if (this.events) {
      console.log('Events:', this.events);
    }
  }
}
