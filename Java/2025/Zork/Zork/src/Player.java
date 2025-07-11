import java.util.Scanner;

public class Player {
    private String name;
    private int health = 100;
    private Inventory inventory = new Inventory();
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
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
        if (it == null) {
            it = room.getItem(itemName);
            if (it == null) {
                System.out.println("Du siehst hier keinen " + itemName + ".");
                return;
            }
        }
        it.use(this, room);
    }

    public String getInput() {
        System.out.print("> ");
        return scanner.nextLine();
    }
}