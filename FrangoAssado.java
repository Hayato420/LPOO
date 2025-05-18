public class FrangoAssado extends Alimento{
    public FrangoAssado(GeradorDeID geradorDeID) {
        super(TipoAlimento.FRANGOASSADO.getNome(),
              TipoAlimento.FRANGOASSADO.getDescricao(),
              TipoAlimento.FRANGOASSADO.getPeso(),
              TipoAlimento.FRANGOASSADO.getDurabilidade(),
              geradorDeID,
              TipoAlimento.FRANGOASSADO);
    }
}