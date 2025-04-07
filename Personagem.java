import java.util.ArrayList;
import java.util.List;

public class Personagem{
        
        private String nome;
        private int vida;
        private int fome;
        private int sede;
        private int energia;
        private int sanidade;
        /*private List<Item> inventario = new ArrayList<>();*/
        private Ambiente localizacao;

        public Personagem(String nome, Ambiente ambienteInicialAleatorio){
            this.nome = nome;
            this.vida = 150;
            this.energia = 100;
            this.fome = 100;
            this.sanidade = 100;
            /*this.inventario = new ArrayList<>();*/
            this.localizacao = ambienteInicialAleatorio;
        }

        /* public void usarHabilidade(){}; SERA ABSTRATO, CADA SUBCLASSE DEFINIRA SUA MODO DE USO */


        public String getNome(){
            return this.nome;
        }

        public Ambiente getLocalizacao() {
            return localizacao;
        }

        public void setLocalizacao(Ambiente novaLocalizacao){
            this.localizacao = novaLocalizacao;
        }

        public int getVida() {
            return this.vida;
        }

        public void adicionarVida(int quantidade){
            this.vida += quantidade;
            if (this.vida > 150){
                this.vida = 150;
            }
        }

        public void perderVida(int quantidade){
            this.vida -= quantidade;
            if(this.vida <=0){
                System.out.print("Seus pontos de vida acabaram. Fim de jogo.");
            }
        }

        public int getEnergia(){
            return this.energia;
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

        public int getFome(){
            return this.fome;
        }

        public void adicionarFome(int quantidade){
            this.fome += quantidade;
            if(this.fome > 100){
                this.fome = 100;
            }
        }

        public void perderFome(int quantidade){
            this.fome -= quantidade;
            if(this.fome <= 0){
                System.out.print("Sua fome zerou. Fim de jogo.");
            }
        }

        public int getSede(){
            return this.fome;
        }

        public void adicionarSede(int quantidade){
            this.fome += quantidade;
            if(this.fome > 100){
                this.fome = 100;
            }
        }

        public void perderSede(int quantidade){
            this.fome -= quantidade;
            if(this.fome <= 0){
                System.out.print("Sua fome zerou. Fim de jogo.");
            }
        }

        public int getSanidade(){
            return this.sanidade;
        }

        public void adicionarSanidade(int quantidade){
            this.sanidade += quantidade;
            if (this.sanidade > 100){
                this.sanidade = 100;
            }
        }

        public void perderSanidade (int quantidade) {
            this.sanidade -= quantidade;
            if(this.sanidade <= 0){
                System.out.print("Você ensandeceu. Fim de jogo.");
            }
        }
}

/*
class Rastreador extends Personagem{
    public Rastreador (String nome, Ambiente ambienteInicial, int energia){
        super(nome, ambienteInicial);   
        this.energia = 120;
    }

    public void adicionarEnergia(int quantidade){
        this.energia += quantidade;
        if (this.energia > 120) {
            this.energia = 120;
        }
    }
}
*/
