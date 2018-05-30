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
                ", available=" + this.itsAvailable() +
                ", borrowerName:" + this.getBorrowerName() + '}';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BookItem bookItem = (BookItem) o;

        return Id != null ? Id.equals(bookItem.Id) : bookItem.Id == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Id != null ? Id.hashCode() : 0);
        return result;
    }
}
