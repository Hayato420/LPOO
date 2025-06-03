public class InimigoCobra extends Inimigo{

    public InimigoCobra(){
        super("cobra","Sem bracos ou pernas, mas nao deve ser subestimada", 7, 4, 3, 2, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setEnvenenado(true);     //a cobra envenena o jogador
    }

}