import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent {

  nome: string = "Alisson";
  @Input() idade!: any;
  @Input() incrementa!: () => void;
}
