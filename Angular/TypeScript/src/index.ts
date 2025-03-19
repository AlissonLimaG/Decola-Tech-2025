//TIPOS DE VARIÁVEIS
let boleano:Boolean = false;
let numerico:Number = 2;
let string: String = "OI";
let nulo: null = null;
let indefinido: undefined = undefined;

let funcao: (nome:String) => String = (nome:String) => nome;
console.log(funcao("Alisson"))

let objetoQualquer: Object = {
    nome: "Alisson",
    idade: "20",
    altura: 1.65,
}

type Pessoa = {
    readonly nome:String, //O readOnly não permite que o atributo seja modificado, somente lido!
    idade:String | Number, //Também tem suporte a multi-types
    altura:Number
}

let objetoPessoa: Pessoa = {
    nome: "Alisson",
    idade: "20",
    altura: 1.65,
}

//ARRAYS
let dados: String[] = ["ALisson", "Lilian", "Luana"]
let dados2: Array<String> = ["ALisson", "Lilian", "Luana"]
let multiTipos:(string | number)[] = ["Alisson", 22]


//TUPLAS
let bole:[String, number, number] = ["199.9",1,1];


//DATAS
let aniversario:Date = new Date("2022-01-08 07:15:55");
console.log(aniversario.toString());


//FUNÇÕES
function addNumber(y:number, x:number = 5):number{
    return x+y;
}

let soma:number = addNumber(5);

//Parâmetros com vários tipos e retornos com vários tipos
function multiParamType(cpf: String | number): String | number{
    return cpf;
}


//FUNÇÕES ASSRÍNCRONAS
async function consultardatabase(id: number): Promise<String>{
    return "oi";
}

//CLASSES E MODIFICADORES DE ACESSO
class character{
    private name: String; //Só é acessada dentro da própria classe
    strenght: number;
    life: number;

    constructor(name:String, strenght: number, life: number){
        this.name = name;
        this.strenght = strenght;
        this.life = life;
    }

    public attack():void {
        console.log("Atacou")
    }
}

//DECORATORS DE CLASSE
function MeuDecorator(construtor: Function) {
    console.log("Classe decorada: ", construtor.name);
  }
  
  @MeuDecorator
  class MinhaClasse {
    nome = "Exemplo";
    constructor(){

    }
  }
  
