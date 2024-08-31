import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class AuthentificationService {
    isConnected: boolean = false;

    constructor() {}

    login(userId: number, userName: string) {
        localStorage.setItem("sessionUserName", userName);
        localStorage.setItem("sessionUserId", userId.toString())
    }

    logout() {
        localStorage.clear();
    }

    isAuthenticated(): boolean {
        return Boolean(localStorage.getItem('sessionUserName') && localStorage.getItem('sessionUserId'));
    }

}
