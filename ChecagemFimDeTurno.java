public class ChecagemFimDeTurno{
    public boolean checar(Personagem jogador){
        if(jogador.getVida() <= 0 ||
            jogador.getFome() <= 0 ||
            jogador.getSede() <= 0 ||
            jogador.getEnergia() <= 0 ||
            jogador.getSanidade() <= 0){return false;}
        else{return true;}
    }
    
}