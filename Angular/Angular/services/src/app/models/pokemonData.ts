export type PokemonData = {
    name:string;
    id:number;
    sprites:{
        front_default:string
    };
    types:{
        type:{
            name:string
        }
    }[]
};