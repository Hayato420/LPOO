public class Alimento extends Item{
//EXEMPLO DE CRIAÇÃO DE ALIMENTO: Alimento maca = Alimento.TipoAlimento.MACA.criarAlimento(geradorDeID);
//MESMA ESTRUTURA DE MATERIAL
    private int prazoDeValidade;
    private boolean apodrecido;

    private final TipoAlimento tipoAlimento;
    public enum TipoAlimento{
        MACA("Maçã", "Vermelha e meio acida.", 1, 1, 5, false, 10),
        LARANJA("Laranja", "O que veio primeiro, a cor ou a fruta?", 1, 1, 5, false, 12),
        PERA("Pera", "Nao e uma maca.", 1, 1, 7, false, 9),
        CARNEIROASSADO("Carneiro assado", "Cheira bem.", 2, 1, 3, false, 33),
        FRANGOASSADO("Frango assado", "Lava chicken !", 1, 1, 3, false, 33),
        CARNEIROCRU("Carneiro cru", "Cheira mal.", 2, 1, 2, false, 5),
        FRANGOCRU("Frango cru", "Melhor assar logo.", 1, 1, 2, false, 5),
        SARDINHASENLATADAS("Sardinhas enlatadas", "Omega 3", 1, 1, 1000, false, 25),
        CARNEENLATADA("Carne enlatada", "Amalgama emulsificada de cadaveres.", 1, 1, 1000, false, 20),
        FEIJOADAENLATADA("Feijoada enlatada", "Feijao e carne.", 1, 1, 1000, false, 25),
        BISCOITOS("Biscoitos", "Doce ou salgado?", 1, 1, 10, false, 30),
        PAO("Pao", "Farinha e fermento", 1, 1, 3, false, 20),
        BOLACHAS("Bolachas", "Salgada ou doce?", 1, 1, 10, false, 30),
        COELHOCRU("Coelho cru", "Nao mais saltitante.", 2, 1, 2, false, 10),
        COELHOASSADO("Coelho assado", "Bro is cooked.", 2, 1, 5, false, 30);

        private final String nome;
        private final String descricao;
        private final int peso;
        private final int durabilidade;
        @SuppressWarnings("FieldMayBeFinal")
        private int prazoDeValidade;
        @SuppressWarnings("FieldMayBeFinal")
        private boolean apodrecido;
        private final int valorNutricional;

        TipoAlimento(String nome, String descricao, int peso, int durabilidade, int prazoDeValidade, 
                     boolean apodrecido, int valorNutricional){
            this.nome = nome;
            this.descricao = descricao;
            this.peso = peso;
            this.durabilidade = durabilidade;
            this.prazoDeValidade = prazoDeValidade;
            this.apodrecido = apodrecido;
            this.valorNutricional = valorNutricional;
        }

        public Alimento criarAlimento(GeradorDeID geradorDeID){
            switch (this){
                case MACA:
                    return new Maca(geradorDeID);
                case LARANJA:
                    return new Laranja(geradorDeID);
                case PERA:
                    return new Pera(geradorDeID);
                case CARNEIROASSADO:
                    return new CarneiroAssado(geradorDeID);
                case FRANGOASSADO:
                    return new FrangoAssado(geradorDeID);
                case CARNEIROCRU:
                    return new CarneiroCru(geradorDeID);
                case FRANGOCRU:
                    return new FrangoCru(geradorDeID);
                case SARDINHASENLATADAS:
                    return new SardinhasEnlatadas(geradorDeID);
                case CARNEENLATADA:
                    return new CarneEnlatada(geradorDeID);
                case FEIJOADAENLATADA:
                    return new FeijoadaEnlatada(geradorDeID);
                case BISCOITOS:
                    return new Biscoitos(geradorDeID);
                case PAO:
                    return new Pao(geradorDeID);
                case BOLACHAS:
                    return new Bolachas(geradorDeID);
                case COELHOCRU:
                    return new CoelhoCru(geradorDeID);
                case COELHOASSADO: 
                    return new CoelhoAssado(geradorDeID);
                default:
                    throw new IllegalArgumentException("Tipo de alimento não listado: " + this);
            }
        }

        public String getNome(){return this.nome;}
        public String getDescricao(){return this.descricao;}
        public int getPeso(){return this.peso;}
        public int getDurabilidade(){ return this.durabilidade;}
        public int getPrazoDeValidade(){return this.prazoDeValidade;}
        public boolean getApodrecido(){return this.apodrecido;}
        public int getValorNutricional(){return this.valorNutricional;}

    }

    public Alimento (String nome, String descricao, int peso, int durabilidade, GeradorDeID geradorDeID, TipoAlimento tipoAlimento){
        super(nome, descricao, peso, durabilidade, geradorDeID);
        this.tipoAlimento = tipoAlimento;
        this.prazoDeValidade = tipoAlimento.getPrazoDeValidade();
        this.apodrecido = false;
    }

    //getter da classe, usando o getter do enum
    @Override
    public String getNome(){return tipoAlimento.getNome();}
    @Override
    public String getDescricao(){return tipoAlimento.getDescricao();}
    @Override
    public int getPeso(){return tipoAlimento.getPeso();}
    @Override
    public int getDurabilidade(){return tipoAlimento.getDurabilidade();}
    public int getValorNutricional(){return tipoAlimento.getValorNutricional();}
    public TipoAlimento getTipoAlimento(){return this.tipoAlimento;}

    public int getPrazoDeValidade(){
        return this.prazoDeValidade;
    }

    public void aumentarValidade(int quantidade){
        this.prazoDeValidade += quantidade;
    }

    public boolean getApodrecido(){
        return this.apodrecido;
    }

    public void apodrecer(){
        this.prazoDeValidade -= 1;
        if (this.prazoDeValidade <= 0 && this.apodrecido == false){
            this.apodrecido = true;
            System.out.printf("O alimento %s apodreceu.\n", this.getNome());
        }
    }

    @Override
    public void usar(Personagem jogador){
            if(this.getApodrecido() == false){
                jogador.adicionarFome(this.getValorNutricional());
                jogador.getInventario().removerItem(this.getID());
            }
            else{
                jogador.adicionarFome(this.getValorNutricional()/2);
                jogador.perderVida(15);
                jogador.getInventario().removerItem(this.getID());
            }
        }
}