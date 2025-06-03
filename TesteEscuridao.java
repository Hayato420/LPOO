import java.util.Scanner;
public class TesteEscuridao{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        GeradorDeID geradorID = new GeradorDeID();
        GeradorDeItens geradorItens = new GeradorDeItens(geradorID);
        GerenciadorDeAmbiente gerenciadorAmbiente = new GerenciadorDeAmbiente(geradorItens);
        GerenciadorDeEvento gerenciadorEvento = new GerenciadorDeEvento(geradorItens);

        ChecagemFimDeTurno checador = new ChecagemFimDeTurno();
        PersonagemExplorador jogador = new PersonagemExplorador("Adeildo L Durval", gerenciadorAmbiente, gerenciadorEvento, geradorID);

        Material material1 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorID);
        Material material2 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorID);
        Material material3 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorID);
        Material material4 = Material.TipoDeMaterial.METALINOX.criarMaterial(geradorID);

        FluidoDeIsqueiro fluidoDeIsqueiro = new FluidoDeIsqueiro(20, material1, material2, geradorID);
        Isqueiro isqueiro = new Isqueiro(material3, material4, geradorID);

        jogador.getInventario().adicionarItem(fluidoDeIsqueiro);
        jogador.getInventario().adicionarItem(isqueiro);
        jogador.setLocalizacao(new AmbienteCaverna(geradorItens));
        jogador.explorar();

        System.out.println("Uso 1");
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
        jogador.usarItem(fluidoDeIsqueiro.getID());
        if(jogador.temFluidoDeIsqueiro()){
        jogador.usarItem(isqueiro.getID());
        }
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
        System.out.println("Uso 2");
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
        jogador.usarItem(fluidoDeIsqueiro.getID());
        if(jogador.temFluidoDeIsqueiro()){
        jogador.usarItem(isqueiro.getID());
        }
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
        System.out.println("Uso 3");
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
        jogador.usarItem(fluidoDeIsqueiro.getID());
        if(jogador.temFluidoDeIsqueiro()){
        jogador.usarItem(isqueiro.getID());
        }
        System.out.println(fluidoDeIsqueiro.getQuantiaAtual());
    }
}