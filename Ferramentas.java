public class Ferramentas extends Item{
    private enum tipoFerramenta{
        MACHADO{
            @Override
            public void usar(Personagem jogador){
                jogador.perderEnergia(10);

            }
        },
        PICARETA{
            @Override
            public void usar(Personagem jogador){
                jogador.perderEnergia(10);

            }
        },
        FACA{
            @Override
            public void usar(Personagem jogador){
                jogador.perderEnergia(5);
                
            }
        },
        ISQUEIRO{
            @Override
            public void usar(Personagem jogador){
                
            }
        },
        LANTERNA{
            @Override
            public void usar(Personagem jogador){
                
            }
        }
    }

    private int eficiencia;
}