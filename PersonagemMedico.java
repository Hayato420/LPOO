public class PersonagemMedico extends Personagem{

    public PersonagemMedico(String nome, GerenciadorDeAmbiente gerenciadorDeAmbiente, GerenciadorDeEvento gerenciadorDeEvento, GeradorDeID geradorDeID){
        super(nome, 100, 100, 100, 100, 100, gerenciadorDeAmbiente, gerenciadorDeEvento, geradorDeID);
    }

    @Override
    public void usarHabilidade(){
        System.out.println("Voce conseguiu curar alguns de seus ferimentos.");
        /*Primeiros socorros: gastar um pouco de energia para recuperar vida sem precisar de remedios*/
        adicionarVida(7);
        perderEnergia(15);
    }
}