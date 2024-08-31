import { CommonModule } from '@angular/common';
import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'events-table',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, CommonModule],
  templateUrl: './events-table.component.html',
  styleUrl: './events-table.component.css',
})
export class EventsTableComponent<T> implements OnInit, OnChanges {
  @Input() showFilter: boolean = false;
  @Input() events: T[] = [];
  @Input() displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<T>();

  constructor(private router: Router) {}

  ngOnInit() {
    this.initializeDataSource();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['events']) {
      this.initializeDataSource();
    }
  }

  initializeDataSource() {
    if (this.events) {
      this.dataSource.data = this.events;
      this.dataSource.filterPredicate = (data: T, filter: string) => {
        const dataStr = Object.keys(data as object)
          .reduce((currentTerm, key) => {
            return (
              currentTerm +
              ((data[key as keyof T] &&
                String(data[key as keyof T]).toLowerCase()) ||
                '') +
              ' '
            );
          }, '')
          .trim();

        return dataStr.indexOf(filter) != -1;
      };
    }
  }

  // used to filter the data
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    console.log('Filter Value:', filterValue); // Log the filter value to verify
  }

  goToEventDetails(event: T) {
    // logic to navigate to the event details page with the event id as param
    this.router.navigate(['/event-details', (event as any).id]);
    
  }
}
