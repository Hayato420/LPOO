public class MetalInox extends Material{
    public MetalInox(GeradorDeID geradorDeID){
        super(TipoDeMaterial.METALINOX.getNome(),
              TipoDeMaterial.METALINOX.getDescricao(),
              TipoDeMaterial.METALINOX.getPeso(),
              TipoDeMaterial.METALINOX.getDurabilidade(),
              geradorDeID,
              TipoDeMaterial.METALINOX);
    }
}