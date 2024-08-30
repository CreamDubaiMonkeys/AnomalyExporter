import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DayPilot } from '@daypilot/daypilot-lite-angular';
import { HttpProviderService } from '../service/http-provider.service';

@Injectable()
export class DataService {

  //TODO: must be handled by seccion service
  httpOptionsParams = {
    id: '1',
  };
  myEvents: any[] = [];


  convertEvent(myEvent: any) {
    const finalEndDate = new DayPilot.Date(new Date(myEvent.date + 'T' + myEvent.time)).addHours(5); 
    return {
      id: myEvent.id,
      text: myEvent.title,
      start: myEvent.date + 'T' + myEvent.time,
      end: finalEndDate, // use dayPilotEnd variable
      participans: myEvent.capacity,
    };
  }

  eventListConverter(myEventList: any) {
    let events = [];
    for (let i = 0; i < myEventList.length; i++) {
      events.push(this.convertEvent(myEventList[i]));
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

  constructor(private httpProvider: HttpProviderService) {}

  getEvents(from: DayPilot.Date, to: DayPilot.Date): Observable<any[]> {
    this.httpProvider.getEventByUserId(this.httpOptionsParams).subscribe(
      (res: any) => {
        this.myEvents = this.eventListConverter(res.body);
      },
      (error) => {
        console.error('Error fetching compartiments:', error);
      }
    );
    return new Observable((observer) => {
      setTimeout(() => {
        observer.next(this.myEvents);
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
