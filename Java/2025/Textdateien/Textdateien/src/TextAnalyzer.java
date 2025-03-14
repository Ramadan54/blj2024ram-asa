import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TextAnalyzer {

    // Methode zur Analyse eines Textes und Rückgabe der Wortstatistik als Map
    public Map<String, Integer> analyzeText(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();
        // Wörter extrahieren (hier als Beispiel über einfache Regex)
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (word.isEmpty()) continue;
            // Umwandlung in Kleinbuchstaben, um "Wort" und "wort" gleich zu behandeln
            word = word.toLowerCase();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }

    // Ermittelt das meistvorkommende Wort
    public String getMostCommonWord(Map<String, Integer> wordCounts) {
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;
    }

    // Formatierung des Ergebnisses als String
    public String formatResults(String originalFileName, Map<String, Integer> wordCounts) {
        int uniqueWords = wordCounts.size();
        int totalWords = wordCounts.values().stream().mapToInt(Integer::intValue).sum();
        String mostCommon = getMostCommonWord(wordCounts);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = dtf.format(LocalDateTime.now());

        StringBuilder sb = new StringBuilder();
        sb.append(dateTime).append(" ").append(originalFileName).append("\n");
        sb.append("--------------------------------------------\n");
        sb.append("Number of unique words:\t").append(uniqueWords).append("\n");
        sb.append("Total number of words:\t").append(totalWords).append("\n");
        sb.append("Most common word:\t").append(mostCommon).append("\n");
        sb.append("--------------------------------------------\n");

        // Wörter und deren Anzahl sortiert (z.B. alphabetisch)
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> sb.append(entry.getKey()).append("\t").append(entry.getValue()).append("\n"));

        return sb.toString();
    }
}