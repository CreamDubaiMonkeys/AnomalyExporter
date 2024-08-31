import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { HomeComponent } from './home/home.component';
import { ListEventComponent } from './list-event/list-event.component';
import { LoginGuard } from './login.guard';
import { LogoutGuard } from './logout.guard';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventFormComponent } from './event-form/event-form.component';

const AppRoutingModule: Routes = [

    { path: '', component: LoginComponent, canActivate: [LoginGuard] },
    { path: 'inscription', component: InscriptionComponent, canActivate: [LoginGuard] },
    { path: 'calendar', component: HomeComponent, canActivate: [LogoutGuard] },
    { path: 'homelist', component: ListEventComponent, canActivate: [LogoutGuard] },
    { path: 'event/:id', component: EventDetailsComponent, canActivate: [LogoutGuard] },
    { path: 'create-event', component: EventFormComponent, canActivate: [LogoutGuard]}

];
export default AppRoutingModule;