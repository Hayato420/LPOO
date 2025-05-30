public class Arco extends Arma{
    public Arco(TipoArma tipo, QualArma qual, int alcance, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Arco", "É bom ter flechas.", 2, geradorDeID, tipo, qual, alcance, material1, material2);
    }
    public void usar(Personagem jogador){
        //uso do arco em combate
    }
}