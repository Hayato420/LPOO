import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventoExploracao extends Evento{
    Random aleatorio = new Random();
    private final GeradorDeItens geradorDeItens = new GeradorDeItens();
    //construtor
    public EventoExploracao(){
        super("nome", "descricao");
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
                jogador.setLocalizacao(new AmbienteRuinas());//vai por o personagem em um novo objeto de AmbienteRuinas
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