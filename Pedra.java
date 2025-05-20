public class Pedra extends Material{
    public Pedra(GeradorDeID geradorDeID) {
        super(TipoDeMaterial.PEDRA.getNome(),
              TipoDeMaterial.PEDRA.getDescricao(),
              TipoDeMaterial.PEDRA.getPeso(),
              TipoDeMaterial.PEDRA.getDurabilidade(),
              geradorDeID,
              TipoDeMaterial.PEDRA);
    }
}