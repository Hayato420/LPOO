public class Ambiente{
    private final String nome;
    private final String descricao;
    private final int dificuldade;
    private final Clima condicoesClimaticas;
    private final Temperatura temperaturaAmbiente;
    private GeradorDeItens geradorDeItens;
    public enum Clima {
        UMIDO, SECO, TEMPESTUOSO, AMENO
    }
    public enum Temperatura{
        QUENTE, FRIO, NEUTRO
    }

    public Ambiente(String nome, String descricao, int dificuldade,
                    Clima condicoesClimaticas, Temperatura temperaturaAmbiente,
                    GeradorDeItens geradorDeItens){
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.condicoesClimaticas = condicoesClimaticas;
        this.temperaturaAmbiente = temperaturaAmbiente;
        this.geradorDeItens = geradorDeItens;
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

    public GeradorDeItens getGeradorDeItens(){
        return this.geradorDeItens;
    }

    public void explorar(Personagem jogador, Ambiente ambiente){
        jogador.perderEnergia(ambiente.getDificuldade());
    }

    /*public Evento gerarEvento(){
    
    }*/

    public void modificarClima(){
    
    }
}
