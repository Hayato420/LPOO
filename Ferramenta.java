public abstract class Ferramenta extends Item{
    private final int eficiencia;
    private final Material material1;
    private final Material material2;

    public Ferramenta(String nome, String descricao, int peso, Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, material1.getResistencia() + material2.getResistencia(), geradorDeID);
        this.material1 = material1;
        this.material2 = material2;
        this.eficiencia = (material1.getResistencia()+material2.getResistencia())/2;
    }

    public int getEficiencia(){
        return this.eficiencia;
    }

    public Material getMaterial1(){
        return this.material1;
    }

    public Material getMaterial2(){
        return this.material2;
    }

    public void feitaDe(){
        if(material1.getTipoDeMaterial() == material2.getTipoDeMaterial()){
            System.out.println("Feita de " + material1.getNome() + ".");
        }
        else{
        System.out.println("Feita de " + material1.getNome() + " e " + material2.getNome() + ".");
        }
    }

}
