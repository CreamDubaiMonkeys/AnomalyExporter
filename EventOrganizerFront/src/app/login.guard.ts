import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthentificationService } from './service/authentification.service';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LoginGuard implements CanActivate {
    constructor(private authservice: AuthentificationService, private router: Router) {}
    
    canActivate() {
        if (this.authservice.isAuthenticated()) {
            this.router.navigate(['/calendar']);   
            return false;
        } else {
            return true; 
        }
    }
}
