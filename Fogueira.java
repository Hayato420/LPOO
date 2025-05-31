public class Fogueira extends FonteDeCalor{
    public Fogueira(Personagem jogador) throws ExcecaoSemMadeira{
        super(jogador);
        alimentarFogo();
    }
}