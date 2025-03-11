import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoServiceService {

  constructor() { }

  doSomeTask(){
    console.log("Did Some Task....");
  }
}
