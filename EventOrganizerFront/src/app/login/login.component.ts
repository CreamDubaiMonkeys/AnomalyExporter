import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthentificationServiceService } from '../authentification.service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  constructor(private authService: AuthentificationServiceService, private router: Router) {}
  onSubmit(form: NgForm) {
    console.log(form.value);
    this.login();
  }
  
  isLoggedIn(): boolean {
    return this.authService.isAuthenticated();
  }
  login() {
    this.authService.login();
    this.router.navigate(['/calendar']); 
  }
}
