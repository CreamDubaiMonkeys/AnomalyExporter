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
  };

  constructor(private webApiService: WebApiService) {}

  getAllEvents() {
    return this.webApiService.get(this.httpLinks.getAllEvents);
  }
  getEventByUserId(id: number) {
    return this.webApiService.get(this.httpLinks.getAllEvents + '/' + id);
  }
  getHistoryEvents(id: number) {
    return this.webApiService.get(this.httpLinks.getAllEvents + '/' + id);
  }
  getEventById(id: number) {
    return this.webApiService.get(this.httpLinks.getEvent + '/' + id);
  }
  postUserSubscribe(data: RegisterUser) {
    return this.webApiService.post(this.baseUrl + '/auth/register', data);
  }

}
