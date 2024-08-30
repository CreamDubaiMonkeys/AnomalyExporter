import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DayPilot } from '@daypilot/daypilot-lite-angular';
import { HttpProviderService } from '../service/http-provider.service';

@Injectable()
export class DataService {
  myEvents: any[] = [];
  convertEvent(myEvent: any) {
    // create a date time object with myEvent.date and myEvent.time and add two hours to it
    const end = new Date(myEvent.date + 'T' + myEvent.time);
    const dayPilotEnd = new DayPilot.Date(end); // declare dayPilotEnd variable
    const End = dayPilotEnd.addHours(5); // add two hours to dayPilotEnd variable
    return {
      id: myEvent.id,
      text: myEvent.title,
      start: myEvent.date + 'T' + myEvent.time,
      end: End, // use dayPilotEnd variable
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
  
  ];

  constructor(private httpProvider: HttpProviderService) {}

  getEvents(from: DayPilot.Date, to: DayPilot.Date): Observable<any[]> {
    this.httpProvider.getEventById(1).subscribe(
      (res: any) => {
        this.myEvents = res.body;
        this.myEvents=this.eventConverter(this.myEvents, this.events);
      
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
    return new Observable((observer) => {
      setTimeout(() => {
        observer.next( this.myEvents  );
      }, 200);
    });
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
