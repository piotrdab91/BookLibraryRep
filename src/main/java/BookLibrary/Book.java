package BookLibrary;

/**
 * Created by pdabr on 5/28/2018.
 */
public class Book {
    private String title;
    private int year;
    private String authorFirstName;
    private String authorLastName;

    public Book(String title, int year, String authorFirstName, String authorLastName) {
        this.title = title;
        this.year = year;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
}

