import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthentificationService } from './authentification.service';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LogoutGuard implements CanActivate {
    constructor(private authservice: AuthentificationService, private router: Router) {}
    
    canActivate() {
        if (!this.authservice.isAuthenticated()) {
            this.router.navigate(['']);   
            return false;
        } else {
            return true; 
        }
    }
}