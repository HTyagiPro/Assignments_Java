import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, ParamMap, Params, RouterOutlet } from "@angular/router";

@Component({
    selector:'product-image',
    templateUrl:'./product-image.component.html'

})
export class ProductImageComponent implements OnInit{
    imageUrl : any;
    constructor(private activatedRoute:ActivatedRoute){}
    ngOnInit(): void {
        this.imageUrl = this.activatedRoute.snapshot.paramMap.get('productName');
        console.log(this.imageUrl)
        this.imageUrl = "assets/"+this.imageUrl+".jpg";
        
    }
}