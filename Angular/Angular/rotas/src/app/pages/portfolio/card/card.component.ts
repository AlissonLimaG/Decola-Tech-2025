import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit{

  constructor(
      private readonly activatedRoute: ActivatedRoute,
      private readonly router: Router) { 
    
    this.activatedRoute.params.subscribe(params => console.log(params));
    this.activatedRoute.paramMap.subscribe(params => console.log(params));

    this.activatedRoute.queryParams.subscribe(queryParams => console.log(queryParams))
    this.activatedRoute.queryParamMap.subscribe(queryParams => console.log(queryParams))

    this.activatedRoute.children[0].paramMap.subscribe(params => console.log(params));
        // this.activatedRoute.children[0].queryParamMap.subscribe(queryParams => console.log(queryParams))
  }

  ngOnInit(): void {
    // setTimeout(()=>{
    //   this.router.navigate(['/']);
    // },5000);
  }


}
