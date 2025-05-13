import java.util.ArrayList;
import java.util.List;

public class Status{
    private final int TURNOS_MAX_STATUS = 3; //para encharcamento, insolacao, status que passam com o tempo

    private boolean iluminado; //diz se o personagem esta proximo a fonte de luz, para CAVERNA
    private boolean envenenado;
    private boolean doente;
    private int encharcamento;
    private int insolacao;
    private Temperatura temperatura;
    public enum Temperatura{
        CALOR,
        NORMAL,
        FRIO
    }
    private boolean pertoDeFonteDeCalor; //deve estabilizar temperatura se FRIO e eliminar encharcamento
    private boolean pertoDeFogo; //deve ativar pertoDeFonteDeCalor, deve permitir cozinhar comida


    public Status() {
        this.iluminado = false;
        this.envenenado = false;
        this.doente = false;
        this.encharcamento = 0;
        this.insolacao = 0;
        this.temperatura = Temperatura.NORMAL;
        this.pertoDeFonteDeCalor = false;
        this.pertoDeFogo = false;
    }

    //iluminado
    public boolean isIluminado(){
        return this.iluminado;
    }
    public void setIluminado(boolean estado){
        this.iluminado = estado;
    }

    //Envenamento e Doenca
    public boolean isEnvenenado(){
        return this.envenenado;
    }
    public void setEnvenenado(boolean estado){
        this.envenenado = estado;
    }

    public boolean isDoente(){
        return this.doente;
    }
    public void setDoente(boolean estado){
        this.doente = estado;
    }

    //Encharcamento
    public int getEncharcamento(){
        return this.encharcamento;
    }
    public void redefinirEncharcamento(){
        this.encharcamento = this.TURNOS_MAX_STATUS;
    }
    public void diminuirEncharcamento(int quantidade){
        this.encharcamento = Math.max(0, this.encharcamento - quantidade);
    }

    //Insolacao
    public int getInsolacao(){
        return this.insolacao;
    }
    public void redefinirInsolacao(){
        this.insolacao = this.TURNOS_MAX_STATUS;
    }
    public void diminuirInsolacao(int quantidade){
        this.insolacao = Math.max(0, this.insolacao - quantidade);
    }

    //Temperatura
    public Temperatura getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    //Perto de Fonte de Calor e Fogo
    public boolean isPertoDeFonteDeCalor(){
        return this.pertoDeFonteDeCalor;
    } 
    public void setPertoDeFonteDeCalor(boolean perto) {
        this.pertoDeFonteDeCalor = perto;
    }

    public boolean isPertoDeFogo(){
        return this.pertoDeFogo;
    }
    public void setPertoDeFogo(boolean perto) {
        this.pertoDeFogo = perto;
    }
    
    public String exibirStatus() {
        List<String> statusAtivos = new ArrayList<>();
    
        if (iluminado) statusAtivos.add("iluminado");
        if (envenenado) statusAtivos.add("envenenado");
        if (doente) statusAtivos.add("doente");
        if (encharcamento > 0) statusAtivos.add("encharcado");
        if (insolacao > 0) statusAtivos.add("insolado");
    
        //Normal so sera exibido se nao houver nenhum outro status
        switch (temperatura) {
            case CALOR -> statusAtivos.add("com temperatura quente");
            case FRIO -> statusAtivos.add("com temperatura fria");
            case NORMAL -> {
                if (statusAtivos.isEmpty()) statusAtivos.add("com temperatura normal");
            }
        }
    
        return String.join(", ", statusAtivos)      //junta todos os status com ", "
        .replaceAll(",([^,]*)$", " e$1") + ".";     //substitui a ultima ", " por um " e " para deixar a formatacao mais organizada
    }

}
