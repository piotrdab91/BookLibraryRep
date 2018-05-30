package BookLibrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 Testing Requirements
 */
public class AppTest {
    //Library Contains a Book for Lend to lend (at the beginning there are no books in the library)
    @Test
    public void ad1_NewLibraryIsEmpty() {
        Library lib = new Library();
        assertTrue(lib.getBookStorage().isEmpty());

    }

    @Test
    public void ad1_LibararyContainsAddedBooks() {
        Library lib = new Library();
        BookItem bookIt_1 = new BookItem("Potop", "Henryk Sienkiewcz", 1974);
        BookItem bookIt_2 = new BookItem("Potop", "Henryk Sienkiewcz", 1989);
        BookItem bookIt_3 = new BookItem("1984", "Orwell", 2015);
        BookItem bookIt_4 = new BookItem("Hamlet", "William Shakespear", 1980);
        BookItem bookIt_5 = new BookItem("Hamlet", "William Shakespear", 1980);
        BookItem bookIt_6 = new BookItem("Hamlet", "William Shakespear", 1980);
        lib.addBook(bookIt_1);
        lib.addBook(bookIt_2);
        lib.addBook(bookIt_3);
        lib.addBook(bookIt_4);
        lib.addBook(bookIt_5);
        lib.addBook(bookIt_6);
        lib.listAllBooks();
        assertEquals(2, lib.findBook("Potop").size());
    }

}
