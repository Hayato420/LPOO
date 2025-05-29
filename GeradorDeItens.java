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

    public void removerCombinacao(Personagem jogador, String IDmat1, String IDmat2){
        jogador.getInventario().removerItem(IDmat1);
        jogador.getInventario().removerItem(IDmat2);
    }

//GERAR FERRAMENTAS; INSTANCIAR COM CAST: Picareta picareta = (Picareta) gerador.gerarFerramentaFab("picareta", jogador, "IDmat1", "IDmat2");
    public Item gerarFerramentaFab(String tipo, Personagem jogador, String IDmat1, String IDmat2){
        if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)) {
            return null; //Por segurança, mas verifCombinacaoMateriais ja lanca excecao se os materiais forem invalidos
        }
    
        Item mat1 = jogador.getInventario().getItemPorID(IDmat1);
        Item mat2 = jogador.getInventario().getItemPorID(IDmat2);
    
        switch (tipo.toLowerCase()) {
            case "picareta":
                Picareta picareta = new Picareta("Picareta", "Pontiaguda.", 3, mat1, mat2, this.geradorDeID);
                removerCombinacao(jogador, IDmat1, IDmat2);
                return picareta;
    
            case "machado":
                Machado machado = new Machado("Machado", "Afiado.", 3, mat1, mat2, this.geradorDeID);
                removerCombinacao(jogador, IDmat1, IDmat2);
                return machado;
    
            case "faca":
                Faca faca = new Faca("Faca", "Cortante.", 1, mat1, mat2, this.geradorDeID);
                removerCombinacao(jogador, IDmat1, IDmat2);
                return faca;
    
            default:
                System.out.println("Tipo de ferramenta invalido.");
                return null;
        }
    }

    public Ferramenta gerarFerramentaAleat(String tipoFerramenta){ //USADO NA COLETA DE RECURSOS DO AMBIENTE
        Material mat1 = gerarMateriaisAleatParaFerram();
        Material mat2 = gerarMateriaisAleatParaFerram();
    
        tipoFerramenta = tipoFerramenta.toLowerCase();
    
        switch (tipoFerramenta){
            case "faca":
                Material facaMat1 = gerarMateriaisAleatParaFerram();
                Material facaMat2 = gerarMateriaisAleatParaFerram();
                return new Faca("Faca", "Tromantino.", 1, this.geradorDeID,
                                Ferramenta.TipoFerramenta.FACA, facaMat1, facaMat2);

            case "picareta":
                return new Picareta("Picareta", "First we mine, then we craft !", 3, this.geradorDeID,
                        Ferramenta.TipoFerramenta.PICARETA, mat1, mat2);
    
            case "machado":
                return new Machado("Machado", "Uma serra seria melhor.", 2, this.geradorDeID,
                        Ferramenta.TipoFerramenta.MACHADO, mat1, mat2);

            case "isqueiro":
                Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
                Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
                return new Isqueiro("Isqueiro", "Fogo !", 1, this.geradorDeID, metalInox1, metalInox2);
    
            case "lanterna":
                Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
                Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
                return new Lanterna("Lanterna", "Luz !", 1, this.geradorDeID, metalInox1, metalInox2);

            default:
                throw new IllegalArgumentException("Tipo de ferramenta desconhecido: " + tipoFerramenta); // erro do código
        }
    }


