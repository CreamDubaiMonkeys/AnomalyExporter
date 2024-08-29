import { Component, OnInit } from '@angular/core';
import { HttpProviderService } from '../service/http-provider.service';
import { EventsTableComponent } from './events-table/events-table.component';
import { EventListComponent } from './event-list/event-list.component';

@Component({
  selector: 'app-second-home',
  standalone: true,
  imports: [ EventsTableComponent, EventListComponent],
  templateUrl: './second-home.component.html',
  styleUrl: './second-home.component.css',
})
export class SecondHomeComponent implements OnInit {
  myEvents: any[] = [];
  publicEvents: any[] = [];
  historyEvents: any[] = [];
  myEventsDisplayedColumns: string[] = [
    'title',
    'date',
    'time',
    'capacity',
    'created_at',
 
  ];
  id = 1;
  publicEventsDisplayedColumns: string[] = [
    'title',
    'date',
    'time',
    'capacity',
    'created_at',
    'description',
    'location',
  ];
  constructor(private httpProviderService: HttpProviderService) {}

  ngOnInit(): void {
    this.LoadMyEvents();
    this.LoadPublicEvents();
    this.LoadHistoricevents();
  }

  LoadMyEvents() {
    this.httpProviderService.getEventByUserId(this.id).subscribe(
      (res) => {
        this.myEvents = res.body;
        console.log('Compartiments:', this.myEvents);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
  }
  LoadPublicEvents() {
    this.httpProviderService.getAllEvents().subscribe(
      (res) => {
        this.publicEvents = res.body;
        console.log('Public Events:', this.publicEvents);
      },
      (error) => {
        console.error('Error fetching public events:', error);
      }
    );
  }
  LoadHistoricevents(){
    this.httpProviderService.getHistoryEvents(this.id).subscribe(
      (res) => {
        this.myEvents = res.body;
        console.log('Compartiments:', this.myEvents);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
  }
}