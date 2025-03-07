public class Media {

    //Atribute
    private String name;
    private int year;
    private String language;

    //Constructor
    public Media(String name, int year, String language) {
        this.name = name;
        this.year = year;
        this.language = language;
    }

    //Geter-Methode für die Attribute
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    //Ausgeben der Informationen
    public void printInfo() {
        System.out.println("name: " + name);
        System.out.println("year: " + year);
        System.out.println("language: " + language);
    }

}