public class Faca extends Ferramenta{

    public Faca(String nome, String descricao, int peso, Material material1, Material material2) {
        super(nome, descricao, peso, material1, material2);
    }

    public void exercerUso(Personagem jogador){
        jogador.perderEnergia(5);
        //+coletar recursos, como plantas ribeirinhas ou carne de animais mortos talvez
    }
}
