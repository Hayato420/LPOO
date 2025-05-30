public class PersonagemExplorador extends Personagem{

    public PersonagemExplorador(String nome, GerenciadorDeAmbiente gerenciadorDeAmbiente){
        super(nome, 100, 75, 75, 150, 100, gerenciadorDeAmbiente);
    }

    @Override
    public void usarHabilidade(){
        /*Ambiente seguro: roletar a chance de não acontecerem eventos no prox/nesse turno*/
    }
    
    @Override
    public void adicionarFome(int quantidade){
        this.setFome(this.getFome() + quantidade);
        if(this.getFome() > 75){
            this.setFome(75);
        }
    }

    @Override
    public void adicionarSede(int quantidade){
        this.setSede(this.getSede() + quantidade);
        if(this.getSede() > 75){
            this.setSede(75);
        }
    }

    @Override
    public void adicionarEnergia(int quantidade){
        this.setEnergia(this.getEnergia() + quantidade);
        if(this.getEnergia() > 150){
            this.setEnergia(150);
        }
    }

}