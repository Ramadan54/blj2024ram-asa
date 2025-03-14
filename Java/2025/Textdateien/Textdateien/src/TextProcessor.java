import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    private final File inputFile;
    private final Map<String, Integer> wordCount = new HashMap<>();
    private int totalWordCount = 0;

    public TextProcessor(String filepath) {
        this.inputFile = new File(filepath);
    }
}