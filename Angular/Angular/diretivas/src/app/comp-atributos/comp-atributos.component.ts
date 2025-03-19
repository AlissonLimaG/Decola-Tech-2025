import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comp-atributos',
  templateUrl: './comp-atributos.component.html',
  styleUrls: ['./comp-atributos.component.css']
})
export class CompAtributosComponent {
  isDisable: boolean = true;
  disable: string = 'disable';
  corTexto: string = 'red';
  corFundo: string = 'yellow';
  nome: string = '';
  nomes: string[] = [];
  visible: boolean = true;

  siwtchCLass() {
    if (this.disable === 'disable') {
      this.disable = 'enable';
    } else {
      this.disable = 'disable';
    }
  }
  switchBoolean() {
    this.isDisable = !this.isDisable;
  }

  adicionarNome() {
    this.nomes.push(this.nome);
  }

  switch() {
    this.visible = !this.visible
  }
}
