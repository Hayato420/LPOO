public class EventoClimatico extends Evento{

    //construtor
    public EventoClimatico(){
        super("Evento Climatico", "Mudancas inesperadas ocorrem no tempo do ambiente de acordo com o clima.");
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        if(jogador.getLocalizacao()getClass() == AmbienteCaverna.class){
            System.out.println("Estalagmites cairam sobre voce.");
            jogador.perderVida(20);
        }
        else if(jogador.getLocalizacao()getClass() == AmbienteDeserto.class){
            System.out.println("Voce se deparou com uma tempestade de areia.");
            jogador.perderSede(20);
            jogador.perderEnergia(10);
        }
        else if(jogador.getLocalizacao()getClass() == AmbienteFloresta.class){
            System.out.println("Uma chuva intensa lhe encharcou, melhor se aquecer logo.");
            jogador.getStatus().setTemperatura(Status.Temperatura.FRIO);
        }
        else if(jogador.getLocalizacao()getClass() == AmbienteLagoRio.class){
            System.out.println("Uma inundacao inesperada lhe encharcou, voce sente frio.");
            jogador.perderEnergia(10);
            jogador.getStatus().setTemperatura(Status.Temperatura.FRIO);
        }
        else if(jogador.getLocalizacao()getClass() == AmbienteMontanha.class){
            System.out.println("Esta nevando, apesar de bonito, isso representa um perigo a sua temperatura.");
            jogador.getStatus().setTemperatura(Status.Temperatura.FRIO);
        }
        else{//AmbienteRuinas
            System.out.println("Um pedaco do teto caiu sobre voce.");
            jogador.perderVida(10);
        }
    }
}
