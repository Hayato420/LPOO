public class Pistola extends Arma{
    public Pistola(String nome, String descricao, int peso, GeradorDeID geradorDeID, TipoArma tipo, 
                        QualArma qual, int alcance, Material material1, Material material2){
        super(nome, descricao, peso, geradorDeID, tipo, qual, alcance, material1, material2);
    }
    public void usar(Personagem jogador){
        //uso da pistola em combate
    }
}