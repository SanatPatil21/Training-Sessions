import { CommonModule, CurrencyPipe } from '@angular/common';
import { Component, Pipe } from '@angular/core';

@Component({
  selector: 'app-inbuilt-pipes',
  imports: [CommonModule],
  templateUrl: './inbuilt-pipes.component.html',
  styleUrl: './inbuilt-pipes.component.css'
})
export class InbuiltPipesComponent {

  str:string ="Hello Everybody";
  amt:number=2000;
  date:Date=new Date();

}
