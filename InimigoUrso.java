public class InimigoUrso extends Inimigo{

    public InimigoUrso(){
        super("Urso", "Can I pet that dawg?", 25, 1, 10, 2, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setFraturado(true);
    }

}