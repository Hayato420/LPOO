public class Antibiotico extends Tratamento{
    public Antibiotico(GeradorDeID geradorDeID){
        super("Antibiotico", "Trata infeccoes.", 1, 1, 0, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
        jogador.getStatus().setDoente(false);
    }
}