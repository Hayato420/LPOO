import java.util.Scanner;

public class Inicio{
    private final Scanner scanner;
    private final GerenciadorDeAmbiente gerenciadorAmbiente;
    private final GerenciadorDeEvento gerenciadorDeEvento;
    private final GeradorDeID geradorID;
    public Inicio(Scanner scanner, GerenciadorDeAmbiente gerenciadorAmbiente, GerenciadorDeEvento gerenciadorEvento, GeradorDeID geradorID){
        this.scanner = scanner;
        this.gerenciadorAmbiente = gerenciadorAmbiente;
        this.gerenciadorDeEvento = gerenciadorEvento;
        this.geradorID = geradorID;
    }

    public Personagem criarPersonagem(){
        boolean escolheu = false;
        while(escolheu == false){
            System.out.println("Escolha uma classe: ");
            System.out.println("Explorador --- Pode encontrar lugares seguros." );
            System.out.println("Medico --- Especialista em primeiros socorros.");
            System.out.println("Sobrevivente --- Sabe preservar seus mantimentos bem.");
            String opcao = scanner.nextLine();
            System.out.print("Insira o nome do Personagem: ");
            String nome = scanner.nextLine();
            System.out.println("");
            switch (opcao.toLowerCase()){
                case "explorador":
                    escolheu = true;
                    System.out.println("========================");
                    return new PersonagemExplorador(nome, this.gerenciadorAmbiente, this.gerenciadorDeEvento, this.geradorID);
                case "medico":
                    escolheu = true;
                    System.out.println("========================");
                    return new PersonagemMedico(nome, this.gerenciadorAmbiente, this.gerenciadorDeEvento, this.geradorID);

                case "sobrevivente":
                    escolheu = true;
                    System.out.println("========================");
                    return new PersonagemSobrevivente(nome, this.gerenciadorAmbiente, this.gerenciadorDeEvento, this.geradorID);

                default:
                    System.out.println("Insira uma opcao valida.");
                    System.out.println("========================");
                    break;
                }
        }
        return null; //apenas pro compilador entender, nunca sera alcançado
    }
}