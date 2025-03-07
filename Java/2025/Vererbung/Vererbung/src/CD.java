import java.util.ArrayList;

public class CD extends Media {

    private String artist;
    private ArrayList<String> songs;

    public CD(String artist, ArrayList<String> songs, String name, int year, String language) {
        super(name, year, language);
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("artist: " + artist);
        System.out.println("songs: " + songs);
    }
}