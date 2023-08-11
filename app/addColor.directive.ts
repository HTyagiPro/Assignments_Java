import { Directive, ElementRef, HostBinding, HostListener } from "@angular/core";

@Directive({
    selector: '[addColor]'
})
export class AddColorDirective{
    
    /*
    constructor(private elementref:ElementRef){
        this.elementref.nativeElement.style.backgroundColor = 'red';
    }
    */
    
    /*
    addColors(color:string){
        this.elementref.nativeElement.style.color=color;
    }
    */


    @HostBinding('style.backgroundColor')bgColor:string="";

    @HostListener('mouseover')
    onMouseOver(){
        this.bgColor = 'red';
    }

    @HostListener('mouseleave')
    onMouseLeave(){
        this.bgColor = 'green';
    }
}