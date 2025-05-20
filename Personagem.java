public abstract class Personagem{
        
    private final String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private final Inventario inventario;
    private Ambiente localizacao;
    private boolean emCombate = false;
    private boolean condicaoVitoria = false;
    private boolean condicaoDerrota = false;
    private final GerenciadorDeAmbiente pontoDePartida = new GerenciadorDeAmbiente();

    public Personagem(String nome, int vida, int fome, int sede, int energia, int sanidade){
        this.nome = nome;
        this.vida = 100;
        this.energia = 100;
        this.fome = 100;
        this.sede = 100;
        this.sanidade = 100;
        this.inventario = new Inventario(50);
        this.localizacao = pontoDePartida.gerarAleatorio();
    }

    public abstract void usarHabilidade();


    public String getNome(){
        return this.nome;
    }

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
        this.vida -= quantidade;
        if(this.vida <=0){
            System.out.print("Voce sucumbiu aos seus ferimentos. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    public boolean getEmCombate(){
        return this.emCombate;
    }

    public void setEmCombate(boolean emCombate){
        this.emCombate = emCombate;
    }

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
        this.energia -= quantidade;
        if (this.energia <= 0) {
            System.out.print("Sua energia acabou. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

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
        this.fome -= quantidade;
        if(this.fome <= 0){
            System.out.print("Voce morreu de fome. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }

    public int getSede(){
        return this.sede;
    }

    public void setSede(int sede){
        this.sede = sede;
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
            this.condicaoDerrota = true;
        }
    }

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

    public void perderSanidade (int quantidade) {
        this.sanidade -= quantidade;
        if(this.sanidade <= 0){
            System.out.print("Você enlouqueceu. Fim de jogo.");
            this.condicaoDerrota = true;
        }
    }
}