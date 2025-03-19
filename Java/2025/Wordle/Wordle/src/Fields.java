import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Fields {
    private List<String> words = new ArrayList<>();
    private String secretWord;

    public void loadWords(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            line = line.trim().toUpperCase();
            if (line.matches("[A-Z]{5}")) {
                words.add(line);
            }
        }
    }
}
