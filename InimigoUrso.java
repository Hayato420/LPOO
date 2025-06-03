public class InimigoUrso extends Inimigo{

    public InimigoUrso(){
        super("Urso", "Uma criatura grande e peluda, parece faminto", 25, 1, 10, 5, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setFraturado(true);
    }

}