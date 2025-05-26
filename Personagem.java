public class Personagem{

    private final GerenciadorDeAmbiente pontoDePartida = new GerenciadorDeAmbiente();
    private Ambiente localizacao;
    private final String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private Status status;
    private final Inventario inventario;
    private Arma armaEquipada;
    private FonteDeCalor fonteDeCalor;//SE != null, A CADA ROUND DEVERA ESQUENTAR O JOGADOR PARA NORMAL, ALEM DE PERMITIR COZINHAR
    private final GeradorDeID geradorDeID;

    public Personagem(String nome, GeradorDeID geradorDeID){
        this.localizacao = pontoDePartida.gerarAleatorio();
        this.nome = nome;
        this.vida = 100;
        this.fome = 100;
        this.sede = 100;
        this.energia = 100;
        this.sanidade = 100;
        this.status = new Status();
        this.inventario = new Inventario(50);
        this.armaEquipada = null;
        this.geradorDeID = geradorDeID;
    }

    /*public abstract void usarHabilidade();*/
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

    public void adicionarVida(int quantidade){
        this.vida += quantidade;
        if (this.vida > 100){
        this.vida = 100;
        }
    }

    public void perderVida(int quantidade){
        this.vida -= quantidade;
        if(this.vida <=0){
            System.out.print("Voce sucumbiu aos seus ferimentos. Fim de jogo.");
        }
    }
    //FOME
    public int getFome(){
        return this.fome;
    }

    public void adicionarFome(int quantidade){
        this.fome += quantidade;
        if(this.fome > 100){
            this.fome = 100;
        }
    }

    public void perderFome(int quantidade){
        this.fome -= quantidade;
        if(this.fome <= 0){
            System.out.print("Voce morreu de fome. Fim de jogo.");
        }
    }
    //SEDE
    public int getSede(){
        return this.sede;
    }

    public void adicionarSede(int quantidade){
        if(this.getStatus().getTemperatura() == Status.Temperatura.CALOR){this.getStatus().setTemperatura(Status.Temperatura.NORMAL);} //esfria o personagem se com calor
        this.sede += quantidade;
        if(this.sede > 100){
            this.sede = 100;
        }
    }

    public void perderSede(int quantidade){
        this.sede -= quantidade;
        if(this.sede <= 0){
            System.out.print("Voce desidratou. Fim de jogo.");
        }
    }
    //ENERGIA
    public int getEnergia(){
        return this.energia;
    }

    public void adicionarEnergia(int quantidade){
        this.energia += quantidade;
        if (this.energia > 100) {
            this.energia = 100;
        }
    }

    public void perderEnergia(int quantidade){
        this.energia -= quantidade;
        if (this.energia <= 0) {
            System.out.print("Sua energia acabou. Fim de jogo.");
        }
    }
    //SANIDADE
    public int getSanidade(){
        return this.sanidade;
    }

    public void adicionarSanidade(int quantidade){
        this.sanidade += quantidade;
        if (this.sanidade > 100){
            this.sanidade = 100;
        }
    }

    public void perderSanidade (int quantidade) {
        this.sanidade -= quantidade;
        if(this.sanidade <= 0){
            System.out.print("Você enlouqueceu. Fim de jogo.");
        }
    }
    //STATUS
    public Status getStatus(){
        return this.status;
    }
    //INVENTARIO
    public Inventario getInventario(){
        return this.inventario;
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