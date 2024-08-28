import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { RouterModule } from '@angular/router';
import { CalendarModule } from './calendar/calendar.module';
import { NavbarComponent } from './navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { AuthentificationService } from './authentification.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, InscriptionComponent, RouterModule, LoginComponent, NavbarComponent, CalendarModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'EventOrganizerFront';
  constructor(private authService: AuthentificationService ){}
  
  isNavbarVisible(): boolean { 
    return this.authService.isAuthenticated();
  }
}
