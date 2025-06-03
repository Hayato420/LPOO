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
    private final List<Ambiente> ambientesDisponiveis;
    private final Random aleatorio = new Random();
    private final List<Ambiente> historicoMovimentacao = new ArrayList<>();
    @SuppressWarnings("unused")
    private final GeradorDeItens geradorDeItens;

    //construtor do gerenciador
    public GerenciadorDeAmbiente(GeradorDeItens geradorDeItens){
        this.geradorDeItens = geradorDeItens;
        this.ambientesDisponiveis = Arrays.asList(
            new AmbienteFloresta(geradorDeItens),
            new AmbienteMontanha(geradorDeItens),
            new AmbienteDeserto(geradorDeItens),
            new AmbienteRuinas(geradorDeItens),
            new AmbienteCaverna(geradorDeItens),
            new AmbienteLagoRio(geradorDeItens)
        );

    }

    public List<Ambiente> getAmbientesDisponiveis() {
        return ambientesDisponiveis;
    }
    
    public Ambiente gerarAleatorio(){
        Ambiente novaLocalizacao = ambientesDisponiveis.get(aleatorio.nextInt(ambientesDisponiveis.size()));
        return novaLocalizacao;
    }
    
    public void mudarAmbiente(Personagem jogador) {
        Ambiente localizacaoAtual = jogador.getLocalizacao();
        Ambiente novaLocalizacao;

        do {
            novaLocalizacao = gerarAleatorio();
        } while (novaLocalizacao.getClass() == localizacaoAtual.getClass()); //o ambiente nunca mudara para o mesmo

        jogador.setLocalizacao(novaLocalizacao);
        historicoMovimentacao.add(novaLocalizacao);
        System.out.println("Voce se encontra em: " + novaLocalizacao.getNome());
        System.out.println(novaLocalizacao.getDescricao());
    }

    public void gerarEvento(Ambiente local){

    }

    public void modificarRecursos(Ambiente local){

    }

    public void exibirHistoricoDeMovimentacao(){
        System.out.println(this.historicoMovimentacao);
    }
}