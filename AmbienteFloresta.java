import java.util.concurrent.ThreadLocalRandom;

public class AmbienteFloresta extends Ambiente{
    //construtor da subclasse
    public AmbienteFloresta(GeradorDeItens geradorDeItens){
        super("Floresta", "Uma área rica em recursos naturais, mas também habitada por predadores.", 
        2, Clima.UMIDO, Temperatura.NEUTRO, geradorDeItens);
        gerarRecursos();
    }

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando agua
        int quantidadeAgua = ThreadLocalRandom.current().nextInt(0, 6);
        recursosDisponiveis.put("Garrafa", quantidadeAgua);

        //inicializando alimentos da lista
        for (Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
            int quantidadeAlimento = ThreadLocalRandom.current().nextInt(0, 6);
            recursosDisponiveis.put(tipo.getNome(), quantidadeAlimento);
        }
        for (Material.TipoDeMaterial tipo : Material.TipoDeMaterial.values()){
            if(tipo == Material.TipoDeMaterial.METALINOX){continue;} //não spawna metal inoxidável
            if(tipo == Material.TipoDeMaterial.FIBRA){continue;} //não spawna fibra
            int quantidadeMaterial = ThreadLocalRandom.current().nextInt(5,11);
            recursosDisponiveis.put(tipo.getNome(), quantidadeMaterial);
        }
        recursosDisponiveis.putAll(this.getGeradorDeItens().gerarFerrEArm());

        recursosDisponiveis.entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }
}