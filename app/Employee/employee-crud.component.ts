import { Component, EventEmitter, Output } from "@angular/core";
import { Employee } from "./employee";

@Component({
    selector: 'emp-crud',
    templateUrl: 'employee-crud.component.html'
})

export class EmployeeCrudComponent{

    @Output()
    addEmployeeEvent:EventEmitter<Employee>  =  new EventEmitter<Employee>();
    
    emp:Employee = new Employee(0,"",0,0);

    addEmployee(empid:string, ename:string, esal:string, edeptNo:string){
        this.addEmployeeEvent.emit(new Employee(parseInt(empid), ename, parseFloat(esal), parseInt(edeptNo)));
    }


}