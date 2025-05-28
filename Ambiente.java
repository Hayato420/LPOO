import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Ambiente{
    private final String nome;
    private final String descricao;
    private final int dificuldade;
    private final Clima condicoesClimaticas;
    private final Temperatura temperaturaAmbiente;
    private GeradorDeItens geradorDeItens;
    Map<String, Integer> recursosDisponiveis = new HashMap<>();

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

    //RECURSOS
    public boolean diminuirRecurso(String nomeDoRecurso){
        int valorAtual = recursosDisponiveis.getOrDefault(nomeDoRecurso, 0);

        if (valorAtual > 0){
            recursosDisponiveis.put(nomeDoRecurso, valorAtual - 1);
            return true;
        } else{
            recursosDisponiveis.remove(nomeDoRecurso); //se o recurso esgotar
            return false;
        }
    }

    public Item coletarRecurso(Personagem jogador){
        if (recursosDisponiveis.isEmpty()) return null; //se não houver mais nada, EXCEPTION: "Recursos não foram encontrados."

        List<String> chavesDeRecursos = new ArrayList<>(recursosDisponiveis.keySet());
        String recursoEscolhido = chavesDeRecursos.get(ThreadLocalRandom.current().nextInt(chavesDeRecursos.size()));//sorteia uma chave aleatoria, usando o tamanho do hashmap para isso
        if(diminuirRecurso(recursoEscolhido)){ //retira, se houver, o recurso do ambiente
            //CRIAÇÃO DO OBJETO EQUIVALENTE À CHAVE

            //se for alimento
            for (Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
                if (tipo.getNome().equalsIgnoreCase(recursoEscolhido)){
                    return tipo.criarAlimento(this.getGeradorDeItens().getGeradorDeID());
                }
            }
            //se não for alimento
            switch (recursoEscolhido){
                case "Garrafa":  return this.getGeradorDeItens().gerarAguaAleatoria();
                case "Arco":     return this.getGeradorDeItens().gerarArco(jogador, this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID(), this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID());
                case "Espada":   return this.getGeradorDeItens().gerarEspada(jogador, this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID(), this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID());
                case "Faca":     return this.getGeradorDeItens().gerarFaca(jogador, this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID(), this.getGeradorDeItens().gerarMateriaisAleatParaFerram().getID());
                case "Pistola":  return this.getGeradorDeItens().gerarPistola();
                /*case "Flechas":  return this.getGeradorDeItens().gerarFlechas(
                case "Balas":    return this.getGeradorDeItens().gerarBalas(*/
                case "Isqueiro": return this.getGeradorDeItens().gerarIsqueiro();
                default:         return new Espada("Fallback", "Fallback", 1, this.getGeradorDeItens().getGeradorDeID(), 
                                                    Arma.TipoArma.corpoACorpo, Arma.QualArma.ESPADA, 1, 
                                                    this.getGeradorDeItens().gerarMateriaisAleatParaFerram(), 
                                                    this.getGeradorDeItens().gerarMateriaisAleatParaFerram());
            }
        }
        else{
            return null; //caso o recurso escolhido não tenha tenha mais disponível. EXCEPTION: "Recursos não foram encontrados."
        }
    }

    /*public Evento gerarEvento(){
    
    }*/

    public void modificarClima(){
    
    }
}
