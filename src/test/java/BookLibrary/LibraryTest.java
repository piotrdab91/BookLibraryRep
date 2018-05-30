package BookLibrary;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void addingNewBookShouldReturnTrue() throws Exception {
        Library lib = new Library();
        assertTrue(lib.addBook("Potop", "Henryk Sienkiewicz", 1974));
    }

    @Test
    public void addingBookWithAlreadyIsInLibShouldReturnFalse() throws Exception {
        Library lib = new Library();
        BookItem bookItem = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        lib.addBook(bookItem);
        assertFalse(lib.addBook(bookItem));
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
    public void addingTwoTheSameBooksShouldAddTwoValues() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        Book book = new Book("Potop", "Henryk Sienkiewicz", 1974);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        //System.out.println(lib.getBookStorage().entrySet());
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

    @Test
    public void findBookItemByIdShouldReturnProperBookIt() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        BookItem findedBook = lib.findBookItem(bookItem_1.getId());
        assertSame(bookItem_1, findedBook);
    }

    @Test
    public void removedBookItShouldNotBeAbleToFind() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.removeBook(bookItem_2.getId());
        System.out.println(lib.getBookStorage().entrySet());
        assertNull(lib.findBookItem(bookItem_2.getId()));
    }

    @Test
    public void removingLastItemofBookShouldRemoveBook() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.removeBook(bookItem_2.getId());
        System.out.println(lib.getBookStorage().entrySet());
        assertEquals(1, lib.getBookStorage().size());
    }

    @Test
    public void removingBookWhichItsNotInLibraryShouldReturnFalse() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.removeBook(bookItem_3.getId());
        assertFalse(lib.removeBook(bookItem_3.getId()));
    }

    @Test
    public void removingBookWhichItsAlreadyLendedShouldReturnFalse() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        bookItem_2.lendBook("Jan Kowalski");
        System.out.println(lib.getBookStorage().entrySet());
        assertFalse(lib.removeBook(bookItem_2.getId()));
    }

    @Test
    public void ListAllBooks() throws Exception {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.addBook(bookItem_3);
        lib.listAllBooks();
    }

    @Test
    public void LendedBookByIdShouldChangeAvailabilityOfProperBoook() {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.addBook(bookItem_3);
        String borrowerName = "Jan Kowlaski";
        lib.lendBookById(bookItem_1.getId(), borrowerName);
        assertFalse(bookItem_1.itsAvailable());
    }

    @Test
    public void LendedBookByIdShouldHaveNewBorroweName() {
        Library lib = new Library();
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.addBook(bookItem_3);
        String borrowerName = "Jan Kowlaski";
        lib.lendBookById(bookItem_1.getId(), borrowerName);
        assertEquals(borrowerName, bookItem_1.getBorrowerName());
    }

    @Test
    public void FindingBooksbByTitleShouldReturnListWithProperSize() {
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 1991);
        BookItem bookItem_4 = new BookItem("Lalka", "Boleslaw Prus", 1947);
        Library lib = new Library();
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.addBook(bookItem_3);
        lib.addBook(bookItem_4);
        System.out.println(lib.findBook("Lalka").toString());
        assertEquals(3, lib.findBook("Lalka").size());
    }

    @Test
    public void FindingBooksbByTitleAndYearShouldReturnListWithProperSize() {
        BookItem bookItem_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1974);
        BookItem bookItem_2 = new BookItem("Lalka", "Boleslaw Prus", 2010);
        BookItem bookItem_3 = new BookItem("Lalka", "Boleslaw Prus", 1991);
        BookItem bookItem_4 = new BookItem("Lalka", "Boleslaw Prus", 1947);
        Library lib = new Library();
        lib.addBook(bookItem_1);
        lib.addBook(bookItem_2);
        lib.addBook(bookItem_3);
        lib.addBook(bookItem_4);
        System.out.println(lib.findBook("Lalka", 1991).toString());
        assertEquals(1, lib.findBook("Lalka", 1991).size());
    }

    @Test
    public void lentBookbyID() {

    }

}