public class Alimento extends Item{
    private int valorNutricional;
    private enum tipoAlimento{
        FRUTA{
            @Override
            public void consumir(Personagem jogador){
                jogador.adicionarFome(10);
            }
        },
        CARNE{
            @Override
            public void consumir(Personagem jogador){
                jogador.adicionarFome(10);
            }
        },
        ENLATADO{
            @Override
            public void consumir(Personagem jogador){
                jogador.adicionarFome(10);
            }
        },
        FARINACEOS{
            @Override
            public void consumir(Personagem jogador){
                jogador.adicionarFome(10);
            }
        }
    }
    private int prazoDeValidade;
    private boolean apodrecido = false;
}