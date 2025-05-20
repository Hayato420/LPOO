public class Bolachas extends Alimento{
    public Bolachas(GeradorDeID geradorDeID){
        super(TipoAlimento.BOLACHAS.getNome(),
              TipoAlimento.BOLACHAS.getDescricao(),
              TipoAlimento.BOLACHAS.getPeso(),
              TipoAlimento.BOLACHAS.getDurabilidade(),
              geradorDeID,
              TipoAlimento.BOLACHAS);
    }
}