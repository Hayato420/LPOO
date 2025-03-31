import java.util.ArrayList;
import java.util.List;

public class Personagem{
        private String nome;
        private int vida;
        private int fome;
        private int sede;
        private int energia = 100;
        private int sanidade;
        private List<Item> inventario = new ArrayList<>();
        private Ambiente ambienteAtual;

        public Personagem(String nome, Ambiente ambienteInicial){
            this.nome = nome;
            this.vida = 100;
            this.energia = 100;
            this.fome = 0;
            this.sanidade = 100;
            this.inventario = new ArrayList<>();
            this.ambienteAtual = ambienteInicial;
        }

        abstract void usarHabilidade();

        public Ambiente getAmbienteAtual() {
            return ambienteAtual;
        }

        public void setAmbienteAtual(Ambiente novoAmbiente) {
            this.ambienteAtual = novoAmbiente;
        }

        public void adicionarEnergia(int quantidade){
            this.energia += quantidade;
            if (this.energia > 100) {
                this.energia = 100;
            }
        }

        public void perderEnergia(int quantidade){
            this.energia -= quantidade;
            if (this.energia <= 0) {
                System.out.print("Sua energia acabou. Fim de jogo.");
            }
        }
    }

class Rastreador extends Personagem{
    public Rastreador (String nome, Ambiente ambienteInicial){
        super(nome, ambienteInicial);   
        this.adicionarEnergia(20);
    }

    public void adicionarEnergia(int quantidade){
        this.energia += quantidade;
        if (this.energia > 120) {
            this.energia = 120;
        }
    }
}