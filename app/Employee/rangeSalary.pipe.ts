import { Pipe, PipeTransform} from '@angular/core';
import { Employee } from './employee';

@Pipe({name:'salaryRange'})
export class SalaryRange implements PipeTransform{
    transform(value: Employee[]){
        var elist2:Employee[] = [];
        var ptr=0;
        for(var i =0;i<=value.length;i++){
            if(value[i].esal>=1000 && value[i].esal<=5000){
                elist2.push(value[i]) ;
                ptr++;
            }
        }
        return elist2;
        
    }
}