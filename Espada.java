public class Espada extends Arma{
    public Espada(TipoArma tipo, QualArma qual, int alcance, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Espada", "Avante !", 3, geradorDeID, tipo, qual, alcance, material1, material2);
    }
    public void usar(Personagem jogador){
        //uso da espada em combate
    }
}