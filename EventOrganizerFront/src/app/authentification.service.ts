import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class AuthentificationService {
  isConnected : boolean = false; 
  login() {
    localStorage.setItem("isAuthenticated", "true");
  }

  logout() {
    localStorage.setItem("isAuthenticated", "false");
  }
  
  isAuthenticated() : boolean {
    const isAuthenticated = localStorage.getItem('isAuthenticated');
    return this.isConnected = isAuthenticated === 'true';
  }
  
  constructor() { }
}
