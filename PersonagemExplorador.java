import java.util.concurrent.ThreadLocalRandom;

public class PersonagemExplorador extends Personagem{
    private boolean safeZone = false;

    public PersonagemExplorador(String nome, GerenciadorDeAmbiente gerenciadorDeAmbiente, GerenciadorDeEvento gerenciadorDeEvento, GeradorDeID geradorDeID){
        super(nome, 100, 75, 75, 150, 100, gerenciadorDeAmbiente, gerenciadorDeEvento, geradorDeID);
    }

    @Override
    public void usarHabilidade(){
        this.perderEnergia(30);
        System.out.println("Voce encontra um lugar tranquilo, pode relaxar !");
        /*Ambiente seguro: roletar a chance de não acontecerem eventos no prox/nesse turno*/
        this.safeZone = true;
    }

    @Override
    public boolean explorar(){
        if(this.getLocalizacao().getClass() != AmbienteCaverna.class){
            int gastoPadraoDeEnergia = 5;
            if(this.getStatus().getTemperatura() == Status.Temperatura.FRIO 
            || this.getStatus().getTemperatura() == Status.Temperatura.CALOR){
                this.perderEnergia(gastoPadraoDeEnergia + 5);
            }
            else{
                this.perderEnergia(gastoPadraoDeEnergia);
            }
            this.getRecursosProximos().clear();
            this.coletarAmbiente(ThreadLocalRandom.current().nextInt(0, 6));
            System.out.println("============================================================");
            if(this.safeZone == false){this.getGerenciadorDeEvento().gerarEvento().efeitoDoEvento(this);}
            return true;
        }
        else{
            System.out.println("Para explorar cavernas e necessario USAR algo que ilumine.");
            return false;
        }
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