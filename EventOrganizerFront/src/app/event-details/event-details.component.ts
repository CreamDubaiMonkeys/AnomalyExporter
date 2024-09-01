import { Component, inject, OnInit } from '@angular/core';
import { HttpProviderService } from '../service/http-provider.service';
import { MatCardModule } from '@angular/material/card';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { CommonModule } from '@angular/common';
import { User } from '../interface/user';
import { Event } from '../interface/event';
import { AuthentificationService } from '../service/authentification.service';
import { MatButton } from '@angular/material/button';

@Component({
    selector: 'app-event-details',
    standalone: true,
    imports: [CommonModule, MatCardModule, RouterModule, MatCardModule, MatIconModule, MatListModule, MatButton],
    templateUrl: './event-details.component.html',
    styleUrl: './event-details.component.css'
})
export class EventDetailsComponent implements OnInit {
    route: ActivatedRoute = inject(ActivatedRoute);
    eventDetailId: number | null = null;
    event: Event | null = null;
    participants: Array<User> = []

    constructor(private httpProviderService: HttpProviderService, private sessionService: AuthentificationService) {
    }

    ngOnInit(): void {
        this.eventDetailId = parseInt(this.route.snapshot.params['id'], 10)
        this.httpProviderService.getEventById(this.eventDetailId).subscribe(
            (res) => {
                this.event = res.body.event;
                console.log('Event', this.event);
                this.participants = res.body.participants;
                console.log('Particpants', this.participants);
            },
            (error) => {
                console.error('Error fetching event:', error);
            }
        )
    }

    userIsAmongParticipants(): boolean {
        for (const user of this.participants) {
            if (user.id === this.sessionService.getId()) {
                return true
            }
        }
        return false
    }

    userIsEventCreator(): boolean {
        return this.event?.creator.id === this.sessionService.getId()
    }
}
