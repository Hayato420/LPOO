import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class GeradorDeID{
    private final Set<String> historicoDeIDs = new HashSet<>();

    public synchronized String gerarIDExclusiva() {
        String ID;
        do{
            ID = String.valueOf(ThreadLocalRandom.current().nextInt(10000, 100000));
        } while (!historicoDeIDs.add(ID));
        return ID;
    }
}