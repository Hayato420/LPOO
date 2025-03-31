import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;ap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;ap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;

public class Ambiente{
    private String nome;
    private String descricao;
    private int dificuldade;
    private List<Item> recursosDisponiveis = new ArrayList<>(); 
    private Map<Evento, Double> probabilidadeEventos = new HashMap<>();
    private Set<Clima> condicoesClimaticas = new HashSet<>();

    public String getNome(){
        return this.nome
    }

    public abstract void explorar(Personagem jogador);

    public abstract Evento gerarEvento(){

    }

    public abstract void modificarClima(){

    }


    class AmbienteFloresta extends Ambiente{

        public void explorar(Personagem jogador){
            jogador.perderEnergia(2);
        }
    }
    class AmbienteMontanha extends Ambiente{}
    class AmbienteCaverna extends Ambiente{}
    class AmbienteLagoRio extends Ambiente{}
    class AmbienteRuinas extends Ambiente{}

}