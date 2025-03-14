import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;

        if (args.length < 1) {
            System.out.println("Bitte geben Sie den Pfad zur Textdatei an:");
            filePath = scanner.nextLine();
        } else {
            filePath = args[0];
        }

        FileHandler fileHandler = new FileHandler();
        TextAnalyzer analyzer = new TextAnalyzer();

        try {
            String text = fileHandler.readFile(filePath);
            Map<String, Integer> wordCounts = analyzer.analyzeText(text);
            String result = analyzer.formatResults(Paths.get(filePath).getFileName().toString(), wordCounts);
            fileHandler.writeFile(filePath, result);
            System.out.println("Auswertung erfolgreich erstellt.");
        } catch (IOException e) {
            System.err.println("Fehler beim Verarbeiten der Datei: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
