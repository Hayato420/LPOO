public class Lanterna extends Ferramenta{
//private boolean ligado; dirá se está ligado (portanto consumindo durabilidade) ou não.
    public Lanterna(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Lanterna", "Luz !", 1, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        //+iluminar
    }
}
