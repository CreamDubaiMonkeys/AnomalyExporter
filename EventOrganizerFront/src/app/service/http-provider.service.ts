import { Injectable } from '@angular/core';
import { WebApiService } from './web-api.service';
import { RegisterUser } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class HttpProviderService {
  private baseUrl = 'http://localhost:8080';
  private httpLinks = {
    getEvent: this.baseUrl+'/events',
    getAllEvents: this.baseUrl + '/events/all',
    getAllPublicEvents: this.baseUrl + '/events/all_public_events_except_mine',
    getHistoryEvents: this.baseUrl + '/events/all',
  };

  constructor(private webApiService: WebApiService) {}

  getAllPublicEvents(id: number) {
    return this.webApiService.get(this.httpLinks.getAllPublicEvents, id);
  }
  getEventByUserId(id: number) {

    return this.webApiService.get(this.httpLinks.getAllEvents, id);

  }
  getHistoryEvents(id: number) {
    return this.webApiService.get(this.httpLinks.getHistoryEvents, id);
  }
  getEventById(id: number) {
    return this.webApiService.get(this.httpLinks.getEvent + '/' + id);
  }
  postUserSubscribe(data: RegisterUser) {
    return this.webApiService.post(this.baseUrl + '/auth/register', data);
  }

}
