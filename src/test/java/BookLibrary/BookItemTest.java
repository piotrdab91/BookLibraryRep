package BookLibrary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pdabr on 5/29/2018.
 */
public class BookItemTest {
    @Test
    public void newBookItemShouldBeAvailable() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        assertTrue(bi.itsAvailable());
    }

    @Test
    public void newBookShouldHaveEmptyStringAsBorroweName() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        assertTrue(bi.getBorrowerName().isEmpty());
    }

    @Test
    public void lendedBookShouldNotBeAvailble() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.lendBook("Marek Marecki");
        assertFalse(bi.itsAvailable());
    }

    @Test
    public void lendedBookShouldHaveAssignedProperBorrowerName() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.lendBook("Marek Marecki");
        assertEquals("Marek Marecki", bi.getBorrowerName());
    }

    @Test
    public void lendBookShouldReturnTrueWhenWasSuccessful() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        assertTrue(bi.lendBook("Marek Marecki"));
    }

    @Test
    public void lendBookShouldReturnFalseWhenBookIsAlreadyLended() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.lendBook("Jan Kowalski");
        assertFalse(bi.lendBook("Marek Marecki"));
    }

    @Test
    public void lendBookShouldReturnFalseWhenBorrowerNameIsEmpty() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        assertFalse(bi.lendBook(""));
    }

    @Test
    public void returnedBookShouldBeAvailableAgain() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.lendBook("Marek Marecki");
        bi.returnBook();
        assertTrue(bi.itsAvailable());
    }

    @Test
    public void returnedBookShouldReturnTrueWhenWasSuccesfull() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.lendBook("Marek Marecki");
        assertTrue(bi.returnBook());
    }

    @Test
    public void returnedBookShouldReturnFalseWhenNoOneLendedItBefore() throws Exception {
        BookItem bi = new BookItem("Lalka", "Boleslaw Prus", 2001);
        bi.returnBook();
        assertFalse(bi.returnBook());
    }


}