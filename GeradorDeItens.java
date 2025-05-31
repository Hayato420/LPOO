//import java.util.*;

/*IDEIA DE INTERFACE CRAFTING: INSERIR DOIS IDS DE MATERIAIS DO INVENTÁRIO,
DIZER O QUE QUER GERAR, FAZER UM CASE COM ISSO E CHAMAR O MÉTODO ADEQUADO*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GeradorDeItens{
    private final GeradorDeID geradorDeID;

    public GeradorDeItens(GeradorDeID geradorDeID){
        this.geradorDeID = geradorDeID;
    }

    public GeradorDeID getGeradorDeID(){
        return this.geradorDeID;
    }

    public boolean verifCombinacaoMateriais(Personagem jogador, String IDmat1, String IDmat2){//NÃO CONTÉM REMOÇÃO
        if (IDmat1.equals(IDmat2)){
            throw new ExcecaoCombMateriais("Material repetido, e necessario ao menos dois materiais.");
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
            throw new ExcecaoCombMateriais("Material nao encontrado. Insira uma ID valida.");
        }
    }

    public void removerCombinacao(Personagem jogador, String IDmat1, String IDmat2){
        jogador.getInventario().removerItem(IDmat1);
        jogador.getInventario().removerItem(IDmat2);
    }
    //da String ID, retorna Material
    public Material buscarMatComb(Personagem jogador, String ID){
        for (Item item : jogador.getInventario().getItens()){
            if (item.getID().equals(ID) && item instanceof Material){
                return (Material) item;
            }
        }
        System.out.println("Erro: Material nao encontrado.");
        return null; // se não encontrou
    }
//CORDA E ARMADILHA
    public Corda gerarCordaFab(Personagem jogador, String IDmat1, String IDmat2){
        try{
            if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2) && 
                jogador.getInventario().getItemEscolhido(IDmat1).getClass() == Fibra.class &&
                jogador.getInventario().getItemEscolhido(IDmat2).getClass() == Fibra.class){

                Fibra fibra1 = (Fibra) jogador.getInventario().getItemEscolhido(IDmat1);
                Fibra fibra2 = (Fibra) jogador.getInventario().getItemEscolhido(IDmat2);
                Corda corda = new Corda(fibra1, fibra2, this.geradorDeID);
                jogador.getInventario().removerItem(IDmat1);
                jogador.getInventario().removerItem(IDmat2);
                System.out.println("Corda gerada com sucesso.");
                return corda;
            }
            else{
                return null;
            }
        }
        catch(ExcecaoCombMateriais exc){
            System.out.println(exc.getMessage());
            return null;
        }
    }

    public Armadilha gerarArmadilhaFab(Personagem jogador, String IDmat1, String IDmat2){
        try{
            if(verifCombinacaoMateriais(jogador, IDmat1, IDmat2) && 
                jogador.getInventario().getItemEscolhido(IDmat1).getClass() == Corda.class &&
                jogador.getInventario().getItemEscolhido(IDmat2).getClass() == Corda.class){

                Corda corda1 = (Corda) jogador.getInventario().getItemEscolhido(IDmat1);
                Corda corda2 = (Corda) jogador.getInventario().getItemEscolhido(IDmat2);
                Armadilha armadilha = new Armadilha(corda1, corda2, this.geradorDeID);
                jogador.getInventario().removerItem(IDmat1);
                jogador.getInventario().removerItem(IDmat2);
                System.out.println("Armadilha gerada com sucesso.");
                return armadilha;
            }
            else{
                return null;
            }
        }
        catch(ExcecaoCombMateriais exc){
                System.out.println(exc.getMessage());
                return null;
        }
    }

//GERAR FERRAMENTAS; INSTANCIAR COM CAST: Picareta picareta = (Picareta) gerador.gerarFerramentaFab("picareta", jogador, "IDmat1", "IDmat2");
    public Ferramenta gerarFerramentaFab(String tipo, Personagem jogador, String IDmat1, String IDmat2){
        try{
            if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)) {
                return null; //Por segurança, mas verifCombinacaoMateriais ja lanca excecao se os materiais forem invalidos
            }
        
            Material mat1 = buscarMatComb(jogador, IDmat1);
            Material mat2 = buscarMatComb(jogador, IDmat2);
        
            switch (tipo.toLowerCase()){
                case "picareta":
                    Picareta picareta = new Picareta(mat1, mat2, this.geradorDeID);
                    removerCombinacao(jogador, IDmat1, IDmat2);
                    return picareta;
        
                case "machado":
                    Machado machado = new Machado(mat1, mat2, this.geradorDeID);
                    removerCombinacao(jogador, IDmat1, IDmat2);
                    return machado;
        
                case "faca":
                    Faca faca = new Faca(mat1, mat2, this.geradorDeID);
                    removerCombinacao(jogador, IDmat1, IDmat2);
                    return faca;
        
                default:
                    System.out.println("Tipo de ferramenta invalido.");
                    return null;
            }
        }
        catch(ExcecaoCombMateriais exc){
            System.out.println(exc.getMessage());
            return null;
        }
    }

    public Ferramenta gerarFerramentaAleat(String tipoFerramenta){ //USADO NA COLETA DE RECURSOS DO AMBIENTE
        Material mat1 = gerarMateriaisAleat();
        Material mat2 = gerarMateriaisAleat();
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.geradorDeID);

        tipoFerramenta = tipoFerramenta.toLowerCase();
    
        switch (tipoFerramenta){
            case "faca":
                return new Faca(mat1, mat2, this.geradorDeID);

            case "picareta":
                return new Picareta(mat1, mat2, this.geradorDeID);
    
            case "machado":
                return new Machado(mat1, mat2, this.geradorDeID);

            case "isqueiro":
                return new Isqueiro(metalInox1, metalInox2, this.geradorDeID);
    
            case "lanterna":
                return new Lanterna(metalInox1, metalInox2, this.geradorDeID);

            default:
                throw new IllegalArgumentException("Tipo de ferramenta desconhecido: " + tipoFerramenta + ". Erro em gerarFerramentaAleat(GeradorDeItens)"); // erro do código
        }
    }


/* ideia: por nao serem fabricaveis, Lanterna e Isqueiro devem ser apenas encontrados, sendo so criados por aleatoriedade,
encontrados na exploracao */


    //GERADOR DE MUNICOES
    //apenas flechas sao fabricaveis
    public Flechas gerarFlechaFab(Personagem jogador, String IDmat1, String IDmat2){
        try{
            if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)){
                return null; //se nao houver os materiais no inventario do jogador
            }
            Flechas flecha = new Flechas(4, buscarMatComb(jogador, IDmat1), buscarMatComb(jogador, IDmat2), this.geradorDeID);
            removerCombinacao(jogador, IDmat1, IDmat2);
            return flecha;//FAZER UM GETMATERIAL
        }
        catch(ExcecaoCombMateriais exc){
            System.out.println(exc.getMessage());
            return null;
        }
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
                    this.gerarMateriaisAleat(),
                    this.gerarMateriaisAleat(),
                    this.geradorDeID
                );
    
            default:
                return null;
        }
    }



