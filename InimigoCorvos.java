public class InimigoCorvos extends Inimigo{

    public InimigoCorvos(){
        super("Corvos","Um bando de corvos, pequenos, mas muitos", 5, 7, 3, 0, true);
    }

    @Override
    public void gerarStatus(Personagem personagem){
        personagem.getStatus().setPerturbado(true);
    }

}