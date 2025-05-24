import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventoExploracao extends Evento{
    Random aleatorio = new Random();
    //construtor
    public EventoExploracao(){
        super("nome", "descricao");
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        int chance = rand.nextInt(101);
        if(jogador.getClass() == Explorador.class){ //se for Rastreador
            if(chance <= 30){
                System.out.println("Abrigo encontrado !"); //30%
                int quantidadeAlimentos = ThreadLocalRandom.current().nextInt(1, 4); 
                for (int i = 0; i <= quantidadeAlimentos; i++){
                    jogador.getInventario().adicionarItem(this.geradorDeItens.gerarAlimento());
                }
                //talvez gerar criatura
            }
            else if(chance <= 90){
                jogador.getStatus().setPertoDeFonteDeAgua(true);
                System.out.println("Fonte de água encontrada."); //60%
            }
            else{
                System.out.println("Ruínas misteriosas encontradas."); //10%
                //ADICIONAR ITENS RAROS
            }
        }
        else{ //se não for Rastreador
            if(chance <= 30){ //se não for Rastreador
                System.out.println("Abrigo encontrado !"); //40%
                int quantidadeAlimentos = ThreadLocalRandom.current().nextInt(1, 4); 
                for (int i = 0; i <= quantidadeAlimentos; i++){
                    jogador.getInventario().adicionarItem(this.geradorDeItens.gerarAlimento());
                }
                //talvez gerar criatura
            }
            else{
                jogador.getStatus().setPertoDeFonteDeAgua(true);
                System.out.println("Fonte de água encontrada."); //70%
            }
        }
    }
}