public class Inimigo{

    private final String nome;
    private final String descricao;
    private int vida;
    private final int iniciativa;
    private final int dano;
    private final int resistencia;
    private boolean isAlive;

    public Inimigo(String nome, String descricao, int vida, int iniciativa, int dano, int resistencia, boolean isAlive){

        this.nome = nome;
        this.descricao = descricao;
        this.vida = vida;
        this.iniciativa = iniciativa;
        this.dano = dano;
        this.resistencia = resistencia;
        this.isAlive = true;

    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getIniciativa(){
        return this.iniciativa;
    }

    public int getDano(){
        return this.dano;
    }

    public int getResistencia(){
        return this.resistencia;
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
            this.isAlive = false;
        }
    }

}