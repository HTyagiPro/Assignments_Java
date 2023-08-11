import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { EmployeeListComponent } from './employee-list.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeeService } from './employee.service';
import { SalaryRange } from './rangeSalary.pipe';
import { EmployeeListComponent2 } from './employee-list-component2';
import { EmployeeComponent } from './employee.component';
import { EmployeeCrudComponent } from './employee-crud.component';
import { EmployeeRouteService } from './employee-route.service';

@NgModule({
    declarations: [EmployeeListComponent, SalaryRange, EmployeeListComponent2, EmployeeComponent, EmployeeCrudComponent],
    imports: [FormsModule, CommonModule],
    exports:[EmployeeListComponent, EmployeeListComponent2],
    providers: [EmployeeService , EmployeeRouteService]
  })

  export class EmployeeModule{

  }