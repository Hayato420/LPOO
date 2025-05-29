public class Municao extends Item{
    private int quantia;
    public Municao(String nome, String descricao, int peso, int durabilidade, GeradorDeID geradorDeID, int quantia){
        super(nome, descricao, peso, durabilidade, geradorDeID);
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
}
