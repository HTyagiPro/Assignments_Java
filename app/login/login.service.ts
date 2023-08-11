import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";

export class LoginService{
    isLoggedIn :boolean = false;
    login(){
        this.isLoggedIn=true;
    }

    logout(){
        this.isLoggedIn = false;
    }

    getIsLoggedIn(){
        return this.isLoggedIn;
    }
    
}