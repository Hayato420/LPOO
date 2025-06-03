import java.util.concurrent.ThreadLocalRandom;

public class Armadilha extends Item{
    private final Corda corda1;
    private final Corda corda2;

    public Armadilha(Corda corda1, Corda corda2, GeradorDeID geradorDeID){
        super("Armadilha", "Ja comeu carne de coelho?", 1, 1, geradorDeID);
        this.corda1 = corda1;
        this.corda2 = corda2;
    }

    @Override
    public void usar(Personagem jogador){
        int chance = ThreadLocalRandom.current().nextInt(1, 11);
        if(chance <= 5){
            jogador.getRecursosProximos().add(new CoelhoCru(this.getGeradorDeID()));
            System.out.println("Um coelho foi capturado");
            jogador.exibirRecursosProximos();
            jogador.getInventario().removerItem(this.getID());
        }
        else{
            System.out.println("Nada foi capturado");
            jogador.getInventario().removerItem(this.getID());
        }
    }

    public Corda getCorda1(){
        return this.corda1;
    }
    public Corda getCorda2(){
        return this.corda2;
    }
}
