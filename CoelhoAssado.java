public class CoelhoAssado extends Alimento{
    public CoelhoAssado(GeradorDeID geradorDeID){
        super(TipoAlimento.COELHOASSADO.getNome(),
              TipoAlimento.COELHOASSADO.getDescricao(),
              TipoAlimento.COELHOASSADO.getPeso(),
              TipoAlimento.COELHOASSADO.getDurabilidade(),
              geradorDeID,
              TipoAlimento.COELHOASSADO);
    }
}