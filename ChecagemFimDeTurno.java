public class ChecagemFimDeTurno{
    public void checar(Personagem jogador){

        if(jogador.getVida() <= 0 ||
            jogador.getFome() <= 0 ||
            jogador.getSede() <= 0 ||
            jogador.getEnergia() <= 0 ||
            jogador.getSanidade() <= 0){
            jogador.setCondicaoDerrota(true);
            return;
        }

        else if(jogador.getEmResgate() <= 0){
            jogador.setCondicaoVitoria(true);
            return;
        }

        else{
            if(jogador.getSanidade() < 50){
                System.out.println("Voce avista sombras sussurrantes a distancia.");
            }
        }
    }

    public void aplicarEfeitos(Personagem jogador){
        jogador.perderFome(5);
        jogador.perderSede(5);
        if(jogador.getEmResgate() <= 5){
            jogador.setEmResgate(jogador.getEmResgate() - 1);
        }
        if(jogador.getFonteDeCalor() != null && jogador.getStatus().getTemperatura() == Status.Temperatura.FRIO){
            jogador.getStatus().setTemperatura(Status.Temperatura.NORMAL);
        }
        if(jogador.getStatus().isEnvenenado()){
            jogador.perderVida(10);
        }
        if(jogador.getStatus().isDoente()){
            jogador.perderVida(10);
        }
        if(jogador.getStatus().isPerturbado()){
            System.out.println("BLU BLU BLEH BLEH BLU BLU !!!!");
            jogador.perderSanidade(10);
        }
        if(jogador.getStatus().getTemperatura() == Status.Temperatura.CALOR){
            jogador.perderEnergia(5);
        }
        if(jogador.getStatus().getTemperatura() == Status.Temperatura.FRIO){
            jogador.perderEnergia(5);
        }
    }
}