public abstract class Tratamento extends Item{
  private final int cura;

  public Tratamento(String nome, String descricao, int peso, int durabilidade, int cura, GeradorDeID geradorDeID){
    super(nome, descricao, peso, durabilidade, geradorDeID);
    this.cura = cura;
  }

  public abstract void usar(Personagem jogador);

  public int getCura(){
    return this.cura;
  }
}
