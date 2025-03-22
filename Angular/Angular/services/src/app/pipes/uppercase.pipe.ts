import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uppercase'
})
export class UppercasePipe implements PipeTransform {

  transform(value: string, name:string, sobrenome:string): string {
    return value.toUpperCase() + "-pipe" + name + ' ' +sobrenome;
  }

}
