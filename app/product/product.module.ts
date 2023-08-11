import { NgModule } from "@angular/core";
import { ProductService } from "./product.service";
import { ProductListComponent } from "./product-list-component";
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { ProductImageComponent } from "./product-image.component";
import { RouterOutlet } from "@angular/router";

@NgModule({
    declarations:[ProductListComponent, ProductImageComponent],
    imports:[HttpClientModule, CommonModule,RouterOutlet],
    exports:[ProductListComponent, ProductImageComponent],
    providers:[ProductService]

})
export class ProductModule{

}