import java.util.Random;

public class EventoExploracao extends Evento{
    Random aleatorio = new Random();
    //construtor
    public EventoExploracao(){
        super("nome", "descricao");
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        int chance = aleatorio.nextInt(101);
        if(jogador.getClass() == PersonagemExplorador.class){ //se for Rastreador
            if(chance <= 30){
                System.out.println("Abrigo encontrado!"); //30%
                //gerar comida e/ou criatura
            }
            else if(chance <= 80){
                System.out.println("Suprimentos encontrados."); //50%
                //gerar agua, comida, ferramentas e/ou armas
            }
            else if(chance <= 90){
                System.out.println("Fonte de agua encontrada."); //10%
            }
            else{
                System.out.println("Ruinas misteriosas encontradas."); //10%
            }
        }
        else{                   //se nao for rastreador
            if(chance <= 40){
                System.out.println("Abrigo encontrado!"); //40%
                //gerar comida e/ou criatura
            }
            else{
                System.out.println("Suprimentos encontrados."); //60%
                //gerar agua, comida, ferramentas e/ou armas
            }
        }
    }

}