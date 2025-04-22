public class Inimigo{

    private String nome;
    private int vida;
    private int dano;
    private int resistencia;
    private boolean isAlive;

    public Inimigo(String nome, int vida, int dano, int resistencia, boolean isAlive){

        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.resistencia = resistencia;
        this.isAlive = isAlive;

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getDano(){
        return this.dano;
    }

    public void setDano(int dano){
        this.dano = dano;
    }

    public int getResistencia(){
        return this.resistencia;
    }

    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public void perderVida(int quantidade){
        if(this.resistencia >= quantidade){
            this.vida -= 1;
        }
        else {
            this.vida -= (quantidade - this.resistencia);
        }
        if(this.vida <= 0){
            this.vida = 0;
            System.out.print("O inimigo morreu");
        }
    }

}
