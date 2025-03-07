import java.util.ArrayList;
import java.util.Arrays;

public class MediaCollection {
    public static void main(String[] args) {

        Media book = new book("Friedrich Dürrenmatt", 120, "Der Verdacht", 1953, "German");
        Media film = new film(new ArrayList<String>(Arrays.asList("Vin Diesel", "Paul Walker")), 12, "fast and furious", 2009, "English");
        Media game = new game(true, "Ubisoft Anvil", "assassin's creed", 2007, "English");
        Media cd = new CD("The Beatles", new ArrayList<String>(Arrays.asList("Help", "Yesterday")), "Help", 1965, "English");


        System.out.print("    Media Collection \n");
        System.out.println("__________________________\n");
        System.out.println("---Book----------\n");
        book.printInfo();
        System.out.println("---Film----------\n");
        film.printInfo();
        System.out.println("---Game----------\n");
        game.printInfo();
        System.out.println("---CD------------\n");
        cd.printInfo();
    }
}