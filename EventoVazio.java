public class EventoVazio extends Evento{

    public EventoVazio(){
        super("","nada ocorre");
    }

    @Override
    public void efeitoDoEvento(Personagem personagem){
        System.out.println("nada ocorre");
    }

}