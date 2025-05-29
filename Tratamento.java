public abstract class Tratamento extends Item{
  private final int cura;
  public Tratamento(int cura){
    this.cura = cura;
  }
  @Override
  public abstract void usar(){}
}
