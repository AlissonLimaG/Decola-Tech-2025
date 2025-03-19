import {
  Component,
  OnInit,
  DoCheck,
  AfterViewInit,
  AfterContentChecked,
  AfterViewChecked,
  AfterContentInit,
} from '@angular/core';

@Component({
  selector: 'app-check-sample',
  templateUrl: './check-sample.component.html',
  styleUrls: ['./check-sample.component.css'],
})
export class CheckSampleComponent
  implements
    OnInit,
    DoCheck,
    AfterViewInit,
    AfterContentChecked,
    AfterViewChecked,
    AfterContentInit
{
  constructor() {}

  numero: number = 0;

  decrement() {
    this.numero -= 1;
  }

  increment() {
    this.numero += 1;
  }

  ngDoCheck(): void {
    console.log('ngDoCheck');
  }
  ngAfterViewInit(): void {
    console.log('ngAfterViewInit');
  }
  ngAfterContentChecked(): void {
    console.log('ngAfterContentChecked.');
  }
  ngAfterViewChecked(): void {
    console.log('ngAfterViewChecked.');
  }
  ngAfterContentInit(): void {
    console.log('ngAfterContentInit.');
  }
  ngOnInit(): void {
    console.log('ngOnInit');
  }
}
