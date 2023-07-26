import { Component } from '@angular/core';
import { empData } from './Employee/employe-data';
import { Employee } from './Employee/employee';
@Component({
  selector: 'app-component',
  //templateUrl: 'app.component.html',
  template: `<emp-list2></emp-list2>`,
 
 
 
	//template: `{{ myName | reverse}}`,
  styles:[]

 
})
export class AppComponent {
  title = 'Arsenal-angular';
  myName:string = "Stephen Salvatore";
  myarr:number[]=[10,20,30,0,33,0];
  emp:Employee = new Employee(101, "Ajay", 2500,4);
  //salary:number = 2500;
  doj: Date = new Date();
  share:number = 25.00;
  childMessage:string="";
  receiveMessage(message:string){
	this.childMessage = " " +message;
  }




}


