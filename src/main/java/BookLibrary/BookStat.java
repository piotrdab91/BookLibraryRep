package BookLibrary;

/**
 * Created by pdabr on 5/30/2018.
 */
public class BookStat {
    private Book book;
    private int numberOfItems;
    private int numberOfAvailable;

    public BookStat(Book book, int numberOfItems, int numberOfAvailable) {
        this.book = book;
        this.numberOfItems = numberOfItems;
        this.numberOfAvailable = numberOfAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title:" + book.getTitle() +
                ", Author:" + book.getAuthor() +
                ", Year: " + book.getYear() +
                ", Number Of Books=" + numberOfItems +
                ", Number Of Available Books=" + numberOfAvailable +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfAvailable() {
        return numberOfAvailable;
    }

    public void setNumberOfAvailable(int numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }
}
