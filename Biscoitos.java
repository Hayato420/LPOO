public class Biscoitos extends Alimento{
    public Biscoitos(GeradorDeID geradorDeID){
        super(TipoAlimento.BISCOITOS.getNome(),
              TipoAlimento.BISCOITOS.getDescricao(),
              TipoAlimento.BISCOITOS.getPeso(),
              TipoAlimento.BISCOITOS.getDurabilidade(),
              geradorDeID,
              TipoAlimento.BISCOITOS);
    }
}