import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'power'
})
export class PowerPipe implements PipeTransform {

  transform(value: number, ...args: number[]): number {
    let num = args[0];
    if (num) {
      return Math.pow(value, num);
    }
    return value;
  }

}
