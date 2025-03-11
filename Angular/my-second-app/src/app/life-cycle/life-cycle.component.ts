import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-life-cycle',
  imports: [],
  templateUrl: './life-cycle.component.html',
  styleUrl: './life-cycle.component.css'
})
export class LifeCycleComponent implements OnInit {

  constructor(){
    console.log('constructor() called');    
  }

  ngOnInit(): void {
    console.log('ngOnInit() called');
  }

}
