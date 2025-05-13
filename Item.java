import java.util.UUID;

public class Item{
    private final String nome;
    private final String ID;
    private final String descricao;
    private final int peso;
    private int durabilidade;

    public Item(String nome, String descricao, int peso, int durabilidade){
        this.nome = nome;
        this.ID = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    public void exercerUso(){
    //abstrato
    }
    public String getNome(){
        return this.nome;
    }

    public String getID(){
        return this.ID;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getPeso(){
        return this.peso;
    }

    public int getDurabilidade(){
        return this.durabilidade;
    }

    public void perderDurabilidade(Inventario inventario){
        this.durabilidade -= 1;
        if(this.durabilidade <= 0){
            System.out.println("A ferramenta quebrou.");
            inventario.removerItem(this.ID);
        }
    }

}
