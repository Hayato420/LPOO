public class Antidoto extends Tratamento{
    public Antidoto(GeradorDeID geradorDeID){
        super("Antidoto", "Trata veneno.", 1, 1, 0, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
        jogador.getStatus().setEnvenenado(false);
        jogador.getInventario().removerItem(this.getID());
    }
}