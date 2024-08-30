import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RegisterUser } from '../interface/user';
import { HttpProviderService } from '../service/http-provider.service';
import { AuthentificationService } from '../service/authentification.service';

@Component({
    selector: 'app-inscription',
    standalone: true,
    imports: [CommonModule, FormsModule, RouterModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule],
    templateUrl: './inscription.component.html',
    styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
    hide = signal(true);

    constructor(private httpProviderService: HttpProviderService, private authService: AuthentificationService, private router: Router) { }

    onSubmit(form: NgForm): void {
        const userToRegister: RegisterUser = {
            username: form.value.username,
            password: form.value.password,
            email: form.value.email,
            first_name: form.value.first_name,
            last_name: form.value.last_name,
        };

        this.httpProviderService.postUserSubscribe(userToRegister).subscribe(
            (res) => {
                console.log('User registered:', res);
                this.authService.login();
                this.router.navigate(['/calendar']);
            },
            (error) => {
                console.error('Error registering user:', error);
            }
        );


    }


}
