import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Fields {
    private final List<String> words = new ArrayList<>();
    private String targetWord;

    public void loadWords(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            line = line.trim().toUpperCase();
            if (line.matches("[A-Z]{5}")) {
                words.add(line);
            }
        }
        if (words.isEmpty()) {
            throw new IOException("Wortliste ist leer oder ungültig.");
        }
    }

    public void selectRandomWord() {
        Random rand = new Random();
        targetWord = words.get(rand.nextInt(words.size()));

    }

    public boolean isValidGuess(String guess) {
        return guess.length() == 5 && guess.matches("[A-Z]+");
    }

    public boolean checkGuess(String guess) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char g = guess.charAt(i);
            if (g == targetWord.charAt(i)) {
                result.append("\u001B[32m").append(g).append("\u001B[0m"); //Green
            } else if (targetWord.contains(String.valueOf(g))) {
                result.append("\u001B[33m").append(g).append("\u001B[0m"); //Yellow
            } else {
                result.append("\u001B[37m").append(g).append("\u001B[0m"); //White
            }
        }

        System.out.println(result);
        return guess.equals(targetWord);
    }

    public String getTargetWord() {
        return targetWord;
    }
}
