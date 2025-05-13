import java.util.*;

public class GeradorDeItens{

//GERADOR ALEATORIO DE MATERIAIS, DEVE SER USADO PARA PARAMETRO DE FUNCAO QUE GERE ARMA/FERRAMENTA ALEATORIAMENTE, SE FOREM ADICIONADOS MATERIAIS NO ENUM NAO NECESSITARA SER ALTERADO
    Random aleatorio = new Random();    
    public Material geradorAleatorioDeMateriais(){
        //sorteio do tipo
        Material.TipoDeMaterial[] materiaisDoEnum = Material.TipoDeMaterial.values();
        Material.TipoDeMaterial materialSorteado = materiaisDoEnum[aleatorio.nextInt(materiaisDoEnum.length)];
        //retorno de objeto
        Material objetoMaterial = new Material("material", "descricao", 1, 1, materialSorteado);
        return objetoMaterial;
    }

//CRAFTING DE ARMAS
    public Arma gerarEspada(Material material1, Material material2){
        return new Arma("Espada", "Uma espada afiada, mas de curta distancia.", 3, Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 25, 1, material1, material2);
    }

    public Arma gerarArco(Material material1, Material material2){
        return new Arma("Arco", "Um arco de longa distancia.", 2, Arma.TipoArma.aDistancia, Arma.QualArma.ARCO, 15, 3, material1, material2);
    }

    public Arma gerarPistola(){
        //metal inoxidavel temporario, suas referencias serao armazenadas na arma
        Material metalInoxidavel = new Material("Metal Inoxidavel", "Anticorrosivo e resistente.", 1, 5000, Material.TipoDeMaterial.METAL);
        return new Arma("Pistola", "Uma pistola potente de longo alcance.", 1, Arma.TipoArma.aDistancia, Arma.QualArma.PISTOLA, 25, 3, metalInoxidavel, metalInoxidavel);
    }

//CRAFTING DE FERRAMENTAS
    public Ferramenta gerarMachado(Material material1, Material material2){
        return new Ferramenta("Machado", "Corta madeira.", 2, material1, material2);
    }

    public Ferramenta gerarPicareta(Material material1, Material material2){
        return new Ferramenta("Picareta", "Minera pedra e metal.", 2, material1, material2);
    }
    public Ferramenta gerarFaca(Material material1, Material material2){
        return new Ferramenta("Faca", "Capaz de cortar fibras.", 2, material1, material2);
    }
    public Ferramenta gerarIsqueiro(){
        Material metalInoxidavel = new Material("Metal Inoxidavel", "Anticorrosivo e resistente.", 1, 5000, Material.TipoDeMaterial.METAL);
        return new Ferramenta("Isqueiro", "FOGO !", 1,  metalInoxidavel, metalInoxidavel);
    }
    public Ferramenta gerarLanterna(){
        Material metalInoxidavel = new Material("Metal Inoxidavel", "Anticorrosivo e resistente.", 1, 5000, Material.TipoDeMaterial.METAL);
        return new Ferramenta("Lanterna", "LUZ !", 1,  metalInoxidavel, metalInoxidavel);
    }

//GERADOR DE ALIMENTOS
    public Alimento gerarAlimento(Inventario inventario){
        Alimento novoAlimento;
        Random numeroAleatorio = new Random();
        int chance = numeroAleatorio.nextInt();
        int N = 12; //numeroDeAlimentos
        if (chance < 1.0 / N){
            novoAlimento = new Alimento ("Maçã", "Vermelha.", "Fruta", 1, 10, 15);
        } else if (chance < 2.0 / N){
            novoAlimento = new Alimento ("Laranja", "O que veio primeiro: a cor ou a fruta?", "Fruta", 1, 10, 15);
        } else if (chance < 3.0 / N){
            novoAlimento = new Alimento ("Pera", "Apenas uma pera tranquila.", "Fruta", 1, 10, 15);
        } else if (chance < 4.0 / N){
            novoAlimento = new Alimento ("Costeletas Assadas", "Parecem boas.", "Carne", 2, 5, 50);
        } else if (chance < 5.0 / N){
            novoAlimento = new Alimento ("Frango cru", "Melhor assar isso logo.", "Carne", 2, 3, 10);
        } else if (chance < 6.0 / N){
            novoAlimento = new Alimento ("Carneiro cru", "Deve dar um bom churrasco.", "Carne", 2, 3, 10);
        } else if (chance < 7.0 / N){
            novoAlimento = new Alimento ("Sardinhas enlatadas", "Uma perene amalgama cadaverica.", "Enlatados", 1, 100, 30);
        } else if (chance < 8.0 / N){
            novoAlimento = new Alimento ("Carne enlatada", "É uma mista da carne de vários animais. Emulsionados, liquefeitos, coados e, finalmente, inexoravelmente unidos em uma nisto.", "Enlatados", 1, 100, 60);
        } else if (chance < 9.0 / N){
            novoAlimento = new Alimento ("Feijoada enlatada", "Feijão, carne e coisas desconhecidas.", "Enlatados", 1, 100, 50);
        } else if (chance < 10.0 / N){
            novoAlimento = new Alimento ("Biscoitos", "Doces ou Salgados?", "Farinaceos", 1, 100, 30);
        } else if (chance < 11.0 / N){
            novoAlimento = new Alimento ("Pão", "Carboidratos e gordura, não tem como ser ruim.", "Farinaceos", 1, 10, 40);
        } else{
            novoAlimento = new Alimento ("Bolachas", "Salgadas ou Doces?", "Farinaceos", 1, 100, 30);
        }
        return novoAlimento;
    }
}
