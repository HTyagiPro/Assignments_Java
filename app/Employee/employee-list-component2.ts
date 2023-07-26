import { AfterViewInit, Component, OnChanges, OnInit, SimpleChanges } from "@angular/core";
import { Employee } from "./employee";
import { EmployeeService } from "./employee.service";

@Component({
    selector: 'emp-list2',
    templateUrl: './employee-list.component2.html'
})
export class EmployeeListComponent2 implements OnChanges, AfterViewInit,OnInit{
    empList:Employee[]=[];
    
    constructor(private employeeService:EmployeeService){
        this.empList = employeeService.getAllEmployee();
    }

deleteEmployee(empid:number){
    for(var i=0; i<this.empList.length; i++){
        if(this.empList[i].empid == empid){
            this.empList.splice(i,1);
            return;
        }
    }
}

addEmployee(emp:Employee){
    this.empList.push(emp);
}


ngOnChanges(changes: SimpleChanges): void {
    console.log("Employee Component 2 Changed");
}
ngOnInit(): void {
    console.log("Employee Component 2 is initialized");
}
ngAfterViewInit(): void {
    console.log("View is initialized.")
}


}