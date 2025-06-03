import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorDeCombate{
    private final List<Inimigo> inimigosDisponiveis;
    private final Random aleatorio = new Random();
    private boolean iniciativa;

    private Personagem jogador;
    private Inimigo inimigo;
    private Scanner scanner = new Scanner(System.in);

    public GerenciadorDeCombate(Personagem jogador){
        this.jogador = jogador;
        this.inimigosDisponiveis = Arrays.asList(
            //new InimigoBandido(),
           new InimigoUrso()
           //new InimigoTeste()
        );
    }

    public Personagem getPersonagem(){
        return this.jogador;
    }

    public Inimigo getInimigo(){
        return this.inimigo;
    }

    public boolean getIniciativa(){
        return this.iniciativa;
    }

    public void setPersonagem(Personagem jogador){
        this.jogador = jogador;
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

    public Inimigo gerarNovoInimigo(){
        Inimigo novoInimigo = inimigosDisponiveis.get(aleatorio.nextInt(inimigosDisponiveis.size()));
        return novoInimigo;
    }

    public boolean calcIniciativa(Inimigo inimigo, Personagem jogador){      //retorna true se o jogador atacar primeiro
        int iniciativaInimigo = inimigo.getIniciativa()+aleatorio.nextInt(10);
        if(jogador.getArmaEquipada() != null){
            int iniciativaPersonagem = jogador.getArmaEquipada().getAlcance()+aleatorio.nextInt(10);
            if(iniciativaPersonagem > iniciativaInimigo){
                return true;        //jogador começa o combate
            }else if(iniciativaPersonagem < iniciativaInimigo){
                return false;       //inimigo começa o combate
            }
            else{
            return inimigo.getIniciativa() <= jogador.getArmaEquipada().getAlcance(); //se iniciativa maior, inimigo começa, se não, jogador começa
            }
        }
        else{
            return inimigo.getIniciativa() <= 5;//se iniciativa maior, inimigo começa, se não, jogador começa
        }
    }

    public void inimigoSeAproxima(){ //esse metodo vai gerar o inimigo e a iniciativa em preparação para o combate
        this.setInimigo(this.gerarNovoInimigo());
        this.setIniciativa(calcIniciativa(this.getInimigo(), this.getPersonagem()));
    }

    public void iniciarCombate(){
        this.inimigoSeAproxima();
        System.out.println("Combate contra " + inimigo.getNome() + " iniciado.");
        int turno = 1;

        jogador.setEmCombate(true);

        while(jogador.getEmCombate() == true){
            System.out.println("============================================================");
            System.out.println("Turno atual: " + turno);
            if(this.getIniciativa() == true){
                System.out.println("\n=== TURNO DO JOGADOR ===");
                exibirEstados();
                boolean turnoPassou = false;
                while(!turnoPassou){
                    System.out.println("Escolha uma acao: ATACAR / TROCAR de arma / DESEQUIPAR / EXIBIR estados");
                    String acao = scanner.nextLine().trim().toLowerCase();

                    switch (acao){
                        case "atacar":
                            atacarInimigo();
                            turnoPassou = true;
                            this.setIniciativa(!this.getIniciativa());
                            turno++;
                            break;
                        case "trocar":
                            jogador.exibirItens();
                            System.out.println("Insira o ID da arma nova ou V para voltar: ");
                            String ID = scanner.nextLine().trim();
                            if (ID.equals("V")){
                                System.out.println("Voltando para opcoes anteriores...");
                                break;
                            }
                            boolean armaEncontrada = false;
                            for(Item item : jogador.getInventario().getItens()){
                                if(item instanceof Arma && item.getID().equals(ID)){
                                    jogador.setArmaEquipada((Arma) item);
                                    System.out.println("Arma equipada !");
                                    turnoPassou = true;
                                    this.setIniciativa(!this.getIniciativa());
                                    turno++;
                                    armaEncontrada = true;
                                    break;
                                }
                            }
                            if (!armaEncontrada) {
                                System.out.println("Arma de ID \"" + ID + "\" nao encontrada.");
                            }
                            break;

                        case "desequipar":
                            jogador.setArmaEquipada(null);
                            turnoPassou = true;
                            this.setIniciativa(!this.getIniciativa());
                            turno++;
                            break;
                        case "exibir":
                            exibirEstados();
                            break;
                        default:
                            System.out.println("Insira uma opcao valida.");
                    }
                }
                //inimigo morto?
                if (inimigo.getIsAlive() == false){
                    System.out.println("Agora e apenas um cadaver.");
                    jogador.setEmCombate(false);
                    break;
                }
            } else{
                System.out.println("\n=== TURNO DO INIMIGO ===");
                acaoInimigo();
                this.setIniciativa(!this.getIniciativa());
                turno++;

                //player morto?
                if (jogador.getVida() <= 0) {
                    System.out.println("Você foi derrotado...");
                    jogador.setCondicaoDerrota(true);
                    jogador.setEmCombate(false);
                    break;
                }
            }
        }
    }

    private void atacarInimigo(){
        Arma arma = jogador.getArmaEquipada();
        int dano = 5; // dano do soco padrão

        if(arma == null){ //sem armas -> soca o inimigo, pouco dano, alto gasto de energia
            System.out.println("I fight with my bare hands ! Seria melhor uma arma nao acha?");
            inimigo.perderVida(dano);
            jogador.perderEnergia(5);
            return;
        }

        if(arma.getTipo() == Arma.TipoArma.corpoACorpo){ //arma corpo a corpo, mais dano, energia gasta mediana
            dano = arma.getDano();
            System.out.println("Voce atacou usando " + arma.getNome() + ".");
            inimigo.perderVida(dano);
            jogador.perderEnergia(3);

        } else if(arma.getTipo() == Arma.TipoArma.aDistancia){ //arma a distancia, menor gasto de energia
            Municao municao = acharMun(jogador, arma);
            if (municao == null){
                System.out.println("Falta municao para esta arma, melhor trocar.");
                return;
            }

            if(municao instanceof Flechas){
                Flechas flechas = (Flechas) municao;
                dano = flechas.getDano();
                System.out.println("Flecha atirada !");
                flechas.diminuirQuantia(jogador, 1);

            } else if(municao instanceof Balas){
                Balas balas = (Balas) municao;
                dano = balas.getDano();
                System.out.println("Pow pow !");
                balas.diminuirQuantia(jogador, 1);
            } else{
                System.out.println("Debug: Municao incompativel. Verificar acharMun");
                return;
            }

        inimigo.perderVida(dano);
        jogador.perderEnergia(2);
        }
    }

    private Municao acharMun(Personagem jogador, Arma arma){
        String nomeMunicaoEsperada = null;
        switch (arma.getQual()){
            case ARCO:
                nomeMunicaoEsperada = "Flechas";
                break;
            case PISTOLA:
                nomeMunicaoEsperada = "Balas";
                break;
            default:
                System.out.println("Arma incompativel com municao.");
        }
        if(nomeMunicaoEsperada == null){return null;}

        for(Item item : jogador.getInventario().getItens()){
            if (item instanceof Municao){
                Municao municaoEncontrada = (Municao) item;
                if (municaoEncontrada.getNome().equalsIgnoreCase(nomeMunicaoEsperada) && municaoEncontrada.getQuantiaAtual() > 0){
                    return municaoEncontrada; //encontrou municao para a arma equipada
                }
            }
        }
        return null; //municao correspondente nao encontrada
    }

    private void acaoInimigo(){
        System.out.println(inimigo.getNome() + " infligiu " + inimigo.getDano() + " de dano.");
        jogador.setVida(jogador.getVida() - inimigo.getDano());
        //SE TIVER, EFEITO DO INIMIGO SOBRE O PERSONAGEM (VENENO, FRATURA, ETC.)
    }

    private void exibirEstados(){
        System.out.println("");
        System.out.println(jogador.getNome() + ": ");
        System.out.println("Vida: " + jogador.getVida() + "; Energia: " + jogador.getEnergia());
        System.out.println("");
        System.out.println(inimigo.getNome() + ": ");
        System.out.println("Vida: " + inimigo.getVida());
        System.out.println("============================================================");
        Arma arma = jogador.getArmaEquipada();
        if(arma != null){
            System.out.println("Arma equipada: " + arma.getNome());
        } else{
            System.out.println("Vai ganhar na mao?");
        }
        System.out.println("============================================================");
    }
}