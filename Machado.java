public class Machado extends Ferramenta{

    public Machado(String nome, String descricao, int peso, Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++){
            Material madeira = Material.TipoDeMaterial.MADEIRA.criarMaterial(this.getGeradorDeID());
            jogador.getRecursosProximos().add(madeira);
            jogador.getLocalizacao().diminuirRecurso("Madeira");
        }
        jogador.exibirRecursosProximos();
    }
}
