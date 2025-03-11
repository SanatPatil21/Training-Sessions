import { Component } from '@angular/core';
import { DemoServiceService } from '../demo-service.service';

@Component({
  selector: 'app-demo-comp',
  standalone: false,
  templateUrl: './demo-comp.component.html',
  styleUrl: './demo-comp.component.css'
})
export class DemoCompComponent {

  constructor(private demoService:DemoServiceService){

  }

  ngOnInit():void{
    this.method()

  }
  method(){
    this.demoService.doSomeTask();
  }

  

}
