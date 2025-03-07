import java.util.ArrayList;

//Atribute
public class film extends Media{
    private ArrayList<String> actors;
    private int AgeRating;

    //Constructor
    public film(ArrayList<String> actors, int AgeRating, String name, int year, String language) {
        super(name,year,language);
        this.actors = actors;
        this.AgeRating = AgeRating;
    }
    public ArrayList<String> getActors() {
        return actors;
    }
    public int ageRating() {
        return AgeRating;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("actors: " + actors);
        System.out.println("AgeRating: " + AgeRating);
    }
}