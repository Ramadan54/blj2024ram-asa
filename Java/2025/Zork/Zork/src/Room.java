import java.util.*;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getLongDescription() {
        return description
                + "\nExits: " + exits.keySet()
                + "\nItems: " + (items.isEmpty() ? "keine" : items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Item getItem(String itemName) {
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }
}