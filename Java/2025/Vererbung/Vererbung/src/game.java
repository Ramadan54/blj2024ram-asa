public class game extends Media{

    //Atribute
    private boolean isMultiplayer;
    private String gameEngine;


    //Constructor
    public game (boolean isMultiplayer, String gameEngine, String name, int year, String language) {
        super(name, year, language);
        this.isMultiplayer = isMultiplayer;
        this.gameEngine = gameEngine;
    }

    public String getAuthor() {
        return gameEngine;
    }

    public boolean getIsMultiplayer() {
        return isMultiplayer;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("isMultiplayer: " + isMultiplayer);
        System.out.println("gameEngine: " + gameEngine);
    }
}
