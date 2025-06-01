public class ZonaDeTestes{
    public static void main(String[] args) {
        Personagem jorge = new PersonagemTeste();
        int rodada = 0;
        //GerenciadorDeTurno turno = new GerenciadorDeTurno(jorge);     //<-- Funcionando
        GerenciadorDeCombate combatente = new GerenciadorDeCombate();
        combatente.setPersonagem(jorge);
        //GerenciadorDeEvento evento = new GerenciadorDeEvento();       //<-- Funcionando
        do {
            /**teste: simulando um ataque contra "inimigo de teste" */
            if(rodada == 2){        //garante um combate no turno 2
                jorge.setEmCombate(true);
            }
            
            
            
            if(jorge.getEmCombate() == true){   //check de combate
                combatente.inimigoSeAproxima();
                combatente.horaDoDuelo();
            }
            

            if(rodada>=5){
                jorge.setCondicaoVitoria(true);
                System.out.println("Algo aconteceu...");
            }

            
            rodada += 1;
        } while (jorge.getCondicaoVitoria() == false && jorge.getCondicaoDerrota() == false);   //esse loop garante que o jogo vai rodar até a vitoria/derrota for alcançada
        if(jorge.getCondicaoVitoria() == true){
            System.out.println("Parabens, voce ganhou!!!");
        }
    }
}