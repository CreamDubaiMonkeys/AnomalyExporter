import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../service/authentification.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  nomUtilisateur: string = "";
  
  constructor(private authservice : AuthentificationService, private router: Router){}

  ngOnInit() {
    this.nomUtilisateur = this.authservice.getUsername();
  }
  logout() {
    this.authservice.logout();
    this.router.navigate(['']); 
  }

}
