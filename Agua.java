public class Agua extends Item{
    private boolean pureza;
    private int volume;

    public void diminuirVolume(){
        this.volume -= 1;
        if(this.volume < 0){
            //REMOVER O ITEM DO INVENTARIO, OU DEIXAR A GARRAFA MAS VAZIA, O QUE SERIA MAIS COMPLICADO POIS TERIA QUE TER O ITEM GARRAFA E SO PODER ENCHER EM ALGUMA FONTE PROXIMA
        }
    }
    public void usar(Personagem jogador){
        jogador.adicionarSede(10);
        this.diminuirVolume();
    }
}
