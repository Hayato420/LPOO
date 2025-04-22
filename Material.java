public class Material extends Item{
    
    public enum TipoDeMaterial{
        MADEIRA,
        PEDRA,
        METAL
    }

    private TipoDeMaterial tipoDeMaterial;
    private int resistencia;

    public int getResistencia(){
        return this.resistencia;
    }

    public Material(String nome, String descricao, int peso, int durabilidade, TipoDeMaterial tipoDeMaterial, int resistencia) {
        super(nome, descricao, peso, 1);
        this.tipoDeMaterial = tipoDeMaterial;
        this.resistencia = resistencia;
    }

    public void combinarEspada(Inventario inventario, Material material1, Material material2){
        inventario.gerarEspada(material1.getResistencia() + material2.getResistencia());
        inventario.removerItem(material1.getID());
        inventario.removerItem(material2.getID());
    }
    
    public void combinarArco(Inventario inventario, Material material1, Material material2){
        inventario.gerarArco(material1.getResistencia() + material2.getResistencia());
        inventario.removerItem(material1.getID());
        inventario.removerItem(material2.getID());
    }
}
