import java.util.concurrent.ThreadLocalRandom;

public class Picareta extends Ferramenta{

    public Picareta(String nome, String descricao, int peso, Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, material1, material2, geradorDeID);
    }

    public void usar(Personagem jogador){
        jogador.perderEnergia(5);
        this.perderDurabilidade(jogador.getInventario());
        for (int i = 0; i < 5; i++) {
            int chance = ThreadLocalRandom.current().nextInt(1,11); //incluso 1, excluso 11
            if (chance <= 7){
                Material pedra = Material.TipoDeMaterial.PEDRA.criarMaterial(this.getGeradorDeID());
                jogador.getInventario().adicionarItem(pedra);
                //AINDA FALTA DIMINUIR QUANTIDADE DE RECURSOS DISPONIVEIS NO AMBIENTE
            }
            else{
                Material metal = Material.TipoDeMaterial.METAL.criarMaterial(this.getGeradorDeID());
                jogador.getInventario().adicionarItem(metal);
                //AINDA FALTA DIMINUIR QUANTIDADE DE RECURSOS DISPONIVEIS NO AMBIENTE
            }
        }
    } 
}