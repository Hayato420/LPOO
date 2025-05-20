public abstract class Municao extends Item{
    private final Material material1;
    private final Material material2;
    private final int dano;
    private final TipoDeMunicao tipoDeMunicao;

    public enum TipoDeMunicao{
        BALA("Bala", "Pow pow !", 1, 5),
        FLECHA("Flecha", "Primitivo mas eficaz.", 2, 10),
        FLUIDO_DE_ISQUEIRO("Fluido de Isqueiro", "Líquido inflamável.", 1, 3),
        PILHA("Pilha", "Bzzt !", 1, 8);

        private final String nome;
        private final String descricao;
        private final int peso;
        private final int durabilidade;

        TipoDeMunicao(String nome, String descricao, int peso, int durabilidade){
            this.nome = nome;
            this.descricao = descricao;
            this.peso = peso;
            this.durabilidade = durabilidade;
        }

        public String getNome(){return nome;}
        public String getDescricao(){return descricao;}
        public int getPeso(){return peso; }
        public int getDurabilidade(){return durabilidade;}
    }

    public Municao(Material material1, Material material2, TipoDeMunicao tipoDeMunicao, GeradorDeID geradorDeID){
        super(
            tipoDeMunicao.getNome(),
            tipoDeMunicao.getDescricao(),
            tipoDeMunicao.getPeso(),
            tipoDeMunicao.getDurabilidade(),
            geradorDeID
        );
        this.material1 = material1;
        this.material2 = material2;
        this.tipoDeMunicao = tipoDeMunicao;

        if (material1.getTipoDeMaterial() == Material.TipoDeMaterial.METALINOX &&
            material2.getTipoDeMaterial() == Material.TipoDeMaterial.METALINOX){
            this.dano = 40;
        } else{
            this.dano = (material1.getResistencia() + material2.getResistencia()) / 6;
        }
    }

    public String getNome(){return tipoDeMunicao.getNome();}
    public String getDescricao(){return tipoDeMunicao.getDescricao();}
    public int getPeso(){return tipoDeMunicao.getPeso();}
    public int getDurabilidade(){return tipoDeMunicao.getDurabilidade();}
    public int getDano(){return this.dano;}

    public void feitaDe(){
        if(material1.getTipoDeMaterial() == material2.getTipoDeMaterial()){
            System.out.println("Feita de " + material1.getNome() + ".");
        }
        else{
        System.out.println("Feita de " + material1.getNome() + " e " + material2.getNome() + ".");
        }
    }

}