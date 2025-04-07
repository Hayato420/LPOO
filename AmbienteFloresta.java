public class AmbienteFloresta extends Ambiente{
    //construtor da subclasse
    public AmbienteFloresta() {
        super(
            "Floresta",
            "Uma área rica em recursos naturais, mas também habitada por predadores.",
            2, //dificuldade, determina o gasto de energia
/*CLASSE ITEM AINDA NAO FOI CRIADA
            //recursosDisponiveis
            new HashMap<>() {{
                put(new Item("Galho"), 5);
                put(new Item("Fruta"), 3);
            }},

            //probabilidadeEventos
            new HashMap<>() {{
                put(new EventoLobo(), 0.3);
                put(new EventoTempestade(), 0.2);
            }},
*/
            //Clima da Floresta, devera dificultar o acendimento de fogueiras
            Clima.UMIDO
        );
    }

    public void explorar(Personagem jogador, Ambiente ambiente){
        jogador.perderEnergia(ambiente.getDificuldade());
    }
}