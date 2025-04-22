public class Arma extends Item{
//MUNICAO SERA ITENS NO INVENTARIO, ARCO->FLECHA, PISTOLA->BALA, ETC.
    private tipoArma tipo;
    public enum tipoArma{
        corpoACorpo,
        aDistancia
    }
    private qualArma qual;
    public enum qualArma{
        ESPADA,
        ARCO,
        PISTOLA
    }
    private int dano;
    private int alcance;

    public Arma(String nome, String descricao, int peso, int durabilidade, tipoArma tipo, qualArma qual, int dano, int alcance){
        super(nome, descricao, peso, durabilidade);
        this.tipo = tipo;
        this.qual = qual;
        this.dano = dano;
        this.alcance = alcance;
    }

    public tipoArma getTipo(){
        return this.tipo;
    }

    public qualArma getQual(){
        return this.qual;
    }

    public int getDano(){
        return this.dano;
    }

    public int getAlcance(){
        return this.alcance;
    }
}
