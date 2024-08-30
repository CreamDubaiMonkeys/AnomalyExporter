import { CommonModule } from '@angular/common';
import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'events-table',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, CommonModule],
  templateUrl: './events-table.component.html',
  styleUrl: './events-table.component.css',
})
export class EventsTableComponent<T> implements OnInit, OnChanges {
  @Input() showFilter: boolean = false;
  @Input() events: T[] = [];
  @Input() displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<T>();

  constructor(private router: Router) {}

  ngOnInit() {
    this.initializeDataSource();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['events']) {
      this.initializeDataSource();
    }
  }

  initializeDataSource() {
    if (this.events) {
      this.dataSource.data = this.events;
      this.dataSource.filterPredicate = (data: T, filter: string) => {
        const dataStr = Object.keys(data as object)
          .reduce((currentTerm, key) => {
            return (
              currentTerm +
              ((data[key as keyof T] &&
                String(data[key as keyof T]).toLowerCase()) ||
                '') +
              ' '
            );
          }, '')
          .trim();

        return dataStr.indexOf(filter) != -1;
      };
    }
  }

  // used to filter the data
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    console.log('Filter Value:', filterValue); // Log the filter value to verify
  }

  goToEventDetails(event: T) {
    // logic to navigate to the event details page with the event id as param
    console.log('Event:', event); // Log the event to verify
    this.router.navigate(['/event-details', (event as any).id]);
    /*
    The line this.router.navigate(['/event-details', event.id]); 
    is using the Angular Router to navigate to a specific route 
    in your Angular application.
    In this case, it is navigating to the route /event-details 
    with a parameter event.id. The event.id is likely a unique identifier 
    for a specific event. */

    
    /**
     * To make this work, you need to define the route 
const routes: Routes = [
  { path: 'event-details/:id', component: EventDetailsComponent }
];
 */
    /**
     * Exemple of how to get the id in the event-details component:
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  eventId: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.eventId = this.route.snapshot.paramMap.get('id');
    // Now you can use this.eventId to fetch event details or perform other logic
  }
}
     */
  }
}
