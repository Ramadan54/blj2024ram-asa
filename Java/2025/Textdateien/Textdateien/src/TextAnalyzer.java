import java.io.File;

public class TextAnalyzer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Geben Sie bitte eine Textdatei ein.");
            return;
        }

        String filepath = args[0];
        File inputFile = new File(filepath);
        if (!inputFile.exists()) {
            System.out.println("Die Datei existiert nicht oder ist ungültig.");
            return;
        }

    }
}