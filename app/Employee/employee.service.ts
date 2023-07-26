import { Component } from "@angular/core";
import { empData } from "./employe-data";
import { Employee } from "./employee";


export class EmployeeService{

    public getAllEmployee(): Employee[]{
        return empData;
    }
    
}