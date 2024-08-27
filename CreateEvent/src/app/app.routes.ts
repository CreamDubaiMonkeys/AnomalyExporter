import { Routes } from '@angular/router';
import { EventCreateComponent } from './components/event-create/event-create.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
    {path: '', component: AppComponent},
    {path:'event-create', component: EventCreateComponent},
];
