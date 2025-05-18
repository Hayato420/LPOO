public class Lanterna extends Ferramenta{
//private boolean ligado; dirá se está ligado (portanto consumindo durabilidade) ou não.
    public Lanterna(String nome, String descricao, int peso, GeradorDeID geradorDeID, Material material1, Material material2) {
        super(nome, descricao, peso, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        //+iluminar
    }
}
