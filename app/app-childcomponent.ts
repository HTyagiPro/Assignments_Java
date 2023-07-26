import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
    selector: 'app-childcomponent',
    template: `<h1>Message from parent is {{pmessage}}</h1><br>
    <input type='button' value="Send Message" (click)="sendMessage()">`
})
export class AppChildComponent{
    @Input()  //indicates following component gets input from its parent component.
    pmessage:string='';

    @Output()
    childEvent= new EventEmitter<string>();

    sendMessage(){
        this.childEvent.emit("Hello Parent");
    }
}