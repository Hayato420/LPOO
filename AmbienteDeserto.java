import java.util.concurrent.ThreadLocalRandom;

public class AmbienteDeserto extends Ambiente{
    //construtor da subclasse
    public AmbienteDeserto(GeradorDeItens geradorDeItens){
        super("Deserto", "Uma região extremamente seca e quente, com poucos recursos, onde o ambiente é o maior perigo.", 
        4, Clima.SECO, Temperatura.QUENTE, geradorDeItens);
        gerarRecursos();
    }   

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando agua
        int quantidadeAgua = ThreadLocalRandom.current().nextInt(0, 6);
        getRecursosDisponiveis().put("Garrafa", quantidadeAgua);

        //gerando alimentos da lista
        for(Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
            int quantidadeAlimento = ThreadLocalRandom.current().nextInt(0, 3);
            getRecursosDisponiveis().put(tipo.getNome(), quantidadeAlimento);
        }
        //gerando materiais
        for(Material.TipoDeMaterial tipo : Material.TipoDeMaterial.values()){
            if(tipo != Material.TipoDeMaterial.PEDRA){continue;} //não spawna nada além de pedra
            int quantidadeMaterial = ThreadLocalRandom.current().nextInt(5,11);
            getRecursosDisponiveis().put(tipo.getNome(), quantidadeMaterial);
        }
        //gerando Ferramentas e Armas
        getRecursosDisponiveis().putAll(this.getGeradorDeItens().gerarFerrArmMunic());

        getRecursosDisponiveis().entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }
}