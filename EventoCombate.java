public class EventoCombate extends Evento{

    public EventoCombate(){
        super("nome", "descricao");
    }

    @Override
    public void efeitoDoEvento(Personagem personagem){
        System.out.println("Voce entrou em combate");
        personagem.setEmCombate(true);
    }

}