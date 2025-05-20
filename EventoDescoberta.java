import java.util.Random;

public class EventoDescoberta extends Evento{
    private final String nome;
    private final String descricao;
    Random aleatorio = new Random();

    //construtor
    public EventoDescoberta(String nome, String descricao){
        super(nome, descricao);
    }

    public void descoberta(Personagem jogador){
        float chance = rand.nextInt(101);
        if(jogador.getClass() == Explorador.class){ //se for Rastreador
            if(chance <= 30){
                System.out.println("Abrigo encontrado !"); //30%
                //gerar comida e/ou criatura
            }
            else if(chance <= 80){
                System.out.println("Suprimentos encontrados."); //50%
                //gerar agua, comida, ferramentas e/ou armas
            }
            else if(chance <= 90){
                System.out.println("Fonte de água encontrada."); //10%
            }
            else{
                System.out.println("Ruínas misteriosas encontradas."); //10%
            }
        }
        else{
            if(chance <= 40){ //se não for Rastreador
                System.out.println("Abrigo encontrado !"); //40%
                //gerar comida e/ou criatura
            }
            else{
                System.out.println("Suprimentos encontrados."); //60%
                //gerar agua, comida, ferramentas e/ou armas
            }
        }
    }
}