import java.util.concurrent.ThreadLocalRandom;

public class Isqueiro extends Ferramenta{
/*private boolean ligado; dirá se está ligado, consumido quantiaAtual de Pilhas no inventario 
(representa energia, mas sera quantas pilhas ainda sobram na logica, assim como numero de balas e flechas)*/

    public Isqueiro(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Isqueiro", "Ta pegando fogo bicho !", 1, material1, material2, geradorDeID);
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
            jogador.coletarAmbiente(ThreadLocalRandom.current().nextInt(0, 4)); //menos recursos que Lanterna
            System.out.println("============================================================");
            jogador.getGerenciadorDeEvento().gerarEvento().efeitoDoEvento(jogador);
    }
}