import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';

const AppRoutingModule: Routes = [
  { path: '', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent }
];
export default AppRoutingModule;