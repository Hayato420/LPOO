import java.util.Scanner;

public class Teste{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GeradorDeID gerador = new GeradorDeID();
        GeradorDeItens geradorItens = new GeradorDeItens(gerador);
        GerenciadorDeAmbiente gerenciador = new GerenciadorDeAmbiente(geradorItens);

        ChecagemFimDeTurno checador = new ChecagemFimDeTurno();

        PersonagemExplorador jogador = new PersonagemExplorador("Adeildo L Durval", gerenciador, gerador);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== Estado Atual ===");
            jogador.exibirAtrStat();
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Explorar");
            System.out.println("2. Coletar recurso proximo");
            System.out.println("3. Cozinhar");
            System.out.println("4. Usar item");
            System.out.println("5. Dormir");
            System.out.println("6. Mudar de ambiente");
            System.out.println("7. Ver inventario");
            System.out.println("8. Criar fogueira.");
            System.out.println("9. Apagar fogueira.");
            System.out.println("10. Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("============================================================");
                    jogador.explorar();
                    System.out.println("============================================================");
                    if(!checador.checar(jogador)){rodando = false;}
                    break;

                case "2":
                    System.out.println("============================================================");
                    jogador.exibirRecursosProximos();
                    System.out.print("Digite o ID do recurso que deseja coletar: ");
                    String idRecurso = scanner.nextLine();
                    jogador.coletarProximos(idRecurso);
                    System.out.println("============================================================");
                    break;

                case "3":
                    System.out.println("============================================================");
                    if (jogador.getFonteDeCalor() != null) {
                        jogador.exibirItens();
                        System.out.print("Digite o ID da comida a cozinhar: ");
                        String idComida = scanner.nextLine();
                        jogador.cozinhar(idComida);
                    } else {
                        System.out.println("Voce precisa de uma fonte de calor para cozinhar.");
                    }
                    System.out.println("============================================================");
                    break;

                case "4":
                    System.out.println("============================================================");
                    jogador.exibirItens();
                    System.out.print("Digite o ID do item a usar: ");
                    String idItem = scanner.nextLine();
                    jogador.usarItem(idItem);
                    System.out.println("============================================================");
                    break;

                case "5":
                    System.out.println("============================================================");
                    jogador.dormir();
                    System.out.println("Voce dormiu e recuperou energia e sanidade.");
                    System.out.println("============================================================");
                    break;

                case "6":
                    System.out.println("============================================================");
                    jogador.mudarAmbiente(gerenciador);
                    System.out.println("Voce mudou de ambiente.");
                    System.out.println("============================================================");
                    if(!checador.checar(jogador)){rodando = false;}
                    break;

                case "7":
                    System.out.println("============================================================");
                    jogador.exibirItens();
                    System.out.println("============================================================");
                    break;
                case "8":
                    System.out.println("============================================================");
                    jogador.criarFogueira();
                    System.out.println("============================================================");
                    break;
                case "9":
                    System.out.println("============================================================");
                    jogador.apagarFogueira();
                    System.out.println("============================================================");
                    break;
                case "10":
                    System.out.println("============================================================");
                    System.out.println("Saindo do jogo.");
                    rodando = false;
                    System.out.println("============================================================");
                    break;

                default:
                    System.out.println("============================================================");
                    System.out.println("Opcao invalida. Tente novamente.");
                    System.out.println("============================================================");
            }
        }
        scanner.close();
    }
}