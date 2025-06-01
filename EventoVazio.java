public class EventoVazio extends Evento{

    public EventoVazio(){
        super("Evento Vazio","Nada ocorre.");
    }

    @Override
    public void efeitoDoEvento(Personagem personagem){
        System.out.println("Nenhum evento inesperado ocorreu.");
    }

}