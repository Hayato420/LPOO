public class Material extends Item{

    private final TipoDeMaterial tipoDeMaterial;
    public enum TipoDeMaterial{
        MADEIRA(10),
        PEDRA(20),
        PALHA(5),
        METAL(40);

        private final int resistencia;
        //ao definir o tipoDeMaterial, o construtor do enum atribui automaticamente sua resistencia
        TipoDeMaterial(int resistencia){
            this.resistencia = resistencia;
        }
        //getter do enum, para ter acesso a resistencia na classe Material
        public int getResistencia(){
            return this.resistencia;
        }
    }

    //construtor da classe, que repassara o tipoDeMaterial para o enum. O enum gerencia resistencia automaticamnte, evitando varios ifs e permitindo adicao de materiais facilmente
    public Material (String nome, String descricao, int peso, int durabilidade, TipoDeMaterial tipoDeMaterial){
        super(nome, descricao, peso, durabilidade);
        this.tipoDeMaterial = tipoDeMaterial;
    }
    //getter da classe, usando o getter do enum
    public int getResistencia(){
        return tipoDeMaterial.getResistencia();
    }

    //JUNTA DOIS MATERIAIS, AINDA PRECISAMOS ADICIONAR UM VERIFICADOR PRA VER SE OS MATERIAIS EXISTEM NO INVENTARIO
    public void combinarEspada(GeradorDeItens geradorDeItens, Inventario inventario, Material material1, Material material2){
        geradorDeItens.gerarEspada(material1, material2);
        inventario.removerItem(material1.getID());
        inventario.removerItem(material2.getID());
    }
    
    public void combinarArco(GeradorDeItens geradorDeItens, Inventario inventario, Material material1, Material material2){
        geradorDeItens.gerarArco(material1, material2);
        inventario.removerItem(material1.getID());
        inventario.removerItem(material2.getID());
    }

    public void combinarFaca(GeradorDeItens geradorDeItens, Inventario inventario, Material material1, Material material2){
        geradorDeItens.gerarFaca(material1, material2);
        inventario.removerItem(material1.getID());
        inventario.removerItem(material2.getID());
    }
}
