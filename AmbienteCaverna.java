import java.util.concurrent.ThreadLocalRandom;

public class AmbienteCaverna extends Ambiente{
    //construtor da subclasse
    public AmbienteCaverna(GeradorDeItens geradorDeItens){
        super("Caverna", "Um grande tunel que passa por baixo da terra, escondido do sol e facil de se perder.", 
        3, Clima.UMIDO, Temperatura.NEUTRO, geradorDeItens);
        gerarRecursos();
    }   

    public void gerarRecursos(){//usado apenas uma vez, se não sobrescreverá
        //gerando agua
        int quantidadeAgua = ThreadLocalRandom.current().nextInt(0, 6);
        getRecursosDisponiveis().put("Garrafa", quantidadeAgua);

        //gerando alimentos da lista
        for(Alimento.TipoAlimento tipo : Alimento.TipoAlimento.values()){
            int quantidadeAlimento = ThreadLocalRandom.current().nextInt(0, 6);
            getRecursosDisponiveis().put(tipo.getNome(), quantidadeAlimento);
        }
        //gerando materiais
        for(Material.TipoDeMaterial tipo : Material.TipoDeMaterial.values()){
            if(tipo == Material.TipoDeMaterial.METALINOX){continue;} //não spawna metal inoxidável
            if(tipo == Material.TipoDeMaterial.MADEIRA){continue;} //não spawna madeira
            if(tipo == Material.TipoDeMaterial.FIBRA){continue;} //não spawna fibra
            int quantidadeMaterial = ThreadLocalRandom.current().nextInt(5,11);
            getRecursosDisponiveis().put(tipo.getNome(), quantidadeMaterial);
        }
        //gerando Ferramentas, Armas e Municao
        getRecursosDisponiveis().putAll(this.getGeradorDeItens().gerarFerrArmMunic());

        getRecursosDisponiveis().entrySet().removeIf(entry -> entry.getValue() == 0);//limpeza dos valores zerados
    }
}