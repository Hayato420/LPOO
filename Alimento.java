public class Alimento extends Item{
    private final String tipoAlimento;
    private int prazoDeValidade;
    private boolean apodrecido;
    private final int valorNutricional;

    public Alimento(String nome, String descricao, String tipoAlimento, int peso, int prazoDeValidade, int valorNutricional){
        super(nome, descricao, peso, 1);
        this.tipoAlimento = tipoAlimento;
        this.prazoDeValidade = prazoDeValidade;
        this.apodrecido = false;
        this.valorNutricional = valorNutricional;
    }

    public String getTipoAlimento(){
        return this.tipoAlimento;
    }

    public void usar(Personagem jogador, Inventario inventario){
        if(this.apodrecido == false){
            jogador.adicionarFome(this.valorNutricional);
            inventario.removerItem(this.getID());
        }
        else{
            jogador.adicionarFome(this.valorNutricional/2);
            jogador.perderVida(15);
            inventario.removerItem(this.getID());
        }
    }
    
    public void apodrecer(){
        this.prazoDeValidade -=1;
        if(this.prazoDeValidade <= 0){
            this.apodrecido = true;
            System.out.printf("O alimento %s apodreceu.\n", this.getNome());
        }
    }
    
}
