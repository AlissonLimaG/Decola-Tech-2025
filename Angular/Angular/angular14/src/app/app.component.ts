import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  idade:number = 22;
  count:number = 1;

  addCount():void{
    this.count += 1
    this.idade += 1;
    console.log(this.count)
  }
}
