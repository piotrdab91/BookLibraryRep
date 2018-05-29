package BookLibrary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pdabr on 5/29/2018.
 */
public class Library {
    private Map<Book, List<BookItem>> bookStorage = new HashMap<>();

    public void addBook(final BookItem bookItem) {
        List<BookItem> ItemBookList = null;
        Book book = new Book(bookItem.getTitle(), bookItem.getAuthor(), bookItem.getYear());
        if (!this.bookStorage.containsKey(book)) {
            ItemBookList = new LinkedList<BookItem>() {{
                add(bookItem);
            }};
            ;
            bookStorage.put(book, ItemBookList);
        } else {
            ItemBookList = bookStorage.get(book);
            ItemBookList.add(bookItem);
        }
    }

    public Map<Book, List<BookItem>> getBookStorage() {
        return bookStorage;
    }
}
