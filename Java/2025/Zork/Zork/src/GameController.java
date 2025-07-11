import java.util.Scanner;

public class GameController {
    private Player player;
    private Room currentRoom;
    private TextParser parser;

    public GameController() {
        parser = new TextParser();
        initWorld();
    }

    private void initWorld() {
        Room houseFront = new Room("West of House",
                "Du stehst vor einem weißen Haus mit verbarrikadierter Tür. Hier steht ein kleiner Briefkasten.");
        Room insideHouse = new Room("Inside House",
                "Du bist im Wohnzimmer des Hauses. Es riecht nach Abenteuer.");

        houseFront.setExit("east", insideHouse);
        insideHouse.setExit("west", houseFront);

        Item mailbox = new Item("mailbox", "Ein kleiner Briefkasten.") {
            private boolean opened = false;

            @Override
            public void use(Player player, Room room) {
                if (!opened) {
                    opened = true;
                    System.out.println("Du öffnest den Briefkasten und findest ein Leaflet.");
                    room.addItem(new Item("leaflet", "Ein Blatt Papier mit dem Titel 'WELCOME TO ZORK!'"));
                } else {
                    System.out.println("Der Briefkasten ist bereits offen.");
                }
            }
        };

        houseFront.addItem(mailbox);
        currentRoom = houseFront;
        player = new Player("Held");
    }

    public void start() {
        System.out.println("Willkommen in Zork-like!");
        while (true) {
            System.out.println(currentRoom.getLongDescription());
            String input = player.getInput();
            if (!processInput(input)) break;
        }
    }

    private boolean processInput(String input) {
        Command cmd = parser.parse(input);
        return cmd.execute(this);
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void endGame() {
        System.out.println("Spiel beendet.");
        System.exit(0);
    }
}