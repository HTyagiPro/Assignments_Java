import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './Employee/employee-list.component';
import { EmployeeListComponent2 } from './Employee/employee-list-component2';
import { BookListComponent } from './book/book-list.component';
import { TrainListComponent } from './train/train-list-component';
import { ProductListComponent } from './product/product-list-component';
import { ProductImageComponent } from './product/product-image.component';
import { EmployeeRouteService } from './Employee/employee-route.service';
import { LoginComponent } from './login/login.component';
const routes: Routes = [
  {component:LoginComponent,path:'app-login'},
  {component:EmployeeListComponent2,path:'emp-list', canActivate:[EmployeeRouteService]},
  {component:BookListComponent,path:'bookList'},
  {component:TrainListComponent,path:'train-list'},
  {component:ProductListComponent,path:'product-list', 
  children:[{component: ProductImageComponent, path:'productImage/:productName'}]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
