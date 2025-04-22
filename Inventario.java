//FABRICAR

import java.util.*;

public class Inventario{
    private List<Item> inventario = new ArrayList<>();
    private int capacidadeMax;

    public Inventario(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public void adicionarItem(Item item){
        int pesoAtual = calcularPesoAtual();

        if (pesoAtual + item.getPeso() <= capacidadeMax) {
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
                System.out.println("Item de ID " + item.getNome() + " removido.");
                ordenarItensPorNome();
                return;
            }
        }
        System.out.println("Item com ID " + ID + " não encontrado.");
    }

    private void ordenarItensPorNome(){
        inventario.sort(Comparator.comparing(Item::getNome, String.CASE_INSENSITIVE_ORDER));
    }

    public void exibirItensID(){
        for (Item item : inventario){
            System.out.println(item.getNome() + " (ID: " + item.getID() + ")");
        }
    }




    //CRAFTING DE ARMAS
    public Arma gerarEspada(int durabilidade){
        return new Arma("Espada", "Uma espada afiada, mas de curta distancia.", 3, durabilidade, Arma.tipoArma.corpoACorpo, Arma.qualArma.ESPADA, 25, 1);
    }

    public Arma gerarArco(int durabilidade){
        return new Arma("Arco", "Um arco de longa distancia.", 2, durabilidade, Arma.tipoArma.aDistancia, Arma.qualArma.ARCO, 15, 3);
    }

    public Arma gerarPistola(){
        return new Arma("Pistola", "Uma pistola potente de longo alcance.", 1, 10000, Arma.tipoArma.aDistancia, Arma.qualArma.PISTOLA, 25, 3);
    }

    //CRAFTING DE FERRAMENTAS
    
}
