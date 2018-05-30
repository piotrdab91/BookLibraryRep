package BookLibrary;

import java.util.*;

/**
 * Created by pdabr on 5/29/2018.
 */
public class Library {
    private Map<Book, List<BookItem>> bookStorage = new HashMap<>();

    public boolean addBook(final BookItem bookItem) {
        List<BookItem> ItemBookList = null;
        Book book = createBookFromBookItem(bookItem);
        if (!libraryContainsBook(book)) {
            ItemBookList = new LinkedList<BookItem>() {{
                add(bookItem);
            }};
            bookStorage.put(book, ItemBookList);
            return true;
        } else {
            ItemBookList = bookStorage.get(book);
            return !ItemBookList.contains(bookItem) && ItemBookList.add(bookItem);

        }
    }

    public Map<Book, List<BookItem>> getBookStorage() {
        return bookStorage;
    }

    private Book createBookFromBookItem(BookItem bookItem) {
        return new Book(bookItem.getTitle(), bookItem.getAuthor(), bookItem.getYear());
    }

    private boolean libraryContainsBook(Book book) {
        return this.bookStorage.containsKey(book);
    }


    public BookItem findBookItem(String id) {
        for (List<BookItem> bookItems : bookStorage.values())
            for (BookItem bi : bookItems)
                if (bi.getId().equals(id))
                    return bi;
        return null;
    }

    public boolean removeBook(String id) {
        BookItem bookItToRemove = findBookItem(id);
        if (bookItToRemove == null)
            return false;
        Book findedBook = createBookFromBookItem(bookItToRemove);
        if (getBookStorage().get(findedBook).size() == 1 && bookItToRemove.itsAvailable()) {
            getBookStorage().get(findedBook).remove(bookItToRemove);
            getBookStorage().remove(findedBook);
            return true;
        }
        return bookItToRemove.itsAvailable() && getBookStorage().get(findedBook).remove(bookItToRemove);
    }

    private List<BookStat> generateBookStatList() {
        List<BookStat> BooksStatsList = new LinkedList<>();
        BookStat bookStat;
        for (Book book : bookStorage.keySet()) {
            bookStat = new BookStat(book, this.bookStorage.get(book).size(), (int) this.bookStorage.get(book).stream().filter(p -> p.itsAvailable()).count());
            BooksStatsList.add(bookStat);
        }
        return BooksStatsList;
    }

    public void listAllBooks() {
        System.out.println(generateBookStatList().toString());
    }

    public boolean lendBookById(String id, String borrowerName) {
        BookItem bookItemToLend = findBookItem(id);
        return bookItemToLend.lendBook(borrowerName);
    }

    public List<BookItem> findBook(String title, String author, int year) {
        List<Book> bookList = new ArrayList<>();
        boolean matchFlag = false;
        for (Book b : bookStorage.keySet()) {
            if (!title.isEmpty())
                matchFlag = b.getTitle().equals(title);
            if (!author.isEmpty())
                matchFlag = b.getAuthor().equals(author);
            if (!(year == 0))
                matchFlag = b.getYear() == year;
            if (matchFlag)
                bookList.add(b);
        }
        return mergeBookItemsList(bookList);
    }

    public List<BookItem> findBook(String title, String author) {

        return findBook("title", author, 0);
    }

    public List<BookItem> findBook(String title, int year) {

        return findBook("title", "", year);
    }

    public List<BookItem> findBook(String title) {

        return findBook(title, "", 0);
    }

    private List<BookItem> mergeBookItemsList(List<Book> bookList) {
        List<BookItem> result = new ArrayList<>();
        for (Book b : bookList) {
            result.addAll(bookStorage.get(b));
        }
        return result;
    }

    public void showBookItemDetails(int id) {
        BookItem bookIt = findBookItem(String.valueOf(id));
        System.out.println(bookIt.toString());

    }
}
