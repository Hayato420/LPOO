import java.util.List;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) {

        GerenciadorDeAmbiente gerenciador = new GerenciadorDeAmbiente();
        List<Ambiente> ambientes = gerenciador.getAmbientesDisponiveis();

        Random aleatorio = new Random();
        Ambiente ambienteInicial = ambientes.get(aleatorio.nextInt(ambientes.size()));

        Personagem jogador = new Personagem("Player", ambienteInicial);

        System.out.println("Voce se encontra em: " + jogador.getLocalizacao().getNome());
        System.out.println("Descricao: " + jogador.getLocalizacao().getDescricao());
        System.out.println("Mudando de ambiente...");
        gerenciador.mudarAmbiente(jogador);
        System.out.println("Descricao: " + jogador.getLocalizacao().getDescricao());

        System.out.println("----------------");
        System.out.println("Status");
        System.out.println("----------------");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Fome: " + jogador.getFome());
        System.out.println("Sede: " + jogador.getSede());
        System.out.println("Energia: " + jogador.getEnergia());
        System.out.println("Sanidade: " + jogador.getSanidade());
    }
}