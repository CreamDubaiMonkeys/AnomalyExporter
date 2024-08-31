import { Injectable } from '@angular/core';
import { WebApiService } from './web-api.service';
import { LoginUser, RegisterUser } from '../interface/user';
import { RegisterEvent } from '../interface/event';

@Injectable({
  providedIn: 'root',
})
export class HttpProviderService {
  private baseUrl = 'http://localhost:8080';
  private httpLinks = {
    eventBaseUrl: this.baseUrl + '/events',
    getAllEvents: this.baseUrl + '/events/all',
    getAllPublicEvents: this.baseUrl + '/events/all_public_events_except_mine',
    authBaseUrl: this.baseUrl + '/auth',
    getAllUserNames: this.baseUrl + '/users/user_names',
  };

  constructor(private webApiService: WebApiService) {}

  getAllPublicEvents(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getAllPublicEvents,
      httpOptionsParams
    );
  }
  getEventByUserId(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getAllEvents,
      httpOptionsParams
    );
  }
  getHistoryEvents(httpOptionsParams: any) {
    return this.webApiService.get(
      this.httpLinks.getAllEvents,
      httpOptionsParams
    );
  }
  getEventById(id: number) {
    return this.webApiService.get(this.httpLinks.eventBaseUrl + '/' + id);
  }
  getParticipents(httpOptionsParams: any) {
    return this.webApiService.get(this.httpLinks.getAllUserNames,httpOptionsParams);
  }

  postUserSubscribe(data: RegisterUser) {
    return this.webApiService.post(
      this.httpLinks.authBaseUrl + '/register',
      data
    );
  }
  postUserLogin(data: LoginUser) {
    return this.webApiService.post(this.httpLinks.authBaseUrl + '/login', data);
  }

  postEvent(data: RegisterEvent) {
    return this.webApiService.post(
      this.httpLinks.eventBaseUrl + '/create',
      data
    );
  }
}
