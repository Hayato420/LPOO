public class Metal extends Material {
    public Metal(GeradorDeID geradorDeID) {
        super(TipoDeMaterial.METAL.getNome(),
              TipoDeMaterial.METAL.getDescricao(),
              TipoDeMaterial.METAL.getPeso(),
              TipoDeMaterial.METAL.getDurabilidade(),
              geradorDeID,
              TipoDeMaterial.METAL);
    }
}