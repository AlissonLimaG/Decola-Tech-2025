import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PokemonData } from '../models/pokemonData';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private baseURL:string = environment.pokeApi;

  constructor(private http: HttpClient) {}

  getPokemon(name:string):Observable<PokemonData>{
    return this.http
               .get<PokemonData | any>
               (`${this.baseURL}${name}`);
  }
}
