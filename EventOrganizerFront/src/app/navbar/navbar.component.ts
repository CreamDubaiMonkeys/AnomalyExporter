import { Component } from '@angular/core';
import { AuthentificationServiceService } from '../authentification.service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(private authservice : AuthentificationServiceService, private router: Router){}
  logout() {
    this.authservice.logout;
    this.router.navigate(['']); 
  }

}
