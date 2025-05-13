public class Picareta extends Ferramenta{

    public Picareta(String nome, String descricao, int peso, Material material1, Material material2) {
        super(nome, descricao, peso, material1, material2);
    }

    public void exercerUso(Personagem jogador){
        jogador.perderEnergia(10);
        //+coletar pedra e metal
    }
}
