public class Ambiente{
    private final String nome;
    private final String descricao;
    private final int dificuldade;
    /*private Map<Item, Integer> recursosDisponiveis = new HashMap<>();
    private Map<Evento, Double> probabilidadeEventos = new HashMap<>();*/
    private final Clima condicoesClimaticas;
    private final Temperatura temperaturaAmbiente;
    public enum Clima {
        UMIDO, SECO, TEMPESTUOSO, AMENO
    }
    public enum Temperatura{
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

    public Clima getClima(){
        return this.condicoesClimaticas;
    }

    public Temperatura getTemperatura(){
        return this.temperaturaAmbiente;
    }

    public void explorar(Personagem jogador, Ambiente ambiente){
        jogador.perderEnergia(ambiente.getDificuldade());
    }

    /*public Evento gerarEvento(){
    
    }*/

    public void modificarClima(){
    
    }
}
