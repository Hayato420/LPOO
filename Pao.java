public class Pao extends Alimento{
    public Pao(GeradorDeID geradorDeID){
        super(TipoAlimento.PAO.getNome(),
              TipoAlimento.PAO.getDescricao(),
              TipoAlimento.PAO.getPeso(),
              TipoAlimento.PAO.getDurabilidade(),
              geradorDeID,
              TipoAlimento.PAO);
    }
}