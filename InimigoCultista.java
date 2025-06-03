public class InimigoCultista extends Inimigo{

    public InimigoCultista(){
        super("Cultista","Voce se deparou com um destino terrivel, nao foi?", 15, 3, 5, 3, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setEnvenenado(true);     //a faca está coberta de veneno
    }

}