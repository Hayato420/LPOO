public class GerenciadorDeTurno{
//O gerenciador de turno carrega as funções que regulam a ordem de acontecimentos do turno

private final Personagem personagem;

//construtor
public GerenciadorDeTurno(Personagem personagem){
    this.personagem = personagem;
}

//Passo 1: Apresentação de informações
public void apresentacaoDeInfo(){
    System.out.println("Nome: "+personagem.getNome());
    System.out.println("Vida: "+personagem.getVida());
    System.out.println("Fome: "+personagem.getFome());
    System.out.println("teste do passo 1");
}

//Passo 2: Decisão do jogador
public void oQueFazer(){        //por um problema no vscode, eu não consigo implementar isso ainda, mas posso testar se funcionaria
    System.out.println("teste do passo 2");
}

//Passo 3: Geração de um evento aleatório -> será realizado pelo GerenciadorDeEvento

//Passo 4: Aplicação dos acontecimentos -> será realizado pelo GerenciadorDeEvento/GerenciadorDeCombate/outras situações

//Os métodos dos gerenicadores serão colocados em um loop que vai checar as "bandeiras" de condição de Combate, Vitoria e Derrota em Personagem, mantendo o loop se "Vitoria" e "Derrota" forem false.

}