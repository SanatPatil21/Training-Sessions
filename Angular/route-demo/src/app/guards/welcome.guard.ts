import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn } from '@angular/router';
import { RoleService } from '../services/role.service';

@Injectable({
  providedIn: 'root'
})

export class WelcomeGuard implements CanActivate {

  constructor(private roleServ: RoleService) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: any) {
    if(route.data[0]==this.roleServ.role){
      return true;
    }
    else
      return false;
  }

}

