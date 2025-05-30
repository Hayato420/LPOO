public class Lanca extends Arma{
    public Lanca(TipoArma tipo, QualArma qual, int alcance, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Lança", "Espeta !", 3, geradorDeID, tipo, qual, alcance, material1, material2);
    }
    public void usar(Personagem jogador){
        //uso da lanca em combate
    }
}