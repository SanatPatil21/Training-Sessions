import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: '[appMyEvent]'
})
export class MyEventDirective {

  constructor() { }

  @HostListener('click')
  onClick() {
    console.log('clicked');
  }


}
