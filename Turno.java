/* SERA IMPLEMENTADO PERTO DO FINAL, QUANDO AS CLASSES E METODOS ESTIVEREM BEM DEFINIDOS
import java.util.List;

public class Turno {
    private Personagem personagem;
    private Ambiente ambiente;
    private List<Evento> eventos; // Eventos aleatórios e programados

    public Turno(Personagem personagem, Ambiente ambiente, List<Evento> eventos) {
        this.personagem = personagem;
        this.ambiente = ambiente;
        this.eventos = eventos;
    }

    public void iniciarTurno() {
        System.out.println("==== Novo Turno ====");
        faseInicio();
        faseAcao();
        faseEventoAleatorio();
        faseManutencao();
        System.out.println("Turno finalizado.\n");
    }

    private void faseInicio() {
        System.out.println("=== Fase de Início ===");
        personagem.exibirStatus();
        ambiente.atualizarCondicoes();
        System.out.println("Resumo do turno anterior...");
    }

    private void faseAcao() {
        System.out.println("=== Fase de Ação ===");
        personagem.escolherAcao();
    }

    private void faseEventoAleatorio() {
        System.out.println("=== Fase de Evento Aleatório ===");
        if (Math.random() < 0.3) { // Exemplo: 30% de chance de evento
            Evento evento = eventos.get((int) (Math.random() * eventos.size()));
            evento.ativar(personagem, ambiente);
        }
    }

    private void faseManutencao() {
        System.out.println("=== Fase de Manutenção ===");
        personagem.atualizarAtributos();
        ambiente.regenerarRecursos();
    }
}
*/
