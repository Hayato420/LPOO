import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;

public class Ambiente{
    private String nome;
    private String descricao;
    private int dificuldade;
    /*private Map<Item, Integer> recursosDisponiveis = new HashMap<>();
    private Map<Evento, Double> probabilidadeEventos = new HashMap<>();*/
    private Clima condicoesClimaticas;
    private Temperatura temperaturaAmbiente;
    enum Clima {
        UMIDO, SECO, TEMPESTUOSO, AMENO
    }
    enum Temperatura{
        QUENTE, FRIO, NEUTRO
    }

    public Ambiente(String nome, String descricao, int dificuldade,
                    /*Map<Item, Integer> recursosDisponiveis,
                    Map<Evento, Double> probabilidadeEventos,*/
                    Clima condicoesClimaticas, Temperatura temperaturaAmbiente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        /*this.recursosDisponiveis = recursosDisponiveis;
        this.probabilidadeEventos = probabilidadeEventos;*/ //AINDA NAO FOI DEFINIDO, DEVE-SE ACRESCENTAR DPS, ASSIM COMO NO CONSTRUTOR
        this.condicoesClimaticas = condicoesClimaticas;
        this.temperaturaAmbiente = temperaturaAmbiente;
    }


    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public int getDificuldade(){
        return this.dificuldade;
    }

    public void explorar(Personagem jogador, Ambiente ambiente){
        jogador.perderEnergia(ambiente.getDificuldade());
    }

    public Evento gerarEvento(){
    
    }

    public void modificarClima(){
    
    }
}
