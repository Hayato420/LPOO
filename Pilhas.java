public class Pilhas extends Municao{
    private final int quantiaMax;

    public Pilhas(int quantiaAtual, Material material1, Material material2, GeradorDeID geradorDeID){
        super("Pilhas", "Oxirreducao do balacobaco !", 1, 1, quantiaAtual, material1, material2, geradorDeID);
        this.quantiaMax = 20;
    }

    @Override
    public void aumentarQuantia(Personagem jogador, int quantiaAdicionada){ //getQuantiaAtual() do novo item passado como parâmetro
        if (quantiaAdicionada <= 0) return;
        for (Item item : jogador.getInventario().getItens()){
            if (item instanceof Pilhas){
                Pilhas pilhas = (Pilhas) item;
                int complemento = pilhas.getQuantiaMax() - pilhas.getQuantiaAtual();
                int qtdRestante = Math.min(quantiaAdicionada, complemento);
                pilhas.setQuantiaAtual(pilhas.getQuantiaAtual() + qtdRestante);
                quantiaAdicionada -= qtdRestante;
                if (quantiaAdicionada == 0) break;
            }
        }
    }

    public int getQuantiaMax(){
        return this.quantiaMax;
    }
}
