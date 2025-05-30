public abstract class Municao extends Item{
    private int quantiaAtual;
    //quantia maxima definida em cada item
    private final Material material1;
    private final Material material2;
    
    public Municao(String nome, String descricao, int peso, int durabilidade, int quantiaAtual,
                   Material material1, Material material2, GeradorDeID geradorDeID){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.material1 = material1;
        this.material2 = material2;
        this.quantiaAtual = quantiaAtual;//NAO FILTRA DE A QUANTIA ATUAL PASSA A MAXIMA, CUIDADO DEVE SER FEITO EM QUEM CHAMAR
    }
    //QUANTIA
    public int getQuantiaAtual(){
        return this.quantiaAtual;
    }

    public void setQuantiaAtual(int quantia){
        this.quantiaAtual = quantia;
    }

    //USO
    public void diminuirQuantia(Personagem jogador, int quantia){
        this.quantiaAtual -= quantia;
        if(this.quantiaAtual <= 0){
            jogador.getInventario().removerItem(this.getID());
        }
    }
    //RECARGA SE ADICIONAR MAIS AO INVENTARIO 
    public abstract void aumentarQuantia(Personagem jogador, int quantiaAdicionada);
    /*(Personagem jogador, int quantia){ //getQuantiaAtual() do novo item passado como parâmetro
        for (Item item : jogador.getInventario().getItens()){
            if (item instanceof XXXX){
                XXXX xxxx = (XXXX) item;
                int complemento = xxxx.getQuantiaMax() - xxxx.getQuantiaAtual();
                int qtdRestante = Math.min(quantia, complemento);
                xxxx.setQuantiaAtual(xxxx.getQuantiaAtual() + qtdRestante);
                quantia -= qtdRestante;
                if (quantia == 0) break;
            }
        }
        if (quantia > 0){
            jogador.getInventario().adicionarItem(new XXXX(jogador.getGeradorDeID(), quantia));
        }
    }
    */

    //OVERRIDE OBRIGATORIO DO ABSTRATO, QUANDO FOR USAR -> UTILIZAR diminuirQuantia()
    @Override
    public void usar(Personagem jogador){
        System.out.println("Usavel em outro item.");
    }

    public void feitaDe(){
        if(this.material1.getTipoDeMaterial() == this.material2.getTipoDeMaterial()){
            System.out.println("Feita de " + material1.getNome() + ".");
        }
        else{
        System.out.println("Feita de " + material1.getNome() + " e " + material2.getNome() + ".");
        }
    }
}
