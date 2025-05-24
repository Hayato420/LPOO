import java.util.Random;

public class EventoDoente extends Evento{
    Random aleatorio = new Random();

    public EventoDoente(){
        super("nome", "descricao");
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        int chance = aleatorio.nextInt(101);
        if(jogador.getLocalizacao().getClima() == Ambiente.Clima.SECO || jogador.getLocalizacao().getTemperatura() == Ambiente.Temperatura.QUENTE){
            if(chance <= 10){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //10%
                jogador.getStatus().setDoente(true);
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 20){
                System.out.println("Voce adoeceu e está com febre."); //10%
                jogador.getStatus().setDoente(true);
                jogador.getStatus().setPerturbado(true);
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 30){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //10%
                jogador.perderVida(20);
                jogador.getStatus().setFraturado(true);
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
            else{
                System.out.println("Voce esta desidratado, procure agua."); //70%
                jogador.perderSede(30);
                jogador.getStatus().setTemperatura(Status.Temperatura.CALOR);
                //reducao drastica de sede e custa mais energia para se mover se nao beber agua
            }
        }
        else if(jogador.getLocalizacao().getClima() == Ambiente.Clima.UMIDO ||jogador.getLocalizacao().getTemperatura() == Ambiente.Temperatura.FRIO){
            if(chance <= 10){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //10%
                jogador.getStatus().setDoente(true);
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 20){
                System.out.println("Voce adoeceu e está com febre."); //10%
                jogador.getStatus().setDoente(true);
                jogador.getStatus().setPerturbado(true);
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 30){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //10%
                jogador.perderVida(20);
                jogador.getStatus().setFraturado(true);
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
            else if(chance <= 100){
                System.out.println("Voce esta com hipotermia, procure se aquecer."); //70
                jogador.getStatus().setPerturbado(true);
                jogador.getStatus().setTemperatura(Status.Temperatura.FRIO);
                //reducao continua de sanidade e reducao drastica de vida se nao esquentar-se
            }
        }
        else{
            if(chance <= 33){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //33%
                jogador.getStatus().setDoente(true);
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 66){
                System.out.println("Voce adoeceu e está com febre."); //33%
                jogador.getStatus().setDoente(true);
                jogador.getStatus().setPerturbado(true);
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 100){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //34%
                jogador.perderVida(20);
                jogador.getStatus().setFraturado(true);
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
        }
    }
}