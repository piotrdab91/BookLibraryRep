package BookLibrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pdabr on 5/29/2018.
 */
public class LibraryTest {

    @Test
    public void addingNewBookShouldAddNewKeyInBookStorage() throws Exception {
        Library lib = new Library();
        BookItem bookItem = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        Book book = new Book(bookItem.getTitle(), bookItem.getAuthor(), bookItem.getYear());
        lib.addBook(bookItem);
        assertTrue(lib.getBookStorage().containsKey(book));
    }

    @Test
    public void addingNewBookShouldAddNewValue() throws Exception {
        Library lib = new Library();
        BookItem bookItem = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        Book book = new Book(bookItem.getTitle(), bookItem.getAuthor(), bookItem.getYear());
        lib.addBook(bookItem);
        assertTrue(lib.getBookStorage().get(book).contains(bookItem));
    }

    @Test
    public void addingTwoTheSameBookItemsShouldAddOneKey() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        assertEquals(1, lib.getBookStorage().size());
    }

    @Test
    public void addingTwoTheSameBookItemsShouldAddTwoValues() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        Book book = new Book("Potop", "Henryk Sienkiewicz", 1974);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        // System.out.println(lib.getBookStorage().entrySet());
        assertEquals(2, lib.getBookStorage().get(book).size());
    }

    @Test
    public void addingTwoTheDifferentBookItemsShouldAddTwoKeys() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        // System.out.println(lib.getBookStorage().entrySet());
        assertEquals(2, lib.getBookStorage().size());
    }
}