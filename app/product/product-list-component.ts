import { Component, OnInit } from "@angular/core";
import { ProductService } from "./product.service";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
    selector: 'product-list',
    //template: `<img [src]="imageUrl">`,
    templateUrl: './product-list.component.html',
    providers: [ProductService] 
})

export class ProductListComponent implements OnInit{
    productList:any[] = [];
    constructor(private productService:ProductService, private router:Router, private activeRoute:ActivatedRoute){}

    ngOnInit(): void {
        this.productService.getAllProductDetails().subscribe((data)=> this.productList = data);
    }

    goToRoute(productName:string){
        this.router.navigate(['productImage', productName], {relativeTo:this.activeRoute});
    }

    /*
    getImage(imageName:string){
        alert(imageName);
    }
    */
}