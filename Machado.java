public class Machado extends Ferramenta{

    public Machado(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Machado", "Uma serra seria melhor.", 2, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++){
            Material madeira = Material.TipoDeMaterial.MADEIRA.criarMaterial(this.getGeradorDeID());
            if(jogador.getLocalizacao().diminuirRecurso("Madeira")){
                jogador.getRecursosProximos().add(madeira);
            }
        }
        jogador.exibirRecursosProximos();
    }
}
