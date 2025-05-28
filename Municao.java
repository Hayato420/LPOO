public class Municao extends Item{
    private int quantia;
    public Municao(String nome, String descricao, int peso, int durabilidade, GeradorDeID geradorDeID, int quantia){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.quantidade = quantia;
    }
}