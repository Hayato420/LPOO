public abstract class Evento{

    private final String nome;
    private final String descricao;
    private final GeradorDeID geradorDeID = new GeradorDeID();

    public Evento(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract void efeitoDoEvento(Personagem personagem);

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public GeradorDeID getGeradorDeID(){
        return this.geradorDeID;
    }
}