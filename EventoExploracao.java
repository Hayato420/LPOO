import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class EventoExploracao extends Evento{
    Random aleatorio = new Random();
    private final GeradorDeItens geradorDeItens;
    //construtor
    public EventoExploracao(GeradorDeItens geradorDeItens){
        super("nome", "descricao");
        this.geradorDeItens = geradorDeItens;
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        int chance = aleatorio.nextInt(101);
        if(jogador.getClass() == PersonagemExplorador.class){ //se for Rastreador
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
                jogador.setLocalizacao(new AmbienteRuinas(this.geradorDeItens));//vai por o personagem em um novo objeto de AmbienteRuinas
                jogador.getRecursosProximos().addAll(ruinasLoots());
                //ITEM RARO
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

    public List<Item> ruinasLoots(){
        List<Item> loots = new ArrayList<>();
        int chance = ThreadLocalRandom.current().nextInt(1,4);

        switch (chance){
            case 1:
                loots.add(this.geradorDeItens.gerarIsqueiro());
                break;
            case 2:
                loots.add(this.geradorDeItens.gerarLanterna());
                break;
            default:
                loots.add(this.geradorDeItens.gerarPistola());
                break;
        }

        //ADICIONAR GERACAO DE MUNICAO
        return loots;
    }
}
