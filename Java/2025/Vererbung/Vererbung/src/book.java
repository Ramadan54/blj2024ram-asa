public class book extends Media{

    //Atribute
    private String author;
    private int pages;

    //Constructor
    public book(String author, int pages, String name, int year, String language) {
        super(name,year,language);
        this.author = author;
        this.pages = pages;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("author: " + author);
        System.out.println("pages: " + pages);

    }
}
