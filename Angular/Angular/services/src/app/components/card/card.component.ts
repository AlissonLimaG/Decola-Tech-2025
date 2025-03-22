import { Component, OnInit } from '@angular/core';
import { PokemonData } from 'src/app/models/pokemonData';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  pokemon: PokemonData ={
    name: '',
    id: 0,
    sprites: { front_default: '' },
    types:  []
  };

  name: string = '';
  stats: string[] = ['FIRE', 'EARTH'];

  constructor(private readonly pokemonService: PokemonService) { }

  searchPokemon(){
    this.pokemonService.getPokemon(this.name).subscribe({
      next: (res) => {
        console.log(res)
        this.pokemon = {
          id: res.id,
          name: res.name,
          sprites: res.sprites,
          types: res.types
        }
      },
      error: (err) => console.log(err)
    });
  }

  ngOnInit(): void {
    this.pokemonService.getPokemon('charizard').subscribe({
      next: (res) => {

        this.pokemon = {
          id: res.id,
          name: res.name,
          sprites: res.sprites,
          types: res.types
        }

        console.log(this.pokemon)
        console.log(res)
        console.log(res.id)
        console.log(res.name)
        console.log(res.sprites.front_default)
        console.log(res.types)
      },
      error: (err) => console.log(err)
    });
  }

}
