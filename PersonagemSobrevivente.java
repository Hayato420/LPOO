public class PersonagemSobrevivente extends Personagem{
    
    public PersonagemSobrevivente(String nome){
        super(nome, 80, 120, 100, 100, 100);
    }

    @Override
    public void usarHabilidade(){
        /*Mantimentos: recuperar a "durabilidade" dos alimentos*/
        boolean x = false;
        for(Item item : this.getInventario().getItens()){
            if(item instanceof Alimento){
                ((Alimento) item).aumentarValidade(5);
                x = true;
            }
        }
        if(x == true){
            perderEnergia(20);
        }
        
    }

    @Override
    public void adicionarVida(int quantidade){
        this.setVida(this.getVida() + quantidade);
        if(this.getVida() > 80){
            this.setVida(80);
        }
    }

    @Override
    public void adicionarFome(int quantidade){
        this.setFome(this.getFome() + quantidade);
        if(this.getFome() > 120){
            this.setFome(120);
        }
    }

}