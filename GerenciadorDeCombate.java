import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorDeCombate{

    private final List<Inimigo> inimigosDisponiveis;
    private final Random aleatorio = new Random();
    private boolean iniciativa;
    private Inimigo inimigo;
    private Personagem personagem;

    //construtor do gerenciador

    public GerenciadorDeCombate(){
        this.inimigosDisponiveis = Arrays.asList(
            /*
            new InimigoBandido(),
            new InimigoUrso(),
            new InimigoCobra(),
            new InimigoCorvos(),
            new InimigoLobo(),
            new InimigoCanibal(),
            new InimigoCultista()
            */
            new InimigoTeste()
        );
    }

    public Personagem getPersonagem(){
        return this.personagem;
    }

    public Inimigo getInimigo(){
        return this.inimigo;
    }

    public boolean getIniciativa(){
        return this.iniciativa;
    }

    public void setPersonagem(Personagem personagem){
        this.personagem = personagem;
    }

    public void setInimigo(Inimigo inimigo){
        this.inimigo = inimigo;
    }

    public void setIniciativa(boolean iniciativa){
        this.iniciativa = iniciativa;
    }

    public List<Inimigo> getInimigosDisponiveis(){
        return this.inimigosDisponiveis;
    }

    public Inimigo gerarInimigo(){
        Inimigo novoInimigo = inimigosDisponiveis.get(aleatorio.nextInt(inimigosDisponiveis.size()));
        return novoInimigo;
    }

    public boolean iniciativa(Inimigo inimigo, Personagem personagem){      //retorna true se o jogador atacar primeiro
        int iniciativaInimigo = inimigo.getIniciativa()+aleatorio.nextInt(10);
        int iniciativaPersonagem = personagem.getArmaEquipada().getAlcance()+aleatorio.nextInt(10);
        if(iniciativaPersonagem > iniciativaInimigo){
            return true;        //jogador começa o combate
        }else if(iniciativaPersonagem < iniciativaInimigo){
            return false;       //inimigo começa o combate
        }else return inimigo.getIniciativa() <= personagem.getArmaEquipada().getAlcance(); //se iniciativa maior, inimigo começa, se não, jogador começa
        
    }

    public void inimigoSeAproxima(){        //esse metodo vai gerar o inimigo e a iniciativa em preparação para o combate
        setInimigo(gerarInimigo());
        setIniciativa(iniciativa(getInimigo(),getPersonagem()));
    }

    public void horaDoDuelo(){      //o loop de combate em si
        int rodada = 0;
        while(personagem.getEmCombate() == true){    
            if(this.iniciativa == true){
                /*aqui estarão as decisões do jogador.
                desde atacar a fugir ou usar algum item*/
                //por enquanto apenas funções de ataque foram implementadas (por causa de um erro no vscode)
                inimigo.perderVida(personagem.getArmaEquipada().getDano());
                setIniciativa(false);
                rodada += 1;        //aumentar o contador de turnos só durante a vez do jogador
                System.out.println("Rodada: "+ rodada);
            }else{
                personagem.perderVida(inimigo.getDano());
                inimigo.gerarStatus(personagem);
                setIniciativa(true);
            }
            if(inimigo.getIsAlive() == false){      //se o inimigo morrer
                personagem.setEmCombate(false);     //o combate termina
            }
        }
    }
    

}