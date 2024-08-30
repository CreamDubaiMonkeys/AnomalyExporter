import { Injectable } from '@angular/core';
import { WebApiService } from './web-api.service';
import { RegisterUser } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class HttpProviderService {
  private baseUrl = 'http://localhost:8080';
  private httpLinks = {
    getEvent: this.baseUrl + '/events',
    getAllEvents: this.baseUrl + '/events/all',
    getAllPublicEvents: this.baseUrl + '/events/all_public_events_except_mine',
  };

  constructor(private webApiService: WebApiService) {}

  getAllPublicEvents(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getAllPublicEvents,
      httpOptionsParams
    );
  }
  getEventByUserId(httpOptionsParams: any) {
    return this.webApiService.get(this.httpLinks.getAllEvents, httpOptionsParams);
  }
  getHistoryEvents(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getAllEvents,
      httpOptionsParams
    );
  }
  getEventById(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getEvent + '/' + httpOptionsParams
    );
  }
  postUserSubscribe(data: RegisterUser) {
    return this.webApiService.post(this.baseUrl + '/auth/register', data);
  }
}
