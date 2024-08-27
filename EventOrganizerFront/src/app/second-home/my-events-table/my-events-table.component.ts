import { CommonModule } from '@angular/common';
import { Component, Input, OnChanges, OnInit, SimpleChange, SimpleChanges } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-my-events-table',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, CommonModule],
  templateUrl: './my-events-table.component.html',
  styleUrl: './my-events-table.component.css',
})
export class MyEventsTableComponent implements OnInit, OnChanges {
  @Input() events: any[] = [];
  dataSource = new MatTableDataSource();

  //displayedColumns: string[] = ['description', 'date', 'time', 'capacity', 'created_at', 'updated_at', 'title', 'location']
  displayedColumns: string[] = [
    'title',
    'date',
    'time',
    'capacity',
    'created_at',
    'updated_at',
    'title',
    'location',
  ];
  ngOnInit() {
    this.initializeDataSource();
  }
  ngOnChanges(changes:SimpleChanges) {
    if(changes['events']) {
      this.initializeDataSource();
    }
  }
  initializeDataSource() {
    if (this.events) {
      console.log('Events:', this.events);
      this.dataSource.data = this.events;

    }
  }
}
