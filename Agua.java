public class Agua extends Item{
    private boolean pureza;
    private int volume;

    public Agua(String nome, String descricao, int peso, boolean pureza, int volume){
        super(nome, descricao, peso, 1);
        this.pureza = pureza;
        this.volume = volume;
    }

    public void diminuirVolume(Inventario inventario){
        this.volume -= 1;
        if(this.volume <= 0){
            inventario.removerItem(this.getID());
        }
    }
    
    public void beber(Personagem jogador, Inventario inventario){
        jogador.adicionarSede(10);
        this.diminuirVolume(inventario);
    }

    public boolean getPureza(){
        return this.pureza;
    }

    public void purificar(){
        if(this.pureza == false){
            this.pureza = true;
        }
    }
}
