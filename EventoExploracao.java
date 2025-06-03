import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventoExploracao extends Evento{
    Random aleatorio = new Random();
    private final GeradorDeItens geradorDeItens;
    //construtor
    public EventoExploracao(GeradorDeItens geradorDeItens){
        super("Evento Exploracao", "Algo foi encontrado, mas o que?");
        this.geradorDeItens = geradorDeItens;
    }

    @Override
    public void efeitoDoEvento(Personagem jogador){
        int chance = aleatorio.nextInt(101);
        if(jogador.getClass() == PersonagemExplorador.class){ //se for Rastreador
            if(chance <= 20){
                System.out.println("Abrigo encontrado !"); //20%
                int quantidadeAlimentos = ThreadLocalRandom.current().nextInt(1, 4); 
                for (int i = 0; i <= quantidadeAlimentos; i++){
                    jogador.getRecursosProximos().add(this.geradorDeItens.gerarAlimento());
                }
                jogador.exibirRecursosProximos();
                //talvez gerar criatura
            }
            else if(chance <= 50){
                jogador.getStatus().setPertoDeFonteDeAgua(true);
                System.out.println("Fonte de agua encontrada."); //30%
            }
            else if(chance <= 90){
                System.out.println("Ruínas misteriosas encontradas."); //40%
                jogador.setLocalizacao(new AmbienteRuinas(this.geradorDeItens));//vai por o personagem em um novo objeto de AmbienteRuinas
                jogador.getRecursosProximos().addAll(ruinasLoots());
                //ITEM RARO
            }
            else if(chance <= 95){
                System.out.println("Voce encontrou um refugio seguro, que sorte !");
                jogador.setCondicaoVitoria(true);
            }
            else{
                System.out.println("Voce encontrou modo de pedir resgate, mas ainda devera sobreviver mais um pouco enquanto espera.");
                jogador.setEmResgate(5);
            }
        }
        else{ //se não for Rastreador
            if(chance <= 40){ //se não for Rastreador
                System.out.println("Abrigo encontrado !"); //40%
                int quantidadeAlimentos = ThreadLocalRandom.current().nextInt(1, 4); 
                for (int i = 0; i <= quantidadeAlimentos; i++){
                    jogador.getRecursosProximos().add(this.geradorDeItens.gerarAlimento());
                }
                jogador.exibirRecursosProximos();
                //talvez gerar criatura
            }
            else if(chance <= 90){
                jogador.getStatus().setPertoDeFonteDeAgua(true);
                System.out.println("Fonte de agua encontrada."); //70%
            }
            else if(chance <= 95){
                System.out.println("Voce encontrou um refugio seguro, que sorte !");
                jogador.setCondicaoVitoria(true);
            }
            else{
                System.out.println("Voce encontrou modo de pedir resgate, mas ainda devera sobreviver mais um pouco enquanto espera.");
                jogador.setEmResgate(5);
            }
        }
    }

    public List<Item> ruinasLoots(){
        List<Item> loots = new ArrayList<>();
        int chance = ThreadLocalRandom.current().nextInt(1,4);
        Material metalInox1 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.getGeradorDeID());
        Material metalInox2 = Material.TipoDeMaterial.METALINOX.criarMaterial(this.getGeradorDeID());

        switch (chance){
            case 1:
                loots.add(new Isqueiro(metalInox1, metalInox2, this.getGeradorDeID()));
                break;
            case 2:
                loots.add(new Lanterna(metalInox1, metalInox2, this.getGeradorDeID()));
                break;
            default:
                loots.add(new Pistola(Arma.TipoArma.aDistancia, Arma.QualArma.PISTOLA, 
                            3, metalInox1, metalInox2, this.getGeradorDeID()));
                break;
        }

        List<String> municoesParaLoot = Arrays.asList("balas", "flechas", "fluido de isqueiro", "pilhas");
        String municaoSorteada = municoesParaLoot.get(ThreadLocalRandom.current().nextInt(municoesParaLoot.size()));
        loots.add(this.geradorDeItens.gerarMunicaoAleat(municaoSorteada));
        return loots;
    }
}