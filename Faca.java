public class Faca extends Ferramenta{

    public Faca(String nome, String descricao, int peso, Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++) {
            Material fibra = Material.TipoDeMaterial.FIBRA.criarMaterial(this.getGeradorDeID());
            jogador.getInventario().adicionarItem(fibra);
        //AINDA FALTA DIMINUIR QUANTIDADE DE RECURSOS DISPONIVEIS NO AMBIENTE
        }
    }
}