//GERADOR DE ARMAS; INSTANCIAR COM CAST: Espada espada = (Espada) geradorDeItens.gerarArmaFab("espada", jogador, "IDmat1", "IDmat2");
    public Arma gerarArmaFab(String tipo, Personagem jogador, String IDmat1, String IDmat2){
        try{
            if (!verifCombinacaoMateriais(jogador, IDmat1, IDmat2)) return null;
        
            Material mat1 = buscarMatComb(jogador, IDmat1);
            Material mat2 = buscarMatComb(jogador, IDmat2);
        
            switch (tipo.toLowerCase()){
                case "arco":
                    Arco arco = new Arco(Arma.TipoArma.aDistancia, Arma.QualArma.ARCO, 3, mat1, mat2, this.geradorDeID);
                                        removerCombinacao(jogador, IDmat1, IDmat2);
                    return arco;

                case "espada":
                    Espada espada = new Espada(Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 1, mat1, mat2, this.geradorDeID);
                                                removerCombinacao(jogador, IDmat1, IDmat2);
                    return espada;
        
                case "lanca":
                    Lanca lanca = new Lanca(Arma.TipoArma.corpoACorpo, Arma.QualArma.LANCA, 2, mat1, mat2, this.geradorDeID);
                                            removerCombinacao(jogador, IDmat1, IDmat2);
                    return lanca;
        
                default:
                    System.out.println("Tipo invalido. Selecione um tipo de arma fabricavel.");
                    return null;//tipo invalido
            }
        }
        catch(ExcecaoCombMateriais exc){
            System.out.println(exc.getMessage());
            return null;
        }
    }

    public Arma gerarArmaAleat(String tipoArma){ //USADO NA COLETA DE RECURSOS DO AMBIENTE
        Material mat1 = gerarMateriaisAleat();
        Material mat2 = gerarMateriaisAleat();
    
        tipoArma = tipoArma.toLowerCase();
    
        switch (tipoArma){
            case "espada":
                return new Espada(Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 1, mat1, mat2, this.geradorDeID);
    
            case "arco":
                return new Arco(Arma.TipoArma.aDistancia, Arma.QualArma.ARCO, 3, mat1, mat2, this.geradorDeID);
    
            case "lanca":
            case "lança": //da no mesmo se o player digitar "lanca" ou "lança"
                return new Lanca(Arma.TipoArma.corpoACorpo, Arma.QualArma.LANCA, 2, mat1, mat2, this.geradorDeID);
    
            case "pistola":
                Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorDeID);
                Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorDeID);
                return new Pistola(Arma.TipoArma.aDistancia, Arma.QualArma.PISTOLA, 3, metalInox1, metalInox2, this.geradorDeID);

            default:
                throw new IllegalArgumentException("Tipo de arma desconhecido: " + tipoArma); //SE APARECER, É ERRO NO CÓDIGO, NÃO DO PLAYER
        }
    }



