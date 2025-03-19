import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  inputNome: string = '';
  nomes: string[] = ['Alisson', 'Lilian', 'Luana'];
  tipoUser:String = 'superUser';

  adicionaNome() {
    this.nomes.push(this.inputNome);
  }

  remove(index: number) {
    this.nomes.splice(index,1)
  }

}
