public class Faca extends Ferramenta{

    public Faca(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Faca", "Tromantino.", 1, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++){
            Material fibra = Material.TipoDeMaterial.FIBRA.criarMaterial(this.getGeradorDeID());
            if(jogador.getLocalizacao().diminuirRecurso("Fibra")){
                jogador.getRecursosProximos().add(fibra);
            }
        }
        jogador.exibirRecursosProximos();
    }
}
