import java.util.concurrent.ThreadLocalRandom;

public class Picareta extends Ferramenta{

    public Picareta(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Picareta", "First we mine, then we craft !", 3, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        if(jogador.getLocalizacao().getClass() == AmbienteLagoRio.class ||
            jogador.getLocalizacao().getClass() == AmbienteRuinas.class){
            System.out.println("Este ambiente impossibilita o uso desta ferramenta.");
            return;
        }
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++){
            int chance = ThreadLocalRandom.current().nextInt(1,11); //incluso 1, excluso 11
            if (chance <= 7){
                Material pedra = Material.TipoDeMaterial.PEDRA.criarMaterial(this.getGeradorDeID());
                jogador.getRecursosProximos().add(pedra);
            }
            else{
                Material metal = Material.TipoDeMaterial.METAL.criarMaterial(this.getGeradorDeID());
                jogador.getRecursosProximos().add(metal);
            }
        }
        jogador.exibirRecursosProximos();
    }
}
