import java.util.*;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " aufgenommen.");
    }

    public boolean removeItem(Item item) {
        boolean ok = items.remove(item);
        if (ok) System.out.println(item.getName() + " abgelegt.");
        return ok;
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(i -> i.getName().equalsIgnoreCase(itemName));
    }

    public Item getItem(String itemName) {
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventar ist leer.");
        } else {
            System.out.println("Inventar: " + items);
        }
    }
}
