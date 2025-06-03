public abstract class Material extends Item{
//EXEMPLO DE CRIAÇÃO DE MATERIAL: Material metal = Material.TipoDeMaterial.METAL.criarMaterial(geradorDeID);
    private final TipoDeMaterial tipoDeMaterial;
    public enum TipoDeMaterial{
        MADEIRA("Madeira", "Versátil.", 2, 1, 14),
        PEDRA("Pedra", "Pedra.", 2, 1, 20),
        FIBRA("Fibra", "Unidirecionalmente resistente.", 1, 1, 5),
        METAL("Metal", "Mais resistente devido à deformação plástica e ligações não direcionais.", 3, 1, 40),
        METALINOX("Metal inoxidável", "Anticorrosivo e resistente.", 3, 1, 5000);

        private final String nome;
        private final String descricao;
        private final int peso;
        private final int durabilidade;
        private final int resistencia;

        TipoDeMaterial(String nome, String descricao, int peso, int durabilidade, int resistencia){
            this.nome = nome;
            this.descricao = descricao;
            this.peso = peso;
            this.durabilidade = durabilidade;
            this.resistencia = resistencia;
        }

        public Material criarMaterial(GeradorDeID geradorDeID){
            switch (this){
                case MADEIRA:
                    return new Madeira(geradorDeID);
                case METAL:
                    return new Metal(geradorDeID);
                case METALINOX:
                    return new MetalInox(geradorDeID);
                case PEDRA:
                    return new Pedra(geradorDeID);
                case FIBRA:
                    return new Fibra(geradorDeID);
                default:
                    throw new IllegalArgumentException("Tipo de material não listado: " + this);
            }
        }

        public String getNome(){return this.nome;}
        public String getDescricao(){return this.descricao;}
        public int getPeso(){return this.peso;}
        public int getDurabilidade(){return this.durabilidade;}
        public int getResistencia(){return this.resistencia;}
    }

    //construtor da classe, que repassara o tipoDeMaterial para o enum. O enum gerencia resistencia automaticamnte, evitando varios ifs e permitindo adicao de materiais facilmente
    public Material (String nome, String descricao, int peso, int durabilidade, GeradorDeID geradorDeID, TipoDeMaterial tipoDeMaterial){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.tipoDeMaterial = tipoDeMaterial;
    }

    //getter da classe, usando o getter do enum
    public String getNome(){return tipoDeMaterial.getNome();}
    public String getDescricao(){return tipoDeMaterial.getDescricao();}
    public int getPeso(){return tipoDeMaterial.getPeso();}
    public int getDurabilidade(){return tipoDeMaterial.getDurabilidade();}
    public int getResistencia(){return tipoDeMaterial.getResistencia();}

    public TipoDeMaterial getTipoDeMaterial(){
        return tipoDeMaterial;
    }

    public void usar(Personagem jogador){
        System.out.println("Combine em ferramentas !");
    }
}