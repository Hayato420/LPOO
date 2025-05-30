public class Pistola extends Arma{
    public Pistola(TipoArma tipo, QualArma qual, int alcance, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Pistola", "Pow pow !", 1, geradorDeID, tipo, qual, alcance, material1, material2);
    }
    public void usar(Personagem jogador){
        //uso da pistola em combate
    }
}