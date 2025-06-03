public class InimigoCorvos extends Inimigo{

    public InimigoCorvos(){
        super("Corvos","Como diriam os americanos: \"Um assassinato de corvos\".", 5, 7, 3, 0, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setPerturbado(true);
    }

}