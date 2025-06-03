import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Personagem{
    //COMBATE E FINS DE JOGO
    private boolean emCombate = false;
    private boolean condicaoVitoria = false;
    private boolean condicaoDerrota = false;
    //AMBIENTE
    private final GerenciadorDeAmbiente pontoDePartida = new GerenciadorDeAmbiente();
    private Ambiente localizacao;
    //ATRIBUTOS
    private final String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private final Status status;
    //ITENS
    private final Inventario inventario;
    private List<Item> recursosProximos; //LIMPO A CADA EXPLORAR ou MUDAR DE AMBIENTE
    private Arma armaEquipada;
    //CALOR (FOGUEIRA E FORNO)
    private FonteDeCalor fonteDeCalor; //SE != null, A CADA ROUND DEVERA ESQUENTAR O JOGADOR PARA NORMAL, ALEM DE PERMITIR COZINHAR. SE == null, não usará o alimentarFogo(). Se não tiver madeira, o alimentarFogo() porá um fim à fogueira ("setFonteDeCalor(null);").
    private final GeradorDeID geradorDeID = new GeradorDeID();

    public Personagem(String nome, int vida, int fome, int sede, int energia, int sanidade){
        this.localizacao = pontoDePartida.gerarAleatorio();
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.status = new Status();
        this.inventario = new Inventario(50);
        this.recursosProximos = null;
        this.armaEquipada = null;
        this.fonteDeCalor = null;
    }

    public abstract void usarHabilidade();

    //EXPLORAR, COLETAR RECURSOS (AMBIENTE E PRÓXIMOS) E MUDAR DE AMBIENTE
    public void explorar(){
        if(this.getStatus().getTemperatura() == Status.Temperatura.FRIO 
           || this.getStatus().getTemperatura() == Status.Temperatura.CALOR){
            this.perderEnergia(20);
        }
        else{
            this.perderEnergia(10);
        }
        this.getRecursosProximos().clear();
        this.coletarAmbiente(ThreadLocalRandom.current().nextInt(0, 6));
        //OCORRENCIA DE EVENTOS !!!!!
    }

    public void mudarAmbiente(){
        if(this.getStatus().getTemperatura() == Status.Temperatura.FRIO 
           || this.getStatus().getTemperatura() == Status.Temperatura.CALOR){
            this.perderEnergia(20);
            //GERENCIADOR DE AMBIENTE, MUDAR LOCALIZACAO
        }
        else{
            this.perderEnergia(10);
            //GERENCIADOR DE AMBIENTE, MUDAR LOCALIZACAO
        }
        this.getRecursosProximos().clear();
    }

    public void coletarAmbiente(int contador){
        for(int i = contador; i >= 1; i--){
            Item recursoColetado = this.getLocalizacao().coletarRecurso(this);
            if(recursoColetado != null){recursosProximos.add(recursoColetado);}
        }
        this.exibirRecursosProximos();
    }

    public void coletarProximos(String ID){
        Iterator<Item> it = this.getRecursosProximos().iterator();
        while (it.hasNext()){
            Item item = it.next();
            if (item.getID().equals(ID)){
                if(this.getInventario().adicionarItem(item)){
                    it.remove();
                }
                else{
                    System.out.println("Limpe o inventario antes de pegar itens proximos.");
                }
                return;
            }
        }
        System.out.println("Nao foram encontrados recursos proximos de ID ''" + ID + "''.");
    }

    //public void mudarAmbiente(){} USAR GERENCIADOR DE AMBIENTE

    //FINS DE JOGO
    public boolean getCondicaoVitoria(){
        return this.condicaoVitoria;
    }

    public void setCondicaoVitoria(boolean valor){
        this.condicaoVitoria = valor;
    }

    public boolean getCondicaoDerrota(){
        return this.condicaoDerrota;
    }

    public void setCondicaoDerrota(boolean valor){
        this.condicaoDerrota = valor;
    }

    //COMBATE
    public boolean getEmCombate(){
        return this.emCombate;
    }

    public void setEmCombate(boolean emCombate){
        this.emCombate = emCombate;
    }

    //MOVIMENTAÇÃO, USADA EM EXPLORAR E MUDAR DE AMBIENTE
    public void movimentacao(){
        this.getStatus().setPertoDeFonteDeAgua(false);
        this.setFonteDeCalor(null);
    }

    //AGUA
    public void encherAgua(String ID){
        for (Item item : this.getInventario().getItens()){
            if (item.getID().equals(ID) && item.getClass() == Agua.class){
                Agua agua = (Agua) item;
                if (agua.getVolumeAtual() < agua.getVolumeMax()){
                    agua.encher();
                    System.out.println("Você encheu a garrafa de agua. Melhor purificar isso.");
                } else{
                    System.out.println("A garrafa ja esta cheio.");
                }
                return;
            }
        }
        System.out.println("Nao foi encontrada agua de ID " + ID + ".");
    }

    public void beberAgua(String ID) {
        for (Item item : this.getInventario().getItens()){
            if (item.getID().equals(ID) && item instanceof Agua agua) {
                if (agua.getVolumeAtual() > 0){
                    agua.usar(this);
                    System.out.println("Voce bebeu.");
                    return;
                } else{
                    System.out.println("A garrafa esta vazia.");
                    return;
                }
            }
        }
        System.out.println("Nao foi encontrada agua de ID " + ID + ".");
    }

    //APAGAR FOGUEIRA
    public void apagarFogueira(){
        this.setFonteDeCalor(null);//não gastará mais madeira do inventário a cada loop, mesmo sem se movimentar
    }

    //LOCALIZACAO
    public Ambiente getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(Ambiente novaLocalizacao){
        this.localizacao = novaLocalizacao;
    }
    //FONTE DE CALOR
    public FonteDeCalor getFonteDeCalor(){
        return this.fonteDeCalor;
    }
    public void setFonteDeCalor(FonteDeCalor fonteDeCalor){
        this.fonteDeCalor = fonteDeCalor;
    }
    //GERADOR PARA FONTE DE CALOR
    public GeradorDeID getGeradorDeID(){
        return this.geradorDeID;
    }
    //NOME
    public String getNome(){
        return this.nome;
    }
    //VIDA
    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public void adicionarVida(int quantidade){
        this.vida += quantidade;
        if (this.vida > 100){
        this.vida = 100;
        }
    }

    public void perderVida(int quantidade){
        int novaVida = this.vida - quantidade;
        this.vida = novaVida;
        if(novaVida <=0){
            System.out.println("Voce sucumbiu aos seus ferimentos. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    //FOME
    public int getFome(){
        return this.fome;
    }

    public void setFome(int fome){
        this.fome = fome;
    }

    public void adicionarFome(int quantidade){
        this.fome += quantidade;
        if(this.fome > 100){
            this.fome = 100;
        }
    }

    public void perderFome(int quantidade){
        int novaFome = this.fome - quantidade;
        this.fome = novaFome;
        if(novaFome <= 0){
            System.out.println("Voce morreu de fome. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    //SEDE
    public int getSede(){
        return this.sede;
    }

    public void setSede(int sede){
        this.sede = sede;
    }

    public void adicionarSede(int quantidade){
        if(this.getStatus().getTemperatura() == Status.Temperatura.CALOR){this.getStatus().setTemperatura(Status.Temperatura.NORMAL);} //esfria o personagem se com calor
        this.sede += quantidade;
        if(this.sede > 100){
            this.sede = 100;
        }
    }

    public void perderSede(int quantidade){
        int novaSede = this.sede - quantidade;
        this.sede = novaSede;
        if(novaSede <= 0){
            System.out.println("Voce desidratou. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    //ENERGIA
    public int getEnergia(){
        return this.energia;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public void adicionarEnergia(int quantidade){
        this.energia += quantidade;
        if (this.energia > 100) {
            this.energia = 100;
        }
    }

    public void perderEnergia(int quantidade){
        int novaEnergia = this.energia - quantidade;
        this.energia = novaEnergia;
        if (novaEnergia <= 0) {
            System.out.println("Sua energia acabou. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    //SANIDADE
    public int getSanidade(){
        return this.sanidade;
    }

    public void setSanidade(int sanidade){
        this.sanidade = sanidade;
    }

    public void adicionarSanidade(int quantidade){
        this.sanidade += quantidade;
        if (this.sanidade > 100){
            this.sanidade = 100;
        }
    }

    public void perderSanidade (int quantidade){
        int novaSanidade = this.sanidade - quantidade;
        this.sanidade = novaSanidade;
        if(novaSanidade <= 0){
            System.out.println("Você enlouqueceu. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    //STATUS
    public Status getStatus(){
        return this.status;
    }

    //INVENTARIO E RECURSOS PROXIMOS
    public Inventario getInventario(){
        return this.inventario;
    }

    public List<Item> getRecursosProximos(){
        return this.recursosProximos;
    }

    public void setRecursosProximos(List<Item> recursosProximos){
        this.recursosProximos = recursosProximos;
    }

    public void exibirRecursosProximos(){
        if (this.getRecursosProximos().isEmpty()){
           System.out.println("Nenhum recurso coletavel por perto.");
        } else{
            System.out.println("Recursos coletaveis: ");
            for(Item item : this.getRecursosProximos()){
                System.out.println(item.getNome() + ": " + item.getID());
            }
        }
    }

    public void exibirItens(){
        this.getInventario().exibirItens();
    }

    //ARMA EQUIPADA
    public Arma getArmaEquipada(){
        return this.armaEquipada;
    }

    public void equiparArma(String ID){
        if (ID == null || ID.isEmpty()){
            this.armaEquipada = null;
            System.out.println("Arma desequipada. Mas por que você faria isso?");
            return;
        }
        for (Item item : this.getInventario().getItens()){
            if (item instanceof Arma && item.getID().equals(ID)){
                this.armaEquipada = (Arma) item;
                System.out.println("A arma de ID " + item.getID() + " foi equipada com sucesso !");
                return;
            }
        }
        System.out.println("Nenhuma arma com o ID " + ID + " foi encontrada.");
    }
}
