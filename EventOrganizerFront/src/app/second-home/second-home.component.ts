import { Component, OnInit } from '@angular/core';
import { MyEventsTableComponent } from './my-events-table/my-events-table.component';
import { HttpProviderService } from '../service/http-provider.service';

@Component({
  selector: 'app-second-home',
  standalone: true,
  imports: [MyEventsTableComponent],
  templateUrl: './second-home.component.html',
  styleUrl: './second-home.component.css',
})
export class SecondHomeComponent implements OnInit {
  events: any[] = [];

  constructor(private httpProviderService: HttpProviderService) {}
  ngOnInit():void {
    this.LoadEvents();
  }
  LoadEvents() {
    this.httpProviderService.getAllEvents().subscribe(
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
