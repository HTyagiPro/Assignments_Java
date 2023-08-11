import { Component, OnInit } from "@angular/core";
import { TrainService } from "./train.service";

@Component({
    selector: 'train-list',
    templateUrl: './train-list.component.html',
    providers: [TrainService] 
})

export class TrainListComponent implements OnInit{
    trainList:any[] = [];
    constructor(private trainService:TrainService){}

    ngOnInit(): void {
        this.trainService.getAllTrainDetails().subscribe((data)=> this.trainList = data);
    }

}