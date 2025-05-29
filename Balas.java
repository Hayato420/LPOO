public class Balas extends Municao{
    private final int quantiaMax;

    public Balas(int quantiaAtual, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Balas", "Perfurante.", 1, 1, quantiaAtual, material1, material2, geradorDeID);
        this.quantiaMax = 10;
    }

    @Override
    public void aumentarQuantia(Personagem jogador, int quantiaAdicionada){ //getQuantiaAtual() do novo item passado como parâmetro
        if (quantiaAdicionada <= 0) return;
        for (Item item : jogador.getInventario().getItens()){
            if (item instanceof Balas){
                Balas balas = (Balas) item;
                int complemento = balas.getQuantiaMax() - balas.getQuantiaAtual();
                int qtdRestante = Math.min(quantiaAdicionada, complemento);
                balas.setQuantiaAtual(balas.getQuantiaAtual() + qtdRestante);
                quantiaAdicionada -= qtdRestante;
                if (quantiaAdicionada == 0) break;
            }
        }
    }

    public int getQuantiaMax(){
        return this.quantiaMax;
    }
}
