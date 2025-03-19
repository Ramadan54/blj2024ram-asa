
import java.util.Scanner;

public class Game {
    private Fields fields;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        fields = new Fields();
    }

    public void start() {
        System.out.println("Hello and welcome to the Game Wordle!\n");
    }
}