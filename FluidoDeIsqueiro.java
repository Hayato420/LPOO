public class FluidoDeIsqueiro extends Municao{
    private final int quantiaMax;

    public FluidoDeIsqueiro(int quantiaAtual, Material material1, Material material2, GeradorDeID geradorDeID){
        super("FluidoDeIsqueiro", "Nao beba isso, tem cheiro de petroleo.", 1, 1, quantiaAtual, material1, material2, geradorDeID);
        this.quantiaMax = 10;
    }

    @Override
    public void aumentarQuantia(Personagem jogador, int quantiaAdicionada){ //getQuantiaAtual() do novo item passado como parâmetro
        if (quantiaAdicionada <= 0) return;
        for (Item item : jogador.getInventario().getItens()){
            if (item instanceof FluidoDeIsqueiro){
                FluidoDeIsqueiro fluidoDeIsqueiro = (FluidoDeIsqueiro) item;
                int complemento = fluidoDeIsqueiro.getQuantiaMax() - fluidoDeIsqueiro.getQuantiaAtual();
                int qtdRestante = Math.min(quantiaAdicionada, complemento);
                fluidoDeIsqueiro.setQuantiaAtual(fluidoDeIsqueiro.getQuantiaAtual() + qtdRestante);
                quantiaAdicionada -= qtdRestante;
                if (quantiaAdicionada == 0) break;
            }
        }
    }

    public int getQuantiaMax(){
        return this.quantiaMax;
    }
}
