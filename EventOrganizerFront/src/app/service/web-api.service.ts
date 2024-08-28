import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WebApiService {
  constructor(private httpClient: HttpClient) {}

  get(url: string, id?: number): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Cache-Control': 'no-cache',
        Pragma: 'no-cache',
      }),
      observe: 'response' as 'body',
      params: {},
    };

    if (id) {
      httpOptions.params = {
        id: id.toString(),
      };
    }

    return this.httpClient.get(url, httpOptions);
  }
}
