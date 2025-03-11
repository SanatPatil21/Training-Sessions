import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[myColor]'
})
export class MyColorDirective {

  constructor(private element:ElementRef) { 
    this.element.nativeElement.style.color="red";

  }
}
