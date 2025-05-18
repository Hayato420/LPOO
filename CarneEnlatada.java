public class CarneEnlatada extends Alimento{
    public CarneEnlatada(GeradorDeID geradorDeID) {
        super(TipoAlimento.CARNEENLATADA.getNome(),
              TipoAlimento.CARNEENLATADA.getDescricao(),
              TipoAlimento.CARNEENLATADA.getPeso(),
              TipoAlimento.CARNEENLATADA.getDurabilidade(),
              geradorDeID,
              TipoAlimento.CARNEENLATADA);
    }
}