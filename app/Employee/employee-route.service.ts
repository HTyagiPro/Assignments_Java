import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { LoginService } from "../login/login.service";
import { Injectable } from "@angular/core";

@Injectable()
export class EmployeeRouteService implements CanActivate{

    constructor(private loginService:LoginService){}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        return this.loginService.getIsLoggedIn();
    }
    
}