public class Laranja extends Alimento{
    public Laranja(GeradorDeID geradorDeID) {
        super(TipoAlimento.LARANJA.getNome(),
              TipoAlimento.LARANJA.getDescricao(),
              TipoAlimento.LARANJA.getPeso(),
              TipoAlimento.LARANJA.getDurabilidade(),
              geradorDeID,
              TipoAlimento.LARANJA);
    }
}