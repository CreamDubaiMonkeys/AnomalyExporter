import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DayPilot } from '@daypilot/daypilot-lite-angular';
import { HttpClient } from '@angular/common/http';
import { HttpProviderService } from '../service/http-provider.service';

@Injectable()
export class DataService {
  myEvents: any[] = [];
  convertEvent(myEvent: any) {
    return {
      id: myEvent.id,
      text: myEvent.title,
      start: myEvent.date + 'T' + myEvent.time,
      end: myEvent.date + 'T' + myEvent.time,
      participans: myEvent.capacity,
    };
  }
  eventConverter(myEvent: any, events: any) {
    for (let i = 0; i < myEvent.length; i++) {
      events.push(this.convertEvent(myEvent[i]));
      console.log("pushed event:", this.convertEvent(myEvent[i]));
    }
    return events;
  }
  static colors = {
    green: '#6aa84f',
    yellow: '#f1c232',
    red: '#cc4125',
    gray: '#808080',
    blue: '#2e78d6',
  };

  events = [
    {
      id: 1,
      text: 'Event 1',
      start: DayPilot.Date.today().firstDayOfWeek().addHours(10),
      end: DayPilot.Date.today().firstDayOfWeek().addHours(13),
      participants: 2,
    },
    {
      id: 2,
      text: 'Event 2',
      start: DayPilot.Date.today().firstDayOfWeek().addDays(1).addHours(12),
      end: DayPilot.Date.today().firstDayOfWeek().addDays(1).addHours(15),
      backColor: DataService.colors.green,
      participants: 1,
    },
    {
      id: 3,
      text: 'Event 3',
      start: DayPilot.Date.today().firstDayOfWeek().addDays(2).addHours(13),
      end: DayPilot.Date.today().firstDayOfWeek().addDays(2).addHours(16),
      backColor: DataService.colors.yellow,
      participants: 3,
    },
    {
      id: 4,
      text: 'Event 4',
      start: DayPilot.Date.today().firstDayOfWeek().addDays(3).addHours(11),
      end: DayPilot.Date.today().firstDayOfWeek().addDays(3).addHours(15),
      backColor: DataService.colors.red,
      participants: 4,
    },
  ];

  constructor(private httpProvider: HttpProviderService) {}

  getEvents(from: DayPilot.Date, to: DayPilot.Date): Observable<any[]> {
    // simulating an HTTP request
    this.httpProvider.getEventById(1).subscribe(
      (res: any) => {
        this.myEvents = res.body;
        this.myEvents=this.eventConverter(this.myEvents, this.events);
        console.log('this is SENT EVENTS:', this.myEvents);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
    return new Observable((observer) => {
      setTimeout(() => {
        observer.next( this.myEvents  );
      }, 2000);
    });

    // return this.http.get("/api/events?from=" + from.toString() + "&to=" + to.toString());
  }

  getColors(): any[] {
    const colors = [
      { name: 'Green', id: DataService.colors.green },
      { name: 'Yellow', id: DataService.colors.yellow },
      { name: 'Red', id: DataService.colors.red },
      { name: 'Gray', id: DataService.colors.gray },
      { name: 'Blue', id: DataService.colors.blue },
    ];
    return colors;
  }
}
