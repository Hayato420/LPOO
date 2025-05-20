public class FeijoadaEnlatada extends Alimento{
    public FeijoadaEnlatada(GeradorDeID geradorDeID){
        super(TipoAlimento.FEIJOADAENLATADA.getNome(),
              TipoAlimento.FEIJOADAENLATADA.getDescricao(),
              TipoAlimento.FEIJOADAENLATADA.getPeso(),
              TipoAlimento.FEIJOADAENLATADA.getDurabilidade(),
              geradorDeID,
              TipoAlimento.FEIJOADAENLATADA);
    }
}