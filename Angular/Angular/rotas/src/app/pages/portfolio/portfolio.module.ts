import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './card/card.component';
import { CardFilho1Component } from './card-filho1/card-filho1.component';
import { CardFilho2Component } from './card-filho2/card-filho2.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    CardComponent,
    CardFilho1Component,
    CardFilho2Component
  ],
  exports:[
    CardComponent,
    CardFilho1Component,
    CardFilho2Component
],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class PortfolioModule { }
