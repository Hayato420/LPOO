public class Madeira extends Material {
    public Madeira(GeradorDeID geradorDeID) {
        super(TipoDeMaterial.MADEIRA.getNome(), 
              TipoDeMaterial.MADEIRA.getDescricao(),
              TipoDeMaterial.MADEIRA.getPeso(), 
              TipoDeMaterial.MADEIRA.getDurabilidade(),
              geradorDeID,
              TipoDeMaterial.MADEIRA);
    }
}