import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorDeAmbiente(){
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
            new AmbienteMontanha(),
            new AmbienteDeserto()
        );
    }

    public void mudarAmbiente(Personagem jogador) {
        Ambiente ambienteAtual = jogador.getAmbienteAtual();
        Ambiente novoAmbiente;
    
       do {
            novoAmbiente = ambientesDisponiveis.get(random.nextInt(ambientesDisponiveis.size()));
        } while (novoAmbiente == ambienteAtual); //o ambiente nunca mudará para o mesmo
    
        jogador.setAmbienteAtual(novoAmbiente);
        historicoMovimentacao.add(novoAmbiente);
        System.out.println("Você agora está em: " + novoAmbiente.getNome());
    }

    public void gerarEvento(Ambiente local){

    }

    public void modificarRecursos(Ambiente local){

    }

}