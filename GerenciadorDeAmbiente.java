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
    private final Random aleatorio = new Random();
    private final List<Ambiente> historicoMovimentacao = new ArrayList<Ambiente>();
    private final GeradorDeItens geradorDeItens;

    public GerenciadorDeAmbiente(GeradorDeItens geradorDeItens) {
        this.geradorDeItens = geradorDeItens;
    }

    public Ambiente gerarAleatorio() {
        int tipo = aleatorio.nextInt(6); // 6 tipos de ambiente

        switch (tipo) {
            case 0:
                return new AmbienteFloresta(geradorDeItens);
            case 1:
                return new AmbienteMontanha(geradorDeItens);
            case 2:
                return new AmbienteDeserto(geradorDeItens);
            case 3:
                return new AmbienteRuinas(geradorDeItens);
            case 4:
                return new AmbienteCaverna(geradorDeItens);
            case 5:
                return new AmbienteLagoRio(geradorDeItens);
            default:
                throw new IllegalStateException("Tipo de ambiente nao descrito: " + tipo);
        }
    }

    public void mudarAmbiente(Personagem jogador) {
        Ambiente localizacaoAtual = jogador.getLocalizacao();
        Ambiente novaLocalizacao;

        do {
            novaLocalizacao = gerarAleatorio();
        } while (novaLocalizacao.getClass() == localizacaoAtual.getClass());

        jogador.setLocalizacao(novaLocalizacao);
        historicoMovimentacao.add(novaLocalizacao);
        System.out.println("Você se encontra em: " + novaLocalizacao.getNome());
    }

    public void exibirHistoricoDeMovimentacao() {
        System.out.println(this.historicoMovimentacao);
    }
}