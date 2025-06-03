public class Corda extends Item{
    private final Material material1;
    private final Material material2;

    public Corda(Material material1, Material material2, GeradorDeID geradorDeID){
        super("Corda", "Suporta tracao.", 1, 1, geradorDeID);
        this.material1 = material1;
        this.material2 = material2;
    }

    @Override
    public void usar(Personagem jogador){
        System.out.println("Boa para fazer armadilhas.");
    }

    public Material getMaterial1(){
        return this.material1;
    }
    public Material getMaterial2(){
        return this.material2;
    }
}
