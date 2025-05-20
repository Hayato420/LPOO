import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorDeEvento{

    private final List<Evento> eventosDisponiveis;
    private final Random aleatorio = new Random();      //estou deixando esse aviso pra me lembrar de terminar o codigo

    //construtor do gerenciador

    public GerenciadorDeEvento(){
        this.eventosDisponiveis = Arrays.asList(
            new EventoVazio(),
            new EventoClimatico(),
            new EventoExploracao(),
            new EventoCombate(),
            new EventoDoente()
        );
    }

    public List<Evento> getEventosDisponiveis(){
        return this.eventosDisponiveis;
    }

    public Evento gerarEvento(){
        Evento novoEvento;
        float chance = aleatorio.nextFloat(100);
        if (chance <= 15){
            novoEvento = eventosDisponiveis.get(3);
        } else if (chance <= 35){
            novoEvento = eventosDisponiveis.get(2);
        } else if (chance <= 50){
            novoEvento = eventosDisponiveis.get(1);
        } else if (chance <= 60){
            novoEvento = eventosDisponiveis.get(4);
        } else {
            novoEvento = eventosDisponiveis.get(0);
        }
        return novoEvento;
    }

}