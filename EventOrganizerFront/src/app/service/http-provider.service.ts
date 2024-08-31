import { Injectable } from '@angular/core';
import { WebApiService } from './web-api.service';
import { LoginUser, RegisterUser } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class HttpProviderService {
  private baseUrl = 'http://localhost:8080';
  private httpLinks = {
    getEvent: this.baseUrl + '/events',
    getAllEvents: this.baseUrl + '/events/all',
    getAllPublicEvents: this.baseUrl + '/events/all_public_events_except_mine',
    authBaseUrl: this.baseUrl + '/auth',
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
  getEventById(id: number) {
    return this.webApiService.get(
      this.httpLinks.getEvent + '/' + id
    );
  }
  postUserSubscribe(data: RegisterUser) {
    return this.webApiService.post(this.httpLinks.authBaseUrl + '/register', data);
  }
  postUserLogin(data: LoginUser){
    return this.webApiService.post(this.httpLinks.authBaseUrl + '/login', data)
  }
}
