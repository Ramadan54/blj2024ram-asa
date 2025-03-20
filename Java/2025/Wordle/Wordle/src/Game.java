import java.io.IOException;
import java.util.Scanner;

public class Game {
    private final Fields fields = new Fields();
    private final Scanner scanner = new Scanner(System.in);
    private boolean playAgain = true;

    public void start() {
        System.out.println("Willkommen beim Wordle Game!\n");

        while (playAgain) {
            try {
                fields.loadWords("wordlist.txt");
                fields.selectRandomWord();

                int attempts = 6;
                boolean guessed = false;

                while (attempts > 0 && !guessed) {
                    System.out.print("Gib ein 5 Buchstaben langes Wort ein: ");
                    String guess = scanner.nextLine().toUpperCase();

                    if (!fields.isValidGuess(guess)) {
                        System.out.println("Ungültiges Wort. Bitte gib ein 5 Buchstaben Wort aus der Liste ein.\n");
                        continue;
                    }

                    guessed = fields.checkGuess(guess);
                    attempts--;

                    if (guessed) {
                        System.out.println("Glückwunsch! Du hast das Wort erraten.");
                    } else {
                        System.out.println("Verbleibende Versuche: " + attempts + "\n");
                    }
                }

                if (!guessed) {
                    System.out.println("Leider verloren! Das gesuchte Wort war: " + fields.getTargetWord());
                }

            } catch (IOException e) {
                System.out.println("Fehler beim Laden der Wortliste: " + e.getMessage());
            }
            System.out.print("\nMöchtest du nochmal spielen? (ja/nein): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("ja")) {
                playAgain = false;
                System.out.println("\nDanke fürs Spielen! Bis zum nächsten Mal!");
            }
        }
    }
}