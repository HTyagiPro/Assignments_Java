import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class TrainService{
    constructor(private httpClient: HttpClient){
        this.httpClient = httpClient;
    }

    public getAllTrainDetails(): Observable<any>{
        return this.httpClient.get("http://localhost:8089/train/");
    }

    public getTrainById(trainId:number) :Observable<any>{
        return this.httpClient.get("http://localhost:8089/train/"+trainId);
    }
}