//FABRICAR
import java.util.*;

public class Inventario{
    private final List<Item> inventario = new ArrayList<>();
    private final int capacidadeMax;

    public Inventario(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public List<Item> getItens(){
        return inventario;
    }

    public void exibirItensID(){
        for (Item item : inventario){
            System.out.println(item.getNome() + " (ID: " + item.getID() + ")");
        }
    }

    public Material getItemPorID(String ID){
        for (Item item : inventario) {
            if (item instanceof Material && ID.equals(item.getID())){
                return (Material) item;
            }
        }
        System.out.println("Item não encontrado pela ID (getItemPorID, Inventario.java). Item de erro retornado.");
        return null;
    }


    public boolean verificarItemInventario(String ID){
        for (Item item : inventario){
            if (Objects.equals(ID, item.getID())){
                return true;
            }
        }
        System.out.println("Item de ID " + ID + " não consta no inventário.");
        return false;
    }

    public void adicionarItem(Item item){
        int pesoAtual = calcularPesoAtual();

        if (pesoAtual + item.getPeso() <= this.capacidadeMax) {
            inventario.add(item);
            ordenarItensPorNome();
        } else {
            System.out.println("Seu inventário está cheio!");
        }
    }

    private int calcularPesoAtual(){
        int total = 0;
        for (Item i : inventario) {
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
