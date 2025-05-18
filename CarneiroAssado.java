public class CarneiroAssado extends Alimento{
    public CarneiroAssado(GeradorDeID geradorDeID) {
        super(TipoAlimento.CARNEIROASSADO.getNome(),
              TipoAlimento.CARNEIROASSADO.getDescricao(),
              TipoAlimento.CARNEIROASSADO.getPeso(),
              TipoAlimento.CARNEIROASSADO.getDurabilidade(),
              geradorDeID,
              TipoAlimento.CARNEIROASSADO);
    }
}