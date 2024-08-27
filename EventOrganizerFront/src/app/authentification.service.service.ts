import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class AuthentificationServiceService {
  private isLoggedIn = false;

  login() {
    this.isLoggedIn = true;
  }

  logout() {
    this.isLoggedIn = false;
  }

  isAuthenticated(): boolean {
    return this.isLoggedIn;
  }
  constructor() { }
}
