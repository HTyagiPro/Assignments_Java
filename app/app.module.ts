import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { EmployeeModule } from "./Employee/employee.module";
import { SquarePipe } from './Square.pipe';
import { ReverseString } from './reverseString.pipe';
import { AppChildComponent } from './app-childcomponent';

@NgModule({
    declarations: [
        AppComponent,
        SquarePipe,
        ReverseString,
        AppChildComponent
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        EmployeeModule
    ]
})
export class AppModule { }