/* ideia: por nao serem fabricaveis, Lanterna e Isqueiro devem ser apenas encontrados, sendo so criados por aleatoriedade,
encontrados na exploracao */
    



    //GERADOR DE MUNICOES
    //apenas flechas sao fabricaveis
    public Item gerarFlechaFab(Personagem jogador, String IDmat1, String IDmat2){
        if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
            return null; //se nao houver os materiais no inventario do jogador
        }
        Material mat1 = for(item : jogador.getInventario.getItens() if(item.getID().equals(IDmat1) return item
        Flecha flecha = new Flecha(16, material1, material2, this.geradorDeID)
        removerCombinacao(jogador, IDmat1, IDmat2);
        return //FAZER UM GETMATERIAL
    }
    //apenas flechas podem ser de materiais diferentes de metal inoxidavel
    public Item gerarMunicaoAleat(String tipo) {
        tipo = tipo.toLowerCase();
    
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
    
        switch (tipo) {
            case "bala":
            case "balas":
                return new Balas(
                    ThreadLocalRandom.current().nextInt(1, 11),
                    metalInox1,
                    metalInox2,
                    this.geradorDeID
                );
    
            case "pilha":
            case "pilhas":
                return new Pilhas(
                    ThreadLocalRandom.current().nextInt(1, 21),
                    metalInox1,
                    metalInox2,
                    this.geradorDeID
                );
    
            case "fluido de isqueiro":
                return new FluidoDeIsqueiro(
                    ThreadLocalRandom.current().nextInt(1, 11),
                    metalInox1,
                    metalInox2,
                    this.geradorDeID
                );
    
            case "flecha":
            case "flechas":
                return new Flechas(
                    ThreadLocalRandom.current().nextInt(1, 16),
                    this.gerarMateriaisAleatParaFerram(),
                    this.gerarMateriaisAleatParaFerram(),
                    this.geradorDeID
                );
    
            default:
                return null;
        }
    }





//GERADOR DE ARMAS; INSTANCIAR COM CAST: Espada espada = (Espada) geradorDeItens.gerarArmaFab("espada", jogador, "IDmat1", "IDmat2");
    public Arma gerarArmaFab(String tipo, Personagem jogador, String IDmat1, String IDmat2){
        if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)) return null;
    
        Material mat1 = jogador.getInventario().getItemPorID(IDmat1);
        Material mat2 = jogador.getInventario().getItemPorID(IDmat2);
    
        switch (tipo.toLowerCase()){
            case "arco":
                Arco arco = new Arco("Arco", "É bom ter flechas.", 2, this.geradorDeID,
                                    Arma.TipoArma.aDistancia, Arma.QualArma.ARCO, 3, mat1, mat2);
                                    removerCombinacao(jogador, IDmat1, IDmat2);
                return arco;

            case "espada":
                Espada espada = new Espada("Espada", "Avante !", 3, this.geradorDeID,
                                            Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 1, mat1, mat2);
                                            removerCombinacao(jogador, IDmat1, IDmat2);
                return espada;
    
            case "lanca":
                Lanca lanca = new Lanca("Lança", "Espeta !", 3, this.geradorDeID,
                                        Arma.TipoArma.corpoACorpo, Arma.QualArma.LANCA, 2, mat1, mat2);
                                        removerCombinacao(jogador, IDmat1, IDmat2);
                return lanca;
    
            default:
                return null;//tipo invalido
        }
    }

    public Arma gerarArmaAleat(String tipoArma){ //USADO NA COLETA DE RECURSOS DO AMBIENTE
        Material mat1 = gerarMateriaisAleatParaArmas();
        Material mat2 = gerarMateriaisAleatParaArmas();
    
        tipoArma = tipoArma.toLowerCase();
    
        switch (tipoArma){
            case "espada":
                return new Espada("Espada", "Avante !", 3, this.geradorDeID,
                        Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 1, mat1, mat2);
    
            case "arco":
                return new Arco("Arco", "É bom ter flechas.", 2, this.geradorDeID,
                        Arma.TipoArma.aDistancia, Arma.QualArma.ARCO, 3, mat1, mat2);
    
            case "lanca":
            case "lança": //da no mesmo se o player digitar "lanca" ou "lança"
                return new Lanca("Lança", "Espeta !", 3, this.geradorDeID,
                        Arma.TipoArma.corpoACorpo, Arma.QualArma.LANCA, 2, mat1, mat2);
    
            case "pistola":
                Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorDeID);
                Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorDeID);
                return new Pistola("Pistola", "Pow pow !", 1, this.geradorDeID,
                        Arma.TipoArma.aDistancia, Arma.QualArma.PISTOLA, 3, metalInox1, metalInox2);
    
            default:
                throw new IllegalArgumentException("Tipo de arma desconhecido: " + tipoArma); //SE APARECER, É ERRO NO CÓDIGO, NÃO DO PLAYER
        }
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
//GERADOR ALEATÓRIO DE FERRAMENTAS E ARMAS PARA O AMBIENTE (HASHMAP)
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
        recursos.put("Balas", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Flechas", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Pilhas", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Fluido de Isqueiro", ThreadLocalRandom.current().nextInt(0, 2));
        return recursos;
    }
}
