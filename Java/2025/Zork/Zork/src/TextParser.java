public class TextParser {
    public Command parse(String inputLine) {
        String[] words = inputLine.trim().split("\\s+", 2);
        String verb = words[0];
        String noun = words.length > 1 ? words[1] : "";


        if (verb.matches("north|south|east|west|up|down")) {
            noun = verb;
            verb = "go";
        }

        return new Command(verb, noun);
    }
}
