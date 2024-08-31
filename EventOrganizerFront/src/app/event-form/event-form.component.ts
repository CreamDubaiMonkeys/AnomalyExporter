import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCard, MatCardContent } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { HttpProviderService } from '../service/http-provider.service';
import { RegisterEvent } from '../interface/event';
import { Router } from '@angular/router';

@Component({
    selector: 'app-event-form',
    standalone: true,
    imports: [CommonModule, MatCardContent, MatCard, MatInputModule, MatFormFieldModule, MatButtonModule, MatDatepickerModule, MatNativeDateModule, MatCheckboxModule, MatSelectModule, MatSliderModule, ReactiveFormsModule],
    templateUrl: './event-form.component.html',
    styleUrl: './event-form.component.css'
})
export class EventFormComponent implements OnInit {
    eventForm!: FormGroup;
    queryData?: RegisterEvent;

    constructor(private fb: FormBuilder, private httpProviderService: HttpProviderService, private router: Router ) {
    }

    ngOnInit(): void {
        this.eventForm = this.fb.group({
            title: ['', Validators.required],
            description: ['', Validators.required],
            date: ['', Validators.required],
            time: ['', Validators.required],
            capacity: [0, [Validators.required, Validators.min(1)]],
            private: [false],
            location: ['', Validators.required]
        });
    }

    onSubmit() {
        if (this.eventForm.valid) {
            console.log('Form Submitted', this.eventForm.value);

            const timeValue = this.eventForm.get('time')?.value ? `${this.eventForm.get('time')?.value}:00` : "00:00:00";
            
            this.queryData = {
                creatorId: parseInt(localStorage.getItem('sessionUserId') || '0', 10),
                title: this.eventForm.get('title')?.value,
                description: this.eventForm.get('description')?.value,
                date: this.eventForm.get('date')?.value,
                time: timeValue,
                capacity: this.eventForm.get('capacity')?.value,
                location: this.eventForm.get('location')?.value,
                is_private: this.eventForm.get('private')?.value
            }

            console.log('Data sent:', this.queryData);
            
            this.httpProviderService.postEvent(this.queryData).subscribe(
                (res) => {
                    console.log('Event registered', res.body);
                    this.router.navigate(['/calendar'])
                },
                (error) => {
                    console.error('Error registering event', error)
                }
            )
        }
    }
}
