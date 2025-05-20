import java.util.Scanner;

public class PersonagemTeste extends Personagem{

    private final Scanner scanner = new Scanner(System.in);

    public PersonagemTeste(){
        super("jorge", 100, 100, 100, 100, 100);
    }

    @Override
    public void usarHabilidade(){
        String entrada;
        System.out.printf("Escolha o atributo: (vida, sede, fome, energia, sanidade,\ncond. de vitoria, cond. de derrota)\n");
        entrada = scanner.next();
        System.out.print("Insira para qual valor o atributo sera alterado: (palavras, numeros ou 1 e 0 para true e false)");
        switch(entrada){
            case "vida":
                setVida(scanner.nextInt());
                break;
            case "sede":
                setSede(scanner.nextInt());
                break;
            case "fome":
                setFome(scanner.nextInt());
                break;
            case "energia":
                setEnergia(scanner.nextInt());
                break;
            case "sanidade":
                setSanidade(scanner.nextInt());
                break;
            case "vitoria":
            switch (scanner.nextInt()) {
                case 1:
                    setCondicaoVitoria(true);
                    break;
                case 0:
                    setCondicaoVitoria(false);
                    break;
                default:
                    System.out.println("Erro, valor fora do esperado. Tente novamente");
                    break;
            }
                break;

            case "derrota":
            switch (scanner.nextInt()) {
                case 1:
                    setCondicaoDerrota(true);
                    break;
                case 0:
                    setCondicaoDerrota(false);
                    break;
                default:
                    System.out.println("Erro, valor fora do esperado. Tente novamente");
                    break;
            }
                break;
            default:
                System.out.println("Erro, valor fora do esperado. Tente novamente");
                break;
        }

    }

}