package library;

public class Books {

    private String title;
    private String author;
    private int year;
    private int pages;

    public Books(String Title, String Author, int Year, int Pages){
        this.title=Title;
        this.author = Author;
        this.year=Year;
        this.pages=Pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }
}
