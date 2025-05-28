//import java.util.*;

/*IDEIA DE INTERFACE CRAFTING: INSERIR DOIS IDS DE MATERIAIS DO INVENTÁRIO,
DIZER O QUE QUER GERAR, FAZER UM CASE COM ISSO E CHAMAR O MÉTODO ADEQUADO*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GeradorDeItens{
    private GeradorDeID geradorDeID;

    public GeradorDeID getGeradorDeID(){
        return this.geradorDeID;
    }

    public boolean verifCombinacaoMateriais(Personagem jogador, String IDmat1, String IDmat2){//NÃO CONTÉM REMOÇÃO
        if (IDmat1.equals(IDmat2)){
            throw new ExcecaoCombMateriais("Material repetido, é necessário ao menos dois materiais.");
        }
        if(jogador.getInventario().verificarItemInventario(IDmat1) 
            && jogador.getInventario().verificarItemInventario(IDmat2)){
            System.out.println("Itens combinados !");
            return true;
            /*jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2); OS MATERIAIS PRECISAM SER REMOVIDOS POR QUEM CHAMAR,
            O QUE JA FOI IMPLEMENTADO, MAS CUIDADO PARA NAO ESQUECER EM GERACOES FUTURAS*/
        }
        else{
            throw new ExcecaoCombMateriais("Material não encontrado. Insira uma ID válida.");
        }
    }

//GERAR FERRAMENTAS; FUNCIONA TANTO PARA PLAYER QUANTO PARA GERAÇÃO DO AMBIENTE
    public Picareta gerarPicareta(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Picareta picareta = new Picareta("Picareta", "Pontiaguda.", 3, jogador.getInventario().getItemPorID(IDmat1), 
            jogador.getInventario().getItemPorID(IDmat2), this.geradorDeID);
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return picareta;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }
    public Machado gerarMachado(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Machado machado = new Machado("Machado", "Afiado.", 3, jogador.getInventario().getItemPorID(IDmat1), 
            jogador.getInventario().getItemPorID(IDmat2), this.geradorDeID);
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return machado;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }
    public Faca gerarFaca(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Faca faca = new Faca("Faca", "Cortante.", 1, jogador.getInventario().getItemPorID(IDmat1), 
            jogador.getInventario().getItemPorID(IDmat2), this.geradorDeID);
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return faca;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }

/*ideia: por não serem fabricáveis, Lanterna e Isqueiro devem ser apenas encontrados, sendo só criados por aleatoriedade,
encontrados na exploracao*/
    public Isqueiro gerarIsqueiro(){
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Isqueiro isqueiro = new Isqueiro("Isqueiro", "Fogo !", 1, this.geradorDeID, metalInox1, metalInox2);
        return isqueiro;
    }//talvez seja bom fazer o item fluido de isqueiro, talvez em materiais, ou algo assim, para puder usar o isqueiro
    public Lanterna gerarLanterna(){
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Lanterna lanterna = new Lanterna("Lanterna", "Luz !", 1, this.geradorDeID, metalInox1, metalInox2);
        return lanterna;
    }//talvez seja bom fazer o item pilha, talvez em materiais, ou algo assim, para puder usar a lanterna

//GERADOR DE ARMAS
    public Arma gerarArco(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Arco arco = new Arco("Arco", "É bom ter flechas.", 2, this.geradorDeID, Arma.TipoArma.aDistancia, 
            Arma.QualArma.ARCO, 3, jogador.getInventario().getItemPorID(IDmat1), jogador.getInventario().getItemPorID(IDmat2));
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return arco;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }

    public Arma gerarEspada(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Espada espada = new Espada("Espada", "Avante !", 3, this.geradorDeID, Arma.TipoArma.corpoACorpo, 
            Arma.QualArma.ESPADA, 1, jogador.getInventario().getItemPorID(IDmat1), jogador.getInventario().getItemPorID(IDmat2));
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return espada;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }

    public Arma gerarLanca(Personagem jogador, String IDmat1, String IDmat2){
        if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            Lanca lanca = new Lanca("Lança", "Espeta !", 3, this.geradorDeID, Arma.TipoArma.corpoACorpo, 
            Arma.QualArma.LANCA, 2, jogador.getInventario().getItemPorID(IDmat1), jogador.getInventario().getItemPorID(IDmat2));
            jogador.getInventario().removerItem(IDmat1);
            jogador.getInventario().removerItem(IDmat2);
            return lanca;
        }
        return null;//nunca ocorrera devido a ExcecaoCombMateriais em verifCombinacaoMateriais
    }

    public Arma gerarPistola(){
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Pistola pistola = new Pistola("Pistola", "Pow pow !", 1, this.geradorDeID, Arma.TipoArma.aDistancia, 
                          Arma.QualArma.PISTOLA, 3, metalInox1, metalInox2);
        return pistola;
    }

//GERADOR ALEATORIO DE MATERIAIS, DEVE SER USADO PARA PARAMETRO DE FUNCAO QUE GERE ARMA/FERRAMENTA ALEATORIAMENTE, SE FOREM ADICIONADOS MATERIAIS NO ENUM NAO NECESSITARA SER ALTERADO  
    public Material gerarMateriaisAleatParaFerram(){
        Material.TipoDeMaterial[] materiais = Material.TipoDeMaterial.values(); //pega o enum e passa seus valores pra uma lista
        int indiceAleatorio = ThreadLocalRandom.current().nextInt(materiais.length);//sorteia o indice
        Material.TipoDeMaterial materialAleatorio = materiais[indiceAleatorio];//pega o valor correspondente ao indice
        return materialAleatorio.criarMaterial(this.geradorDeID);//retorna um material com base nesse valor
    }

    public Agua gerarAguaAleatoria(){
        boolean booleanAleatorio = ThreadLocalRandom.current().nextBoolean();
        int volumeAleatorio = ThreadLocalRandom.current().nextInt(1, 6);
        return new Agua(this.geradorDeID, booleanAleatorio, volumeAleatorio);
    }

//GERADOR ALEATÓRIO DE ALIMENTOS
    public Alimento gerarAlimento(){
        Alimento.TipoAlimento[] listaDeAlimentos = Alimento.TipoAlimento.values();//pega os valores do enum e cria uma lista
        int index = ThreadLocalRandom.current().nextInt(listaDeAlimentos.length);//sorteia um dos elementos da lista criada
        return listaDeAlimentos[index].criarAlimento(this.geradorDeID);//retorna o elemento sorteado
    }
//GERADOR ALEATÓRIO DE FERRAMENTAS E ARMAS (HASHMAP)
    public Map<String, Integer> gerarFerrEArm(){
        Map<String, Integer> recursos = new HashMap<>();
        recursos.put("Arco", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Espada", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Lanca", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Pistola", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Faca", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Isqueiro", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Lanterna", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Machado", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Balas", ThreadLocalRandom.current().nextInt(0, 2)); //se achado, deverá dar várias municoes, ou mudamos municao de bala
        recursos.put("Flechas", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Picareta", ThreadLocalRandom.current().nextInt(0, 2));
        return recursos;
    }
}