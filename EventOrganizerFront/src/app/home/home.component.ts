import { Component } from '@angular/core';
import { CalendarModule } from '../calendar/calendar.module';
import { MatTabsModule } from '@angular/material/tabs';
import { ListEventComponent } from '../list-event/list-event.component';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CalendarModule, MatTabsModule, ListEventComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