//GERADOR ALEATORIO DE MATERIAIS, DEVE SER USADO PARA PARAMETRO DE FUNCAO QUE GERE ARMA/FERRAMENTA ALEATORIAMENTE, SE FOREM ADICIONADOS MATERIAIS NO ENUM NAO NECESSITARA SER ALTERADO  
    public Material gerarMateriaisAleat(){
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

//GERADOR ALEATORIO DE ALIMENTOS
    public Alimento gerarAlimento(){
        Alimento.TipoAlimento[] listaDeAlimentos = Alimento.TipoAlimento.values();//pega os valores do enum e cria uma lista
        int index = ThreadLocalRandom.current().nextInt(listaDeAlimentos.length);//sorteia um dos elementos da lista criada
        return listaDeAlimentos[index].criarAlimento(this.geradorDeID);//retorna o elemento sorteado
    }

//GERADOR ALEATORIO DE FERRAMENTAS E ARMAS PARA O AMBIENTE (HASHMAP)
    public Map<String, Integer> gerarFerrArmMunic(){
        Map<String, Integer> recursos = new HashMap<>();
        recursos.put("Arco", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Espada", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Lanca", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Pistola", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Faca", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Machado", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Picareta", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Isqueiro", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Lanterna", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Balas", ThreadLocalRandom.current().nextInt(0, 2)); //se achado, deverá dar várias municoes, ou mudamos municao de bala
        recursos.put("Flechas", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Fluido de Isqueiro", ThreadLocalRandom.current().nextInt(0, 2));
        recursos.put("Pilhas", ThreadLocalRandom.current().nextInt(0, 2));
        //agua é gerada fora desse metodo, dentro de cada ambiente
        return recursos;
    }
}