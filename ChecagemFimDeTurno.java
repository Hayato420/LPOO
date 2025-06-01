public class ChecagemFimDeTurno{
    public boolean checar(Personagem jogador){
        if(jogador.getVida() <= 0 ||
            jogador.getFome() <= 0 ||
            jogador.getSede() <= 0 ||
            jogador.getEnergia() <= 0 ||
            jogador.getSanidade() <= 0){return false;}
        else{return true;}
    }
    public void aplicarEfeitos(Personagem jogador){
        jogador.perderFome(5);
        jogador.perderSede(5);
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