public class Agua extends Item{
    private boolean pureza;
    private final int volumeMax;
    private int volumeAtual;

    public Agua(GeradorDeID geradorDeID, boolean pureza, int volumeMax){
        super("Garrafa", "Contem agua.", 1, 1, geradorDeID);
        this.pureza = pureza;
        this.volumeMax = volumeMax;
        this.volumeAtual = volumeMax;
    }

    public int getVolumeAtual(){
        return this.volumeAtual;
    }

    public int getVolumeMax(){
        return this.volumeMax;
    }

    public void encher(){ //enche para o volume máximo, mas será IMPURA (não vejo formas de encher se não com fontes naturais)
        this.volumeAtual = volumeMax;
        this.pureza = false;
    }

    public void diminuirVolume(Inventario inventario){
        this.volumeAtual -= 1;
        if(this.volumeAtual <= 0){
            inventario.removerItem(this.getID());
        }
    }

    public void usar(Personagem jogador){
        if(!this.pureza){jogador.getStatus().setDoente(true);} //se impura, adoecera
        if(jogador.getStatus().getTemperatura() == Status.Temperatura.CALOR){jogador.getStatus().setTemperatura(Status.Temperatura.NORMAL);}
        //ESFRIA A TEMPERATURA SE TIVER COM CALOR
        jogador.adicionarSede(10);
        this.diminuirVolume(jogador.getInventario());
    }

    public boolean getPureza(){
        return this.pureza;
    }

    public void purificar(){
        if(!this.pureza){
            this.pureza = true;
        }
        else{
            System.out.println("Já está pura.");
        }
    }
}