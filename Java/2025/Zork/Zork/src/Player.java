public class Player {
    private String name;
    private int health = 100;
    private Inventory inventory = new Inventory();

    public Player(String name) {
        this.name = name;
    }

    public void moveTo(Room room) {
    }

    public void take(Item item, Room room) {
        if (room.removeItem(item)) {
            inventory.addItem(item);
        } else {
            System.out.println("Kann " + item.getName() + " hier nicht nehmen.");
        }
    }

    public void use(String itemName, Room room) {
        Item it = inventory.getItem(itemName);
        if (it != null) {
            it.use(this, room);
        } else {
            System.out.println("Du hast keinen " + itemName + ".");
        }
    }

    public String getInput() {
        return "";
    }
}
