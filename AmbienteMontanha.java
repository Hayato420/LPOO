import java.util.concurrent.ThreadLocalRandom;

public class AmbienteMontanha extends Ambiente{
    //construtor da subclasse
    public AmbienteMontanha(GeradorDeItens geradorDeItens){
        super("Montanha", "Uma região de difícil acesso, mas rica em minérios e pedras preciosas.", 
        3, Clima.AMENO, Temperatura.FRIO, geradorDeItens);
        gerarRecursos();
    }   

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando agua
        int quantidadeAgua = ThreadLocalRandom.current().nextInt(0, 6);
        recursosDisponiveis.put("Garrafa", quantidadeAgua);

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
        recursosDisponiveis.putAll(this.getGeradorDeItens().gerarFerrEArm());

        recursosDisponiveis.entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }
}