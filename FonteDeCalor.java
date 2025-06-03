public abstract class FonteDeCalor{
    private final Personagem jogador;
    private final GeradorDeID geradorDeID;

    public FonteDeCalor(Personagem jogador){
        this.jogador = jogador;
        this.geradorDeID = jogador.getGeradorDeID();
    }

    public Personagem getJogador(){
        return this.jogador;
    }

    //USADO A CADA TURNO E NA CRIAÇÃO, PARA MANTER O FOGO ACESO
    public void alimentarFogo() throws ExcecaoSemMadeira{
        for (Item item : this.getJogador().getInventario().getItens()){
                if ("Madeira".equals(item.getNome())){
                    this.getJogador().getInventario().removerItem(item.getID());
                    this.getJogador().setFonteDeCalor(this);
                    return;
                }
        }
        throw new ExcecaoSemMadeira("Nenhuma madeira encontrada no inventario.");
    }

    //COZINHAR COMIDAS
    public Alimento cozinharComida(String IDcomida){
        for(Item item : this.getJogador().getInventario().getItens()){
            if(item.getID().equals(IDcomida) && item.getClass() == Alimento.class){
                Alimento comida = (Alimento) item;
                    Alimento.TipoAlimento tipo = comida.getTipoAlimento();

                switch (tipo) {
                    case CARNEIROCRU:
                        this.getJogador().getInventario().removerItem(comida.getID());
                        return Alimento.TipoAlimento.CARNEIROASSADO.criarAlimento(geradorDeID);
                    case FRANGOCRU:
                        this.getJogador().getInventario().removerItem(comida.getID());
                        return Alimento.TipoAlimento.FRANGOASSADO.criarAlimento(geradorDeID);
                    case COELHOCRU:
                        this.getJogador().getInventario().removerItem(comida.getID());
                        return Alimento.TipoAlimento.COELHOASSADO.criarAlimento(geradorDeID);
                    default:
                        System.out.println("Isso nao e cozinhavel.");
                        return null;
                }
            }
        }
        System.out.println("Nao foi encontrada comida de ID \"" + IDcomida + "\".");
        return null;
    }

    public void ferverAgua(String IDagua){
        for(Item item : this.getJogador().getInventario().getItens()){
            if(item.getID().equals(IDagua) && item.getClass() == Agua.class){
                Agua agua = (Agua) item;
                if(!agua.getPureza()){
                    agua.purificar();
                    System.out.println("Agua purificada.");
                }
                else{
                    System.out.println("Esta agua ja esta pura.");
                }
                return;
            }
        }
        System.out.println("Nao foi encontrada agua de ID \"" + IDagua + "\".");
    }
}