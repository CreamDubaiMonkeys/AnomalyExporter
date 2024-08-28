import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { RouterModule } from "@angular/router";

import { AppComponent } from "./app.component";

import { routes } from "./app.routes";
import {  MatSelect } from "@angular/material/select";
import { CommonModule } from "@angular/common";
import { EventCreateComponent } from "./event-create/event-create.component";
import { WebApiService } from "./service/web-api.service";

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
        WebApiService
    ],
    bootstrap: [AppComponent]
})


export class AppModule{}