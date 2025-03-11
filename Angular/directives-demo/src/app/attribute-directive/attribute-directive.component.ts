import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-attribute-directive',
  imports: [CommonModule],
  templateUrl: './attribute-directive.component.html',
  styleUrl: './attribute-directive.component.css'
})
export class AttributeDirectiveComponent {

  brdrColor: boolean = false;
  bgColor: boolean = false;
  color:string="GREEN";

  toggleBorderColor(){
    this.brdrColor = !this.brdrColor;
  }

  toggleBackgroundColor(){
    this.bgColor = !this.bgColor;
  }

  setColor(clr:string){
    this.color=clr;
  }
  
}
