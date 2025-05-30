public class Vicodin extends Tratamento{    
    public Vicodin(GeradorDeID geradorDeID){
        super("Vicodin", "Doutor House.", 1, 1, 10, geradorDeID);
    }

    @Override
    public void usar(Personagem jogador){
        jogador.adicionarVida(this.getCura());
        jogador.getStatus().setPerturbado(false);
    }
}