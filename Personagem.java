public class Personagem{
        
    private final String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private final Inventario inventario;
    private Ambiente localizacao;
    private final GerenciadorDeAmbiente pontoDePartida = new GerenciadorDeAmbiente();

    public Personagem(String nome){
        this.nome = nome;
        this.vida = 100;
        this.energia = 100;
        this.fome = 100;
        this.sanidade = 100;
        this.inventario = new Inventario(50);
        this.localizacao = pontoDePartida.gerarAleatorio();
    }

    /*public abstract void usarHabilidade();*/


    public String getNome(){
        return this.nome;
    }

    public Ambiente getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(Ambiente novaLocalizacao){
        this.localizacao = novaLocalizacao;
    }

    public Inventario getInventario(){
        return this.inventario;
    }

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

    public int getSede(){
        return this.sede;
    }

    public void adicionarSede(int quantidade){
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
}
