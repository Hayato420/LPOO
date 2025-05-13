public class Arma extends Item{
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
        ESPADA,
        ARCO,
        PISTOLA
    }
    private final int dano;
    private final int alcance;

    public Arma(String nome, String descricao, int peso, TipoArma tipo, QualArma qual, int dano, int alcance, Material material1, Material material2){
        super(nome, descricao, peso, material1.getResistencia() + material2.getResistencia());
        this.tipo = tipo;
        this.qual = qual;
        this.dano = dano;
        this.alcance = alcance;
        this.material1 = material1;
        this.material2 = material2;
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
