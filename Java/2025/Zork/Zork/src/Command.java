public class Command {
    private String verb;
    private String noun;

    public Command(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public boolean execute(GameController controller) {
        switch (verb.toLowerCase()) {
            case "go":
                Room next = controller.getCurrentRoom().getExit(noun);
                if (next != null) {
                    controller.setCurrentRoom(next);
                } else {
                    System.out.println("Dahin kannst du nicht gehen.");
                }
                break;
            case "take":
                Item item = controller.getCurrentRoom().getItem(noun);
                if (item != null) {
                    controller.getPlayer().take(item, controller.getCurrentRoom());
                } else {
                    System.out.println("Das kannst du hier nicht nehmen.");
                }
                break;
            case "use":
                controller.getPlayer().use(noun, controller.getCurrentRoom());
                break;
            case "quit":
                controller.endGame();
                return false;
            default:
                System.out.println("Unbekannter Befehl: " + verb);
        }
        return true;
    }
}