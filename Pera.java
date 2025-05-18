public class Pera extends Alimento{
    public Pera(GeradorDeID geradorDeID) {
        super(TipoAlimento.PERA.getNome(),
              TipoAlimento.PERA.getDescricao(),
              TipoAlimento.PERA.getPeso(),
              TipoAlimento.PERA.getDurabilidade(),
              geradorDeID,
              TipoAlimento.PERA);
    }
}