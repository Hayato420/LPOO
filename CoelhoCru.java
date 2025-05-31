public class CoelhoCru extends Alimento{
    public CoelhoCru(GeradorDeID geradorDeID){
        super(TipoAlimento.COELHOCRU.getNome(),
              TipoAlimento.COELHOCRU.getDescricao(),
              TipoAlimento.COELHOCRU.getPeso(),
              TipoAlimento.COELHOCRU.getDurabilidade(),
              geradorDeID,
              TipoAlimento.COELHOCRU);
    }
}