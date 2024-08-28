import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthentificationService } from '../service/authentification.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  constructor(private router: Router, private authenService : AuthentificationService) {}
  onSubmit(form: NgForm) {
    console.log(form.value);
    this.authenService.login();
    this.router.navigate(['/calendar']);
  }

}
