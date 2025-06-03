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
    private boolean pertoDeFonteDeAgua; //deve permitir encher garrafas


    public Status(){
        this.iluminado = false;
        this.envenenado = false;
        this.doente = false;
        this.perturbado = false;
        this.fraturado = false;
        this.temperatura = Temperatura.NORMAL;
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

    //Agua
    public boolean isPertoDeFonteDeAgua(){
        return this.pertoDeFonteDeAgua;
    } 
    public void setPertoDeFonteDeAgua(boolean perto){
        this.pertoDeFonteDeAgua = perto;
    }
    
    public String exibirStatus() {
        List<String> statusAtivos = new ArrayList<>();

        if (iluminado) statusAtivos.add("iluminado");
        if (envenenado) statusAtivos.add("envenenado");
        if (doente) statusAtivos.add("doente");
        if (perturbado) statusAtivos.add("perturbado");
        if (fraturado) statusAtivos.add("fraturado");

        switch (temperatura){
            case CALOR:
                statusAtivos.add("com calor");
                break;
            case FRIO:
                statusAtivos.add("com hipotermia");
                break;
            case NORMAL:
                if (statusAtivos.isEmpty()) {
                    statusAtivos.add("Estavel");
                } else {
                    statusAtivos.add("com temperatura normal");
                }
                break;
        }


        String statusFinal = String.join(", ", statusAtivos)
            .replaceAll(",([^,]*)$", " e$1") + ".";

        return "Status: " + statusFinal;
    }
}