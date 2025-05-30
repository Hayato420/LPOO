public class Isqueiro extends Ferramenta{
/*private boolean ligado; dirá se está ligado, consumido quantiaAtual de Pilhas no inventario 
(representa energia, mas sera quantas pilhas ainda sobram na logica, assim como numero de balas e flechas)*/

    public Isqueiro(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Isqueiro", "Fogo !", 1, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        //+incendiar e talvez iluminar
    }
}
