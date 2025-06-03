import java.util.concurrent.ThreadLocalRandom;

public class Lanterna extends Ferramenta{
//private boolean ligado; dirá se está ligado (portanto consumindo durabilidade) ou não.
    public Lanterna(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Lanterna", "Luz !", 1, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        int gastoPadraoDeEnergia = 5;
            if(jogador.getStatus().getTemperatura() == Status.Temperatura.FRIO 
            || jogador.getStatus().getTemperatura() == Status.Temperatura.CALOR){
                jogador.perderEnergia(gastoPadraoDeEnergia + 5);
            }
            else{
                jogador.perderEnergia(gastoPadraoDeEnergia);
            }
            jogador.getRecursosProximos().clear();
            jogador.coletarAmbiente(ThreadLocalRandom.current().nextInt(0, 6)); //mais recursos que Isqueiro
            System.out.println("============================================================");
            jogador.getGerenciadorDeEvento().gerarEvento().efeitoDoEvento(jogador);
    }
}
