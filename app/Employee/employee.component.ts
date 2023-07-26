import { Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges } from "@angular/core";
import { Employee } from "./employee";

@Component({
    selector: 'emp-component',
    template: `<table width = 30% border="1">
                <tr>
                    <th>Employee ID: </th>
                    <td>{{eobj.empid}}</td>
                </tr>
                <tr>
                    <th>Employee Name: </th>
                    <td>{{eobj.ename}}</td>
                </tr>
                <tr>
                    <th>Employee Salary: </th>
                    <td>{{eobj.esal}}</td>
                </tr>
                <tr>
                    <th>Employee Department No.: </th>
                    <td>{{eobj.edeptNo}}</td>
                </tr>
                <tr>
                    <th>Action: </th>
                    <td><input type="button" value="Delete" (click)="delete(eobj.empid)"></td>
                </tr>
                </table>
              `
})
export class EmployeeComponent implements OnInit, OnDestroy, OnChanges{
    @Input()
    eobj:any = new Employee(0,"",0,0);

    @Output()
    deleteEvent:EventEmitter<number> = new EventEmitter<number>();

    delete(empid:number){
        this.deleteEvent.emit(empid);
    }

    ngOnInit(){
        console.log("Employee Component is initialized");
    }

    ngOnDestroy(){
        console.log('Employee component deleted.')
    }

    ngOnChanges(changes: SimpleChanges): void {
        console.log("Employee Component Changed")
    }
}