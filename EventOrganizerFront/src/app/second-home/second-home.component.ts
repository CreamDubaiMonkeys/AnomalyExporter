/*import { Component, OnInit } from '@angular/core';
import { MyEventsTableComponent } from './my-events-table/my-events-table.component';
import { HttpProviderService } from '../service/http-provider.service';
import { PublicEventsTableComponent } from './public-events-table/public-events-table.component';

@Component({
  selector: 'app-second-home',
  standalone: true,
  imports: [MyEventsTableComponent, PublicEventsTableComponent],
  templateUrl: './second-home.component.html',
  styleUrl: './second-home.component.css',
})
export class SecondHomeComponent implements OnInit {
  events: any[] = [];
  id = 1;

  constructor(private httpProviderService: HttpProviderService) {}
  ngOnInit():void {
    this.LoadEvents();
  }
  LoadEvents() {
    this.httpProviderService.getEventById(this.id).subscribe(
      (res) => {
        this.events = res.body;
        console.log('Compartiments:', this.events);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
  }
}
*/
import { Component, OnInit } from '@angular/core';
import { HttpProviderService } from '../service/http-provider.service';
import { EventsTableComponent } from './events-table/events-table.component';

@Component({
  selector: 'app-second-home',
  standalone: true,
  imports: [ EventsTableComponent],
  templateUrl: './second-home.component.html',
  styleUrl: './second-home.component.css',
})
export class SecondHomeComponent implements OnInit {
  events: any[] = [];
  displayedColumns: string[] = [
    'title',
    'date',
    'time',
    'capacity',
    'created_at',
    'description',
    'location',
  ];
  id = 1;

  constructor(private httpProviderService: HttpProviderService) {}

  ngOnInit(): void {
    this.LoadEvents();
  }

  LoadEvents() {
    this.httpProviderService.getEventById(this.id).subscribe(
      (res) => {
        this.events = res.body;
        console.log('Compartiments:', this.events);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
  }
}