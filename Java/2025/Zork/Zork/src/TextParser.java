public class TextParser {
    public Command parse(String inputLine) {
        String[] words = inputLine.trim().split("\\s+", 2);
        String verb = words[0];
        String noun = words.length > 1 ? words[1] : "";
        return new Command(verb, noun);
    }
}
