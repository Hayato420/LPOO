public class CarneiroCru extends Alimento{
    public CarneiroCru(GeradorDeID geradorDeID) {
        super(TipoAlimento.CARNEIROCRU.getNome(),
              TipoAlimento.CARNEIROCRU.getDescricao(),
              TipoAlimento.CARNEIROCRU.getPeso(),
              TipoAlimento.CARNEIROCRU.getDurabilidade(),
              geradorDeID,
              TipoAlimento.CARNEIROCRU);
    }
}