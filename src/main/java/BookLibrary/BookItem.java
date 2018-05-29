package BookLibrary;

/**
 * Created by pdabr on 5/29/2018.
 */
public class BookItem extends Book {
    private static long idCounter = 0;
    private String Id;
    private String borrowerName = "";

    public BookItem(String title, String author, int year) {
        super(title, author, year);
        this.Id = generateID();
    }


    private static String generateID() {
        return String.valueOf(idCounter++);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "Id='" + Id + '\'' +
                "title='" + super.getTitle() + '\'' +
                ", author='" + super.getAuthor() + '\'' +
                ", year=" + super.getYear() + '\'' +
                ", available=" + this.itsAvailable() + '}';
    }

    public String getId() {
        return Id;
    }

    public boolean itsAvailable() {
        return borrowerName.isEmpty();
    }

    public boolean lendBook(String borrowerName) {
        if (this.itsAvailable() && !borrowerName.isEmpty()) {
            this.borrowerName = borrowerName;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!this.itsAvailable()) {
            this.borrowerName = "";
            return true;
        }
        return false;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}
