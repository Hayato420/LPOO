import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorDeAmbiente{
/*
        private Lista de ambientes disponíveis: Define as áreas do jogo.
        private Clima global: Pode influenciar vários ambientes ao mesmo tempo.
        private Histórico de movimentação: Registra onde o jogador já esteve.
*/
    private List<Ambiente> ambientesDisponiveis;
    private Random aleatorio = new Random();
    private List<Ambiente> historicoMovimentacao = new ArrayList<>();

    //construtor do gerenciador
    public GerenciadorDeAmbiente() {
        this.ambientesDisponiveis = Arrays.asList(
            new AmbienteFloresta(),
            new AmbienteMontanha()
            /*,new AmbienteDeserto(),
            new AmbienteRuinas(),
            new AmbienteCaverna(),
            new AmbienteLagoRio()*/
        );

    }

    public List<Ambiente> getAmbientesDisponiveis() {
        return ambientesDisponiveis;
    }
    
    public void mudarAmbiente(Personagem jogador) {
        Ambiente localizacaoAtual = jogador.getLocalizacao();
        Ambiente novaLocalizacao;

        do {
            novaLocalizacao = ambientesDisponiveis.get(aleatorio.nextInt(ambientesDisponiveis.size()));
        } while (novaLocalizacao.getClass() == localizacaoAtual.getClass()); //o ambiente nunca mudara para o mesmo

        jogador.setLocalizacao(novaLocalizacao);
        historicoMovimentacao.add(novaLocalizacao);
        System.out.println("Voce se encontra em: " + novaLocalizacao.getNome());
    }

    public void gerarEvento(Ambiente local){

    }

    public void modificarRecursos(Ambiente local){

    }

}
