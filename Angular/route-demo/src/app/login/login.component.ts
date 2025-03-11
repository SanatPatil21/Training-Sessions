import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RoleService } from '../services/role.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  msg:string="";

  constructor(private router:Router,private roleServ:RoleService){}

  abc(event:any){
    event.preventDefault();
    let username=event.target.elements[0].value;
    let password=event.target.elements[1].value;
    let role=event.target.elements[2].value;
    this.roleServ.role=role;
    console.log(`Role: `,role);
    
    console.log(username,password);
    if(username==password){
      this.router.navigate(['welcome']);
    }else{
      this.msg="Invalid Credentials";
      // alert("Invalid Credentials");
      this.router.navigate(['login']);
    }
    
  }

}
