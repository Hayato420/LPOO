import java.util.concurrent.ThreadLocalRandom;

public class AmbienteDeserto extends Ambiente{
    //construtor da subclasse
    public AmbienteDeserto(){
        super("Deserto", "Uma região extremamente seca e quente, com poucos recursos, onde o ambiente é o maior perigo.", 
        4, Clima.SECO, Temperatura.QUENTE);
        gerarRecursos();
    }   

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando agua
        int quantidadeAgua = ThreadLocalRandom.current().nextInt(0, 6);
        recursosDisponiveis.put("Garrafa", quantidadeAgua);

        //gerando alimentos da lista
        for(Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
            int quantidadeAlimento = ThreadLocalRandom.current().nextInt(0, 3);
            recursosDisponiveis.put(tipo.getNome(), quantidadeAlimento);
        }
        //gerando materiais
        for(Material.TipoDeMaterial tipo : Material.TipoDeMaterial.values()){
            if(tipo != Material.TipoDeMaterial.PEDRA){continue;} //não spawna nada além de pedra
            int quantidadeMaterial = ThreadLocalRandom.current().nextInt(5,11);
            recursosDisponiveis.put(tipo.getNome(), quantidadeMaterial);
        }
        //gerando Ferramentas e Armas
        recursosDisponiveis.putAll(this.getGeradorDeItens().gerarFerrEArm());

        recursosDisponiveis.entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }
}