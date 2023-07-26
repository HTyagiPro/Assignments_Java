import { Component } from "@angular/core";
import { empData } from "./employe-data";
import { Employee } from "./employee";
import { EmployeeService } from "./employee.service";


@Component({
    selector: 'emp-list',
    templateUrl: './employee-list.component.html'
    //template: `{{ empdata | salaryRange}}`,
})

export class EmployeeListComponent{
    empdata:Employee[] = empData;
    public constructor(private employeeService:EmployeeService) {
        this.elist = employeeService.getAllEmployee()
    }
    
    elist :Employee[] = empData;
    public deleteEmployeeRow(index:number){

        this.elist.splice(index,1);
      }
}