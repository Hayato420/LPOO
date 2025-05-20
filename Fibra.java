public class Fibra extends Material {
    public Fibra(GeradorDeID geradorDeID) {
        super(TipoDeMaterial.FIBRA.getNome(),
              TipoDeMaterial.FIBRA.getDescricao(),
              TipoDeMaterial.FIBRA.getPeso(),
              TipoDeMaterial.FIBRA.getDurabilidade(),
              geradorDeID,
              TipoDeMaterial.FIBRA);
    }
}