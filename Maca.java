public class Maca extends Alimento{
    public Maca(GeradorDeID geradorDeID) {
        super(TipoAlimento.MACA.getNome(),
              TipoAlimento.MACA.getDescricao(),
              TipoAlimento.MACA.getPeso(),
              TipoAlimento.MACA.getDurabilidade(),
              geradorDeID,
              TipoAlimento.MACA);
    }
}