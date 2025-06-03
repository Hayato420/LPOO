public class Faca extends Ferramenta{

    public Faca(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Faca", "Corte rapido ! Tromantino.", 1, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        if(jogador.getLocalizacao().getClass() == AmbienteCaverna.class ||
            jogador.getLocalizacao().getClass() == AmbienteDeserto.class){
            System.out.println("Este ambiente impossibilita o uso desta ferramenta.");
            return;
        }
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++){
            Material fibra = Material.TipoDeMaterial.FIBRA.criarMaterial(this.getGeradorDeID());
            jogador.getRecursosProximos().add(fibra);
        }
        jogador.exibirRecursosProximos();
    }
}
