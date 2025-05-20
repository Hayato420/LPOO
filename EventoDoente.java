import java.util.Random;

public class EventoDoente extends Evento{
    Random aleatorio = new Random();

    public EventoDoente(){
        super("nome", "descricao");
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        float chance = aleatorio.nextInt(101);
        if(jogador.getLocalizacao().getClima() == Ambiente.Clima.SECO || jogador.getLocalizacao().getTemperatura() == Ambiente.Temperatura.QUENTE){
            if(chance <= 10){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //10%
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 20){
                System.out.println("Voce adoeceu e está com febre, "); //10%
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 30){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //10%
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
            else{
                System.out.println("Voce esta desidratado, procure agua."); //70%
                //reducao drastica de sede e custa mais energia para se mover se nao beber agua
            }
        }
        else if(jogador.getLocalizacao().getTemperatura() == Ambiente.Temperatura.FRIO){
            if(chance <= 10){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //10%
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 20){
                System.out.println("Voce adoeceu e está com febre, "); //10%
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 30){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //10%
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
            else if(chance <= 100){
                System.out.println("Voce com hipotermia, procure agua."); //70
                //reducao continua de sanidade e vida
            }
        }
        else{
            if(chance <= 33){
                System.out.println("Voce pegou uma infecçao em um corte qualquer. O pus fede."); //33%
                //reducao drastica de atributos se nao tratada
            }
            else if(chance <= 66){
                System.out.println("Voce adoeceu e está com febre, "); //33%
                //alucinacao e vida se nao tratada
            }
            else if(chance <= 100){
                System.out.println("Voce fraturou um osso apos uma queda acidental."); //34%
                //vida instantaneamente reduzida e custa mais energia para se mover se nao tratado
            }
        }
    }
}