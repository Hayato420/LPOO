public class Agua extends Item{
    private boolean pureza;
    private int volume;

    public Agua(GeradorDeID geradorDeID, boolean pureza, int volume){
        super("Agua", "Molhada", 1, 1, geradorDeID);
        this.pureza = pureza;
        this.volume = volume;
    }

    public void diminuirVolume(Inventario inventario){
        this.volume -= 1;
        if(this.volume <= 0){
            inventario.removerItem(this.getID());
        }
    }
    
    public void usar(Personagem jogador){
        jogador.adicionarSede(10);
        this.diminuirVolume(jogador.getInventario());
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
