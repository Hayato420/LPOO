public class Arma extends Item{
    private tipoArma tipo;
    private enum tipoArma {
        corpoACorpo,
        aDistancia
    }
    private int dano;
    private int alcance;
    
    public Arma(String nome, String descricao, int peso, int durabilidade, tipoArma tipo, int dano, int alcance) {
        super(nome, descricao, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
        this.alcance = alcance;
    }

    public tipoArma getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public int getAlcance() {
        return alcance;
    }

    public static Arma gerarEspada() {
        return new Arma("Espada", "Uma espada afiada, mas de curta distancia.", 3, 10, tipoArma.corpoACorpo, 25, 1);
    }

    public static Arma gerarArco() {
        return new Arma("Arco", "Um arco de longa distancia.", 2, 10, tipoArma.aDistancia, 15, 3);
    }

    public static Arma gerarPistola() {
        return new Arma("Pistola", "Uma espada afiada, mas de curta distancia.", 2, 10, tipoArma.corpoACorpo, 25, 1);
    }
}