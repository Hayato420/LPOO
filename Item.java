public class Item{
    private String nome;
    private String descricao;
    private int peso;
    private int durabilidade;
    public void usar(){}
    public void beber(){}
    public void consumir(){}

    public Item(String nome, String descricao, int peso, int durabilidade){
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }
}