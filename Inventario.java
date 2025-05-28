//FABRICAR
import java.util.*;

public class Inventario{
    private final List<Item> inventario = new ArrayList<>();
    private final int capacidadeMax;

    public Inventario(int capacidadeMax){
        this.capacidadeMax = capacidadeMax;
    }

    public List<Item> getItens(){
        return inventario;
    }

    public void exibirItens(){
        List<Item> itens = this.getItens();
        for (Item item : itens){
            System.out.println(item.getNome() + ": ");
            System.out.println("ID — " + item.getID());
            System.out.println("Descricao — " + item.getDescricao());
            System.out.println("Peso — " + item.getPeso());
            System.out.println("Durabilidade — " + item.getDurabilidade());
            System.out.println("Tipo — " + item.getClass().getSimpleName());
            System.out.println();
        }
        System.out.println("Peso total do inventario: " + calcularPesoAtual());
    }

    public Material getItemPorID(String ID){
        for (Item item : inventario) {
            if (item instanceof Material && ID.equals(item.getID())){
                return (Material) item;
            }
        }
        System.out.println("Item nao encontrado pela ID (getItemPorID, Inventario.java). Item de erro retornado.");
        return null;
    }


    public boolean verificarItemInventario(String ID){
        for (Item item : inventario){
            if (Objects.equals(ID, item.getID())){
                return true;
            }
        }
        System.out.println("Item de ID " + ID + " nao consta no inventario.");
        return false;
    }

    public boolean adicionarItem(Item item){
        int pesoAtual = calcularPesoAtual();

        if (pesoAtual + item.getPeso() <= this.capacidadeMax){
            inventario.add(item);
            ordenarItensPorNome();
            return true;
        } else{
            System.out.println("Seu inventario esta cheio!");
            return false;
        }
    }

    private int calcularPesoAtual(){
        int total = 0;
        for (Item i : inventario){
            total += i.getPeso();
        }
        return total;
    }    

    //remove um item com base na sua ID
    public void removerItem(String ID){
        Iterator<Item> iterator = inventario.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getID().equals(ID)){
                iterator.remove();
                System.out.println("Item " + item.getNome() + " removido.");
                ordenarItensPorNome();
                return;
            }
        }
        System.out.println("Item com ID " + ID + " não encontrado.");
    }

    private void ordenarItensPorNome(){
        inventario.sort(Comparator.comparing(Item::getNome, String.CASE_INSENSITIVE_ORDER));
    }
}
