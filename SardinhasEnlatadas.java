public class SardinhasEnlatadas extends Alimento{
    public SardinhasEnlatadas(GeradorDeID geradorDeID) {
        super(TipoAlimento.SARDINHASENLATADAS.getNome(),
              TipoAlimento.SARDINHASENLATADAS.getDescricao(),
              TipoAlimento.SARDINHASENLATADAS.getPeso(),
              TipoAlimento.SARDINHASENLATADAS.getDurabilidade(),
              geradorDeID,
              TipoAlimento.SARDINHASENLATADAS);
    }
}