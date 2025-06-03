public abstract class Item implements Usavel{
    private final String nome;
    private final String ID;
    private String descricao;
    private final int peso;
    private int durabilidade;
    private final GeradorDeID geradorDeID;

    public Item(String nome, String descricao, int peso, int durabilidade, GeradorDeID geradorDeID){
        this.nome = nome;
        this.ID = geradorDeID.gerarIDExclusiva();
        this.descricao = descricao;
        this.peso = peso;
        this.durabilidade = durabilidade;
        this.geradorDeID = geradorDeID;
    }

    public abstract void usar(Personagem jogador);

    public String getNome(){
        return this.nome;
    }

    public String getID(){
        return this.ID;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getPeso(){
        return this.peso;
    }

    public int getDurabilidade(){
        return this.durabilidade;
    }

    public GeradorDeID getGeradorDeID(){
        return this.geradorDeID;
    }

    public void perderDurabilidade(Inventario inventario){
        this.durabilidade -= 1;
        if(this.durabilidade <= 0){
            System.out.println("A ferramenta quebrou.");
            inventario.removerItem(this.ID);
        }
    }
}