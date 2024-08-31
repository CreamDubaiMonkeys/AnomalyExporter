import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthentificationService } from '../service/authentification.service';
import { Router } from '@angular/router';
import { LoginUser } from '../interface/user';
import { HttpProviderService } from '../service/http-provider.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  constructor(private router: Router, private authService : AuthentificationService, private httpProviderService: HttpProviderService) {}
  onSubmit(form: NgForm) {
    const user: LoginUser = {
        identifier: form.value.mail,
        password: form.value.password
    }

    this.httpProviderService.postUserLogin(user).subscribe(
        (res)=>{
            console.log('User logged in:', res.body);
            const payload = res.body.data
            this.authService.login(payload.id, payload.username);
            this.router.navigate(['/calendar']);
        },
        (error)=>{
            console.error('Error while logging in:', error)
        }
    )

    
  }

}
