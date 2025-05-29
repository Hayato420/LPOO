public class Flechas extends Municao{
    private final int quantiaMax;
    private final int dano;

    public Flechas(int quantiaAtual, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Flechas", "Balas primitivas !", 1, 1, quantiaAtual, material1, material2, geradorDeID);
        this.quantiaMax = 4;
        this.dano = (material1.getResistencia() + material2.getResistencia())/4
    }

    @Override
    public void aumentarQuantia(Personagem jogador, int quantiaAdicionada){ //getQuantiaAtual() do novo item passado como parâmetro
        if (quantiaAdicionada <= 0) return;
        for (Item item : jogador.getInventario().getItens()){
            if (item instanceof Flechas){
                Flechas flechas = (Flechas) item;
                int complemento = flechas.getQuantiaMax() - flechas.getQuantiaAtual();
                int qtdRestante = Math.min(quantiaAdicionada, complemento);
                flechas.setQuantiaAtual(flechas.getQuantiaAtual() + qtdRestante);
                quantiaAdicionada -= qtdRestante;
                if (quantiaAdicionada == 0) break;
            }
        }
    }

    public int getQuantiaMax(){
        return this.quantiaMax;
    }
    public int getDano(){
        return this.dano;
    }
}
