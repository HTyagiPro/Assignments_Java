import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { EmployeeModule } from "./Employee/employee.module";
import { SquarePipe } from './Square.pipe';
import { ReverseString } from './reverseString.pipe';
import { AppChildComponent } from './app-childcomponent';
import { AddColorDirective } from './addColor.directive';

import { BookModule } from './book/book.module';
import { RouterLink } from '@angular/router';
import { TrainModule } from './train/train.module';
import { ProductModule } from './product/product.module';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';

@NgModule({
    declarations: [
        AppComponent,
        SquarePipe,
        ReverseString,
        AppChildComponent,
        AddColorDirective,
        LoginComponent,
        
    ],
    providers: [LoginService],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        EmployeeModule,
        BookModule, 
        RouterLink,
        TrainModule,
        ProductModule
    ]
})
export class AppModule { }
