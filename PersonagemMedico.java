public class PersonagemMedico extends Personagem{

    public PersonagemMedico(String nome){
        super(nome, 100, 100, 100, 100, 100);
    }

    @Override
    public void usarHabilidade(){
        /*Primeiros socorros: gastar um pouco de energia para recuperar vida sem precisar de remedios*/
        adicionarVida(7);
        perderEnergia(15);
    }



}