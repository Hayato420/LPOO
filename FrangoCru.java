public class FrangoCru extends Alimento{
    public FrangoCru(GeradorDeID geradorDeID) {
        super(TipoAlimento.FRANGOCRU.getNome(),
              TipoAlimento.FRANGOCRU.getDescricao(),
              TipoAlimento.FRANGOCRU.getPeso(),
              TipoAlimento.FRANGOCRU.getDurabilidade(),
              geradorDeID,
              TipoAlimento.FRANGOCRU);
    }
}