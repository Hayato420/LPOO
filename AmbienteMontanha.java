public class AmbienteMontanha extends Ambiente{
    //construtor da subclasse
    public AmbienteMontanha() {
        super(
                "Montanha",
                "Uma região de difícil acesso, mas rica em minérios e pedras preciosas.",
                3, //dificuldade, determina o gasto de energia
/*CLASSE ITEM AINDA NAO FOI CRIADA
                //recursosDisponiveis, devemos ainda fazer com que seja aleatorio
                new HashMap<>() {{
                    put(new Item("Pedra"), 9);
                    put(new Item("Ferro"), 3);
                }},
    
                //probabilidadeEventos
                new HashMap<>() {{
                    put(new EventoLobo(), 0.3);
                    put(new EventoTempestade(), 0.2);
                }},
*/
                //Clima da Montanha, devera tar o acendimento de fogueiras
                Clima.FRIO
        );
    }
}