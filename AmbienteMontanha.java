import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AmbienteMontanha extends Ambiente{
    //construtor da subclasse
    public AmbienteMontanha(GeradorDeItens geradorDeItens){
        super("Montanha", "Uma região de difícil acesso, mas rica em minérios e pedras preciosas.", 
        3, Clima.AMENO, Temperatura.FRIO, geradorDeItens);
        gerarRecursos();
    }   

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando alimentos da lista
        for(Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
            int quantidadeAlimento = ThreadLocalRandom.current().nextInt(0, 6);
            recursosDisponiveis.put(tipo.getNome(), quantidadeAlimento);
        }
        //gerando materiais
        for(Material.TipoDeMaterial tipo : Material.TipoDeMaterial.values()){
            if(tipo == Material.TipoDeMaterial.METALINOX){continue;} //não spawna metal inoxidável
            if(tipo == Material.TipoDeMaterial.MADEIRA){continue;} //não spawna madeira
            if(tipo == Material.TipoDeMaterial.FIBRA){continue;} //não spawna fibra
            int quantidadeMaterial = ThreadLocalRandom.current().nextInt(5,11);
            recursosDisponiveis.put(tipo.getNome(), quantidadeMaterial);
        }
        //gerando Ferramentas e Armas
        recursosDisponiveis.put("Arco", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Espada", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Lanca", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Pistola", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Faca", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Isqueiro", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Lanterna", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Machado", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Balas", ThreadLocalRandom.current().nextInt(0, 2)); //se achado, deverá dar várias municoes, ou mudamos municao de bala
        recursosDisponiveis.put("Flechas", ThreadLocalRandom.current().nextInt(0, 2));
        recursosDisponiveis.put("Picareta", ThreadLocalRandom.current().nextInt(0, 2));

        recursosDisponiveis.entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }

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
}