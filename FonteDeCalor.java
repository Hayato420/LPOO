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
        for (Item item : this.jogador.getInventario().getItens()){
                if ("Madeira".equals(item.getNome())){
                    this.jogador.getInventario().removerItem(item.getID());
                    this.jogador.setFonteDeCalor(this);
                    return;
                }
        }
        throw new ExcecaoSemMadeira("Nenhuma madeira encontrada no inventario.");
    }

    //COZINHAR COMIDAS
    public Alimento cozinharComida(Alimento comida){
        if(comida.getTipoAlimento() == Alimento.TipoAlimento.CARNEIROCRU){
            this.jogador.getInventario().removerItem(comida.getID());
            return Alimento.TipoAlimento.CARNEIROASSADO.criarAlimento(this.geradorDeID);
        }
        else if(comida.getTipoAlimento() == Alimento.TipoAlimento.FRANGOCRU){
            this.jogador.getInventario().removerItem(comida.getID());
            return Alimento.TipoAlimento.FRANGOASSADO.criarAlimento(this.geradorDeID);
        }
        else if(comida.getTipoAlimento() == Alimento.TipoAlimento.COELHOCRU){
            this.jogador.getInventario().removerItem(comida.getID());
            return Alimento.TipoAlimento.COELHOASSADO.criarAlimento(this.geradorDeID);
        }
        else{
            System.out.println("Isso nao e cozinhavel.");
            return null;
        }
    }
}