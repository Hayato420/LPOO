public class InimigoCobra extends Inimigo{

    public InimigoCobra(){
        super("Cobra","Macarrao perigoso.", 7, 4, 3, 2, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setEnvenenado(true);     //a cobra envenena o jogador
    }

}