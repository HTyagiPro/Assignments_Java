import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ProductService{
    constructor(private httpClient: HttpClient){
        this.httpClient = httpClient;
    }

    public getAllProductDetails(): Observable<any>{
        return this.httpClient.get("http://localhost:8089/product/");
    }

    public getProductById(productId:number) :Observable<any>{
        return this.httpClient.get("http://localhost:8089/product/"+productId);
    }
}