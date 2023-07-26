import { Pipe, PipeTransform} from '@angular/core';

@Pipe({name:'reverse'})
export class ReverseString implements PipeTransform{
    transform(str:string) {
        var strcp = "";

        for(var i=str.length-1; i>=0;i--)
            strcp += str.charAt(i);
        return strcp;
    }
}