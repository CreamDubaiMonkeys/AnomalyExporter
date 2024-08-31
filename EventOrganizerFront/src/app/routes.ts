import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { HomeComponent } from './home/home.component';
import { ListEventComponent } from './list-event/list-event.component';
import { LoginGuard } from './login.guard';
import { LogoutGuard } from './logout.guard';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventCreateComponent } from './event-create/event-create.component';

const AppRoutingModule: Routes = [

    { path: '', component: LoginComponent, canActivate: [LoginGuard] },
    { path: 'inscription', component: InscriptionComponent, canActivate: [LoginGuard] },
    { path: 'calendar', component: HomeComponent, canActivate: [LogoutGuard] },
    { path: 'homelist', component: ListEventComponent, canActivate: [LogoutGuard] },
    { path: 'event/:id', component: EventDetailsComponent, canActivate: [LogoutGuard] },
    { path: 'eventcreate', component: EventCreateComponent}

];
export default AppRoutingModule;