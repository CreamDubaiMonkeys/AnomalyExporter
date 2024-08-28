import { Injectable } from '@angular/core';
import { WebApiService } from './web-api.service';

@Injectable({
  providedIn: 'root',
})
export class HttpProviderService {
  private baseUrl = 'http://localhost:8080';
  private httpLinks = {
    getAllEvents: this.baseUrl + '/events/all',

  };

  constructor(private webApiService: WebApiService) {}

  getAllEvents() {
    return this.webApiService.get(this.httpLinks.getAllEvents);
  }
  getEventById(id: number) {
    return this.webApiService.get(this.httpLinks.getAllEvents + '/' + id);
  }
  getHistoryEvents(id: number) {
    return this.webApiService.get(this.httpLinks.getAllEvents + '/' + id);
  }
  postUserSubscribe(data: any) {
    return this.webApiService.post(this.baseUrl + '/subscribe', data);
  }

}
