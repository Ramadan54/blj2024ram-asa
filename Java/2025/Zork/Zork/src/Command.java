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
                break;
            case "use":
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
