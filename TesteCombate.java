import java.util.Scanner;

public class TesteCombate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Geradores
        GeradorDeID geradorID = new GeradorDeID();
        GeradorDeItens geradorItens = new GeradorDeItens(geradorID);
        GerenciadorDeAmbiente gerenciadorAmbiente = new GerenciadorDeAmbiente(geradorItens);
        GerenciadorDeEvento gerenciadorEvento = new GerenciadorDeEvento(geradorItens);
        ChecagemFimDeTurno checador = new ChecagemFimDeTurno();

        // Criar personagem
        PersonagemExplorador jogador = new PersonagemExplorador("Adeildo L Durval", gerenciadorAmbiente, gerenciadorEvento, geradorID);

        // Criar arma e munição manualmente
        Material material1 = Material.TipoDeMaterial.METAL.criarMaterial(geradorID);
        Material material2 = Material.TipoDeMaterial.METAL.criarMaterial(geradorID);
        Material material3 = Material.TipoDeMaterial.METAL.criarMaterial(geradorID);
        Material material4 = Material.TipoDeMaterial.METAL.criarMaterial(geradorID);
        Arma espada = new Espada(Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 3, material1, material2, geradorID); // dano 10
        Flechas flechas = new Flechas(4, material3, material4, geradorID); // 20 flechas

        // Adicionar ao inventário
        jogador.getInventario().adicionarItem(espada);
        jogador.getInventario().adicionarItem(flechas);

        // Equipar arco
        jogador.setArmaEquipada(espada);

        // Iniciar combate
        GerenciadorDeCombate combate = new GerenciadorDeCombate(jogador);
        combate.iniciarCombate();
    }
}