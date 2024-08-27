import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { RouterModule } from "@angular/router";

import { AppComponent } from "./app.component";
import { EventCreateComponent } from "./components/event-create/event-create.component";
import { EventService } from "./services/event.service";
import { routes } from "./app.routes";
import {  MatSelect } from "@angular/material/select";
import { CommonModule } from "@angular/common";

NgModule({
    declarations: [
        AppComponent,
        EventCreateComponent
        
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelect,
        CommonModule,
        RouterModule.forRoot(routes)
    ],
    providers: [
        EventService
    ],
    bootstrap: [AppComponent]
})


export class AppModule{}