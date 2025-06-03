import java.util.Scanner;

public class Jogo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GeradorDeID geradorID = new GeradorDeID();
        GeradorDeItens geradorItens = new GeradorDeItens(geradorID);
        GerenciadorDeAmbiente gerenciadorAmbiente = new GerenciadorDeAmbiente(geradorItens);
        GerenciadorDeEvento gerenciadorEvento = new GerenciadorDeEvento(geradorItens);
        Personagem jogador;
        Inicio inicio = new Inicio(scanner, gerenciadorAmbiente, gerenciadorEvento, geradorID);
        Checagem checador = new Checagem();

        final int TURNO_MAX = 100;
        int turnoAtual = TURNO_MAX;

        jogador = inicio.criarPersonagem();
        GerenciadorDeCombate gerenciadorDeCombate = new GerenciadorDeCombate(jogador);

        while (turnoAtual != -1 && jogador.getCondicaoDerrota() == false && jogador.getCondicaoVitoria() == false){
            if(jogador.getEmCombate() == true){
                gerenciadorDeCombate.iniciarCombate();
            }
            turnoAtual --;
            if(turnoAtual == -1){
                System.out.println("Parabens ! Voce sobreviveu por " + TURNO_MAX + " turnos.");
                System.out.println("Obrigado por jogar !");
                System.out.println("Jogo criado por Miguel Masiero e Matheus Jose.");
                scanner.close();
                break;
            }
        checador.checar(jogador);

            System.out.println("\n=== Estado Atual ===");
            jogador.exibirAtrStat();
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Explorar");
            System.out.println("2 - Explorar com Lanterna/Isqueiro");
            System.out.println("3 - Mudar de Ambiente");
            System.out.println("4 - Coletar recurso proximo");
            System.out.println("5 - Ver inventario");
            System.out.println("6 - Criar fogueira");
            System.out.println("7 - Usar fonte de calor (fogueira/forno)");
            System.out.println("8 - Apagar fogueira");
            System.out.println("9 - Usar item");
            System.out.println("10 - Dormir");
            System.out.println("11 - Fabricar...");
            System.out.println("12 - Remover item do inventario");
            System.out.println("13 - Usar habilidade do personagem");
            System.out.println("14 - Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("============================================================");
                    if(jogador.explorar()){
                        System.out.println("============================================================");
                        checador.aplicarEfeitos(jogador);
                        break;
                    }
                    else{
                        System.out.println("============================================================");
                        break;
                    }
                case "2":
                    System.out.println("============================================================");
                    System.out.print("Lanterna ou Isqueiro? ");
                    String opcaoIlum = scanner.nextLine();
                    System.out.println("");
                    System.out.print("Insira o ID: ");
                    String IDiluminacao = scanner.nextLine();
                    System.out.println("");

                    boolean itemUsado = false;

                    switch (opcaoIlum.toLowerCase()){
                        case "isqueiro":
                            for (Item item : jogador.getInventario().getItens()){
                                if(item.getID().equals(IDiluminacao)){
                                    if(item instanceof Isqueiro){
                                        if(jogador.temFluidoDeIsqueiro()){
                                            Isqueiro isqueiro = (Isqueiro) item;
                                            isqueiro.usar(jogador);
                                            itemUsado = true;
                                        }
                                        else{
                                            System.out.println("Voce nao tem fluido de isqueiro.");
                                            itemUsado = true;
                                        }
                                        break;
                                    }
                                }
                            }
                            break;

                        case "lanterna":
                            for (Item item : jogador.getInventario().getItens()){
                                if(item.getID().equals(IDiluminacao)){
                                    if(item instanceof Lanterna){
                                        if(jogador.temPilhas()){
                                            Lanterna lanterna = (Lanterna) item;
                                            lanterna.usar(jogador);
                                            itemUsado = true;
                                        }
                                        else{
                                            System.out.println("Voce nao tem pilhas.");
                                            itemUsado = true;;
                                        }
                                        break;
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("Opcao invalida.");
                            break;
                    }

                    if (!itemUsado){
                        System.out.println("Insira um ID válido.");
                        break;
                    }
                    else{
                        System.out.println("============================================================");
                        checador.aplicarEfeitos(jogador);
                    }

                case "3":
                    System.out.println("============================================================");
                    jogador.mudarAmbiente();
                    System.out.println("Voce mudou de ambiente.");
                    System.out.println("============================================================");
                    checador.aplicarEfeitos(jogador);
                    break;

                case "4":
                    System.out.println("============================================================");
                    jogador.exibirRecursosProximos();
                    System.out.print("Digite o ID do recurso que deseja coletar: ");
                    String idRecurso = scanner.nextLine();
                    jogador.coletarProximos(idRecurso);
                    System.out.println("============================================================");
                    break;

                case "5":
                    System.out.println("============================================================");
                    jogador.exibirItens();
                    System.out.println("============================================================");
                    break;

                case "6":
                    System.out.println("============================================================");
                    jogador.criarFogueira();
                    System.out.println("============================================================");
                    break;

                case "7":
                    if(jogador.getFonteDeCalor() != null){
                        System.out.println("============================================================");
                        System.out.println("Escolha um uso: Cozinhar comida/Ferver agua");
                        System.out.print("Escolha: ");
                        String uso = scanner.nextLine();
                        System.out.print("Insira o ID do item pretendido: ");
                        String IDdeUso = scanner.nextLine();
                        System.out.print("");
                        jogador.usarFogueira(uso, IDdeUso);
                        System.out.println("============================================================");
                        break;
                    }
                    else{
                        System.out.println("============================================================");
                        System.out.println("E preciso estar proximo a uma fonte de calor.");
                        System.out.println("============================================================");
                        break;
                    }
                
                case "8":
                    System.out.println("============================================================");
                    jogador.apagarFogueira();
                    System.out.println("============================================================");
                    break;

                case "9":
                    System.out.println("============================================================");
                    jogador.exibirItens();
                    System.out.println("============================================================");
                    System.out.print("Digite o ID do item a usar: ");
                    String idItem = scanner.nextLine();
                    jogador.usarItem(idItem);
                    System.out.println("============================================================");
                    break;

                case "10":
                    System.out.println("============================================================");
                    jogador.dormir();
                    System.out.println("Voce dormiu e recuperou energia e sanidade.");
                    System.out.println("============================================================");
                    checador.aplicarEfeitos(jogador);
                    break;

                case "11":
                    System.out.println("============================================================");
                    jogador.getInventario().exibirItens();
                    System.out.println("============================================================");
                    System.out.println("Selecione dois materiais, exceto fibras fracotes !");
                    System.out.print("Primeiro material: ");
                    String IDmat1 = scanner.nextLine();
                    System.out.print("Segundo material: ");
                    String IDmat2 = scanner.nextLine();
                    System.out.println("Opcoes: arco, armadilha, corda, espada, faca, flechas, lanca, machado e picareta.");
                    String opcaoDeCraft = scanner.nextLine();
                    jogador.craftar(opcaoDeCraft, IDmat1, IDmat2, geradorItens);
                    System.out.println("============================================================");
                    break;
                
                case "12":
                    System.out.println("============================================================");
                    jogador.getInventario().exibirItens();
                    System.out.print("Insira o ID do item a ser removido: ");
                    String IDremocao = scanner.nextLine();
                    System.out.println("");
                    boolean removido = false;
                        for(Item item : jogador.getInventario().getItens()){
                            if(item.getID().equals(IDremocao)){
                                jogador.getInventario().removerItem(IDremocao);
                                removido = true;
                                break;
                            }
                        }
                        if(!removido){
                            System.out.print("Item nao encontrado.");
                        }
                    System.out.println("============================================================");
                    break;

                case "13":
                    System.out.println("============================================================");
                    jogador.usarHabilidade();
                    checador.aplicarEfeitos(jogador);
                    break;

                case "14":
                    System.out.println("============================================================");
                    System.out.println("Saindo do jogo.");
                    System.out.println("============================================================");
                    turnoAtual = -1;
                    System.out.println("Obrigado por jogar !");
                    System.out.println("Jogo criado por Miguel Masiero e Matheus Jose.");
                    scanner.close();
                    break;

                default:
                    System.out.println("============================================================");
                    System.out.println("Opcao invalida. Tente novamente.");
                    System.out.println("============================================================");
            }
        }
        if(jogador.getCondicaoVitoria()){
            if(jogador.getEmResgate() <= 1){
                System.out.println("Voce foi resgatado !");
            }
        }
        System.out.println("Obrigado por jogar !");
        System.out.println("Jogo criado por Miguel Masiero e Matheus Jose.");
        scanner.close();
    }
}