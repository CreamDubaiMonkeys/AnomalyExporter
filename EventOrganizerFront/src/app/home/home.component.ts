import { Component } from '@angular/core';
import { CalendarComponent } from '../calendar/calendar.component';
import { CalendarModule } from '../calendar/calendar.module';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CalendarModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
