public abstract class Arma extends Item{
//MUNICAO SERA ITENS NO INVENTARIO, ARCO->FLECHA, PISTOLA->BALA, ETC.
    private final Material material1;
    private final Material material2;
    private final TipoArma tipo;
    public enum TipoArma{
        corpoACorpo,
        aDistancia
    }
    private final QualArma qual;
    public enum QualArma{
        ARCO,
        ESPADA,
        LANCA,
        PISTOLA
    }
    private final int dano;
    private final int alcance;

    public Arma(String nome, String descricao, int peso, GeradorDeID geradorDeID, TipoArma tipo, 
                QualArma qual, int alcance, Material material1, Material material2){
        super(nome, descricao, peso, material1.getResistencia() + material2.getResistencia(), geradorDeID);
        this.tipo = tipo;
        this.qual = qual;
        this.alcance = alcance;
        this.material1 = material1;
        this.material2 = material2;
        this.setDescricao(this.getDescricao() + " " + this.feitaDe());
        //dano calculado dependendo do tipo de arma
        if (tipo == TipoArma.corpoACorpo){
            this.dano = (material1.getResistencia()+material2.getResistencia())/4;//LÓGICA ARITMÉTICA PARA DETERMINAR O DANO COM BASE NOS MATERIAIS
        }
        else if (tipo == TipoArma.aDistancia){
            this.dano = 0; //o dano será determinado pela munição
        }
        else{this.dano = 0; System.out.println("Tipo inválido. Necessário debug no valor repassado ao construtor de Arma.");}//isso NUNCA deverá aparecer para o player
    }

    public String feitaDe(){
        if(material1.getTipoDeMaterial() == material2.getTipoDeMaterial()){
            return "Feita de " + material1.getNome() + ".";
        }
        else{
            return "Feita de " + material1.getNome() + " e " + material2.getNome() + ".";
        }
    }

    public TipoArma getTipo(){
        return this.tipo;
    }

    public QualArma getQual(){
        return this.qual;
    }

    public int getDano(){
        return this.dano;
    }

    public int getAlcance(){
        return this.alcance;
    }

    public Material getMaterial1(){
        return this.material1;
    }

    public Material getMaterial2(){
        return this.material2;
    }
}