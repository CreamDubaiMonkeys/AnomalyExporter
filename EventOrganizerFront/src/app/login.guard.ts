import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthentificationServiceService } from './authentification.service.service';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LoginGuard implements CanActivate {
    constructor(private authservice: AuthentificationServiceService, private router: Router) {}
    
    canActivate() {
        if (this.authservice.isAuthenticated()) {
            this.router.navigate(['/calendar']);   
            return false;
        } else {
            return true; 
        }
    }
}
