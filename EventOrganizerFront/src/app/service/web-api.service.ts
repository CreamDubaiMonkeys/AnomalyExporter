import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WebApiService {
  httpOptions: Object

  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Cache-Control': 'no-cache',
        Pragma: 'no-cache',
      }),
      observe: 'response' as 'body',
    }
  }

  get(url: string): Observable<any> {
    return this.httpClient.get(url, this.httpOptions);
  }

  post(url: string, body: Object): Observable<any> {
    return this.httpClient.post(url, body, this.httpOptions)
  } 
}
