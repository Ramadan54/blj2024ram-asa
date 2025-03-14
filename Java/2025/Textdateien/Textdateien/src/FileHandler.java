import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    // Liest den gesamten Inhalt einer Textdatei ein
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Schreibt den Ergebnis-String in eine Datei
    public void writeFile(String originalFilePath, String content) throws IOException {
        Path originalPath = Paths.get(originalFilePath);
        String fileName = originalPath.getFileName().toString();
        String newFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "_evaluation.txt";
        Path newPath = originalPath.resolveSibling(newFileName);
        Files.write(newPath, content.getBytes());
    }
}