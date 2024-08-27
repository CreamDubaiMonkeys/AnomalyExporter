import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { HomeComponent } from './home/home.component';
import { SecondHomeComponent } from './second-home/second-home.component';

const AppRoutingModule: Routes = [
  
  { path: '', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'calendar', component: HomeComponent},
  {path: 'homelist', component: SecondHomeComponent},

];
export default AppRoutingModule;