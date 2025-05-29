public class Municao extends Item{
    private int quantia;
    private final Material material1;
    private final Material material2;
    
    public Municao(String nome, String descricao, int peso, int durabilidade, int quantia,
                   Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.material1 = material1;
        this.material2 = material2;
        this.quantidade = quantia;
    }
    //QUANTIA
    public void getQuantia(){
        return this.quantia;
    }
    public void setQuatia(int quantia){
        this.quantia = quantia;
    }
    public void diminuirQuantia(int quantia){
        this.quantia -= quantia;
    }
    public void aumentarQuantia(int quantia){
        this.quantia += quantia;
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
