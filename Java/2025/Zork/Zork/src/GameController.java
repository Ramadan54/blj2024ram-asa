import java.util.*;

public class GameController {
    private Player player;
    private Room currentRoom;
    private TextParser parser;

    public GameController() {
        parser = new TextParser();
        initWorld();
    }

    private void initWorld() {
    }

    public void start() {
        System.out.println("Willkommen in Zork-like!");
        while (true) {
            System.out.println(currentRoom.getLongDescription());
            String input = player.getInput();  // oder Scanner in GameController
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

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void endGame() {
        System.out.println("Spiel beendet.");
        System.exit(0);
    }
}
