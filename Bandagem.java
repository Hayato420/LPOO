public class Bandagem extends Tratamento{
    public Bandagem(GeradorDeID geradorDeID){
        super("Bandagem", "Poe seus ossos de volta no lugar.", 1, 1, 0, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
        jogador.getStatus().setFraturado(false);
        jogador.getInventario().removerItem(this.getID());
    }
}