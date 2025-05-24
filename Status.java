import java.util.ArrayList;
import java.util.List;

public class Status{ 
    private boolean iluminado; //diz se o personagem esta proximo a fonte de luz, para CAVERNA
    private boolean envenenado;
    private boolean doente;
    private boolean perturbado;
    private boolean fraturado;
    private Temperatura temperatura;
    public enum Temperatura{
        CALOR, //custa mais energia para se mover se nao beber agua
        NORMAL,
        FRIO //custa mais energia para se mover se nao beber esquentar-se
    }
    private boolean pertoDeFonteDeCalor; //deve estabilizar temperatura se FRIO
    private boolean pertoDeFonteDeAgua; //deve permitir encher garrafas
    private boolean pertoDeFogo; //deve ativar pertoDeFonteDeCalor, deve permitir cozinhar comida


    public Status(){
        this.iluminado = false;
        this.envenenado = false;
        this.doente = false;
        this.perturbado = false;
        this.fraturado = false;
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

    //Envenenamento, Doenca, Perturbacao e Fraturamento
    //VENENO
    public boolean isEnvenenado(){
        return this.envenenado;
    }
    public void setEnvenenado(boolean estado){
        this.envenenado = estado;
    }
    //DOENCA
    public boolean isDoente(){
        return this.doente;
    }
    public void setDoente(boolean estado){
        this.doente = estado;
    }
    //PERTURBACAO
    public boolean isPerturbado(){
        return this.perturbado;
    }
    public void setPerturbado(boolean estado){
        this.perturbado = estado;
    }
    //FRATURAMENTO
    public boolean isFraturado(){
        return this.fraturado;
    }
    public void setFraturado(boolean estado){
        this.fraturado = estado;
    }

    //Temperatura
    public Temperatura getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(Temperatura temperatura){
        this.temperatura = temperatura;
    }

    //Perto de Fonte de Calor, Agua e Fogo
    public boolean isPertoDeFonteDeCalor(){
        return this.pertoDeFonteDeCalor;
    } 
    public void setPertoDeFonteDeCalor(boolean perto){
        this.pertoDeFonteDeCalor = perto;
    }

    public boolean isPertoDeFonteDeAgua(){
        return this.pertoDeFonteDeAgua;
    } 
    public void setPertoDeFonteDeAgua(boolean perto){
        this.pertoDeFonteDeAgua = perto;
    }

    public boolean isPertoDeFogo(){
        return this.pertoDeFogo;
    }
    public void setPertoDeFogo(boolean perto){
        this.pertoDeFogo = perto;
    }
    
    public String exibirStatus(){
        List<String> statusAtivos = new ArrayList<>();

        if (iluminado) statusAtivos.add("iluminado");
        if (envenenado) statusAtivos.add("envenenado");
        if (doente) statusAtivos.add("doente");
        if (perturbado) statusAtivos.add("perturbado");
        if (fraturado) statusAtivos.add("fraturado");

        //Normal so sera exibido se nao houver nenhum outro status
        switch (temperatura){
            case CALOR -> statusAtivos.add("com calor");
            case FRIO -> statusAtivos.add("com hipotermia");
            case NORMAL -> {
                if(statusAtivos.isEmpty()){statusAtivos.add("Estavel");}
                else{statusAtivos.add("e com temperatura normal");}
            }
        }
    
        return String.join(", ", statusAtivos)      //junta todos os status com ", "
        .replaceAll(",([^,]*)$", " e$1") + ".";     //substitui a ultima ", " por um " e " para deixar a formatacao mais organizada
    }
}
