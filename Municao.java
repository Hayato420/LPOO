public class Municao extends Item{
    private int quantiaAtual;
    private final int quantiaMax;
    private final Material material1;
    private final Material material2;
    
    public Municao(String nome, String descricao, int peso, int durabilidade, int quantiaMax,
                   Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.material1 = material1;
        this.material2 = material2;
        this.quantiaAtual = quantiaMax;
        this.quantiaMax = quantiaMax;
    }
    //QUANTIA
    public void getQuantia(){
        return this.quantia;
    }
    public void setQuantia(int quantia){
        this.quantia = quantia;
    }
    
    public void diminuirQuantia(Personagem jogador, int quantia){
        this.quantiaAtual -= quantia;
        if(this.quantiaAtual <= 0){
            jogador.getInventario().removerItem(this.getID());
        }
    }
    public void aumentarQuantia(Personagem jogador, int quantia){
        this.quantiaAtual += quantia;
        if(this.quantiaAtual > this.quantiaMax){this.quantiaAtual = this.quantiaMax;}
    }

    public void usar(Personagem jogador){
        System.out.println("Usavel em outro item.");
    }

    public void feitaDe(){
        if(this.material1.getTipoDeMaterial() == this.material2.getTipoDeMaterial()){
            System.out.println("Feita de " + material1.getNome() + ".");
        }
        else{
        System.out.println("Feita de " + material1.getNome() + " e " + material2.getNome() + ".");
        }
    }
}
