import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorDeEvento{

    private final List<Evento> eventosDisponiveis;
    private final Random aleatorio = new Random();      //estou deixando esse aviso pra me lembrar de terminar o codigo
    private final GeradorDeItens geradorDeItens;
    //construtor do gerenciador

    public GerenciadorDeEvento(GeradorDeItens geradorDeItens){
        this.geradorDeItens = geradorDeItens;
        this.eventosDisponiveis = Arrays.asList(
            new EventoClimatico(),
            new EventoCombate(),
            new EventoDoente(),
            new EventoExploracao(geradorDeItens),
            new EventoVazio()
        );
    }

    public List<Evento> getEventosDisponiveis(){
        return this.eventosDisponiveis;
    }

    public GeradorDeItens getGeradorDeItens(){
        return this.geradorDeItens;
    }

    public Evento gerarEvento(){
        Evento novoEvento;
        float chance = aleatorio.nextFloat() * 100;
        if (chance <= 15){ //15%
            novoEvento = eventosDisponiveis.get(0); //climatico
        } else if (chance <= 20){ //5%
            novoEvento = eventosDisponiveis.get(1); //combate
        } else if (chance <= 30){ //10%
            novoEvento = eventosDisponiveis.get(2); //doente
        } else if (chance <= 65){ //35%
            novoEvento = eventosDisponiveis.get(3); //exploracao
        } else { //35%
            novoEvento = eventosDisponiveis.get(4); //vazio
        }
        return novoEvento;
    }
}