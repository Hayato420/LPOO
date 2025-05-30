public class Panaceia extends Tratamento{
    public Panaceia(GeradorDeID geradorDeID){
        super("Panaceia", "Cura milagrosa.", 1, 1, 100, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
        jogador.getStatus().setEnvenenado(false);
        jogador.getStatus().setDoente(false);
        jogador.getStatus().setPerturbado(false);
        jogador.getStatus().setFraturado(false);
        jogador.getStatus().setTemperatura(Status.Temperatura.NORMAL);
    }
}