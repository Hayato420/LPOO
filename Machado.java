public class Machado extends Ferramenta{

    public Machado(String nome, String descricao, int peso, Material material1, Material material2) {
        super(nome, descricao, peso, material1, material2);
    }

    public void exercerUso(Personagem jogador){
        jogador.perderEnergia(10);
        //+coletar madeira
    }
}
