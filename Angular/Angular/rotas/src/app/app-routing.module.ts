import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TitleComponent } from './pages/index/title/title.component';
import { CardComponent } from './pages/portfolio/card/card.component';
import { CardFilho1Component } from './pages/portfolio/card-filho1/card-filho1.component';
import { CardFilho2Component } from './pages/portfolio/card-filho2/card-filho2.component';

const routes: Routes = [
  {path:"", component:TitleComponent, pathMatch:'full'},
  {path:"portfolio", component: CardComponent, children:[
      {path:"filho/:id", component: CardFilho1Component},
      {path:"filho2", component: CardFilho2Component}
  ]},
  {path:'**', redirectTo:''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
