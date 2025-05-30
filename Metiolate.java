public class Metiolate extends Tratamento{
    public Metiolate(GeradorDeID geradorDeID){
        super("Metiolate", "Arde !", 1, 1, 30, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
    }
}