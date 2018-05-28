package BookLibrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pdabr on 5/28/2018.
 */
public class BookTest {
    String title = "W pustynie i w puszczy";
    int year = 2018;
    String firtName = "Henryk";
    String lastName = "Sienkiewicz";
    private Book book;

    @Test
    public void getTitle() throws Exception {

        book = new Book(title, year, firtName, lastName);
        assertEquals(title, book.getTitle());

    }

    @Test
    public void getYear() throws Exception {
        book = new Book(title, year, firtName, lastName);
        assertEquals(year, book.getYear());
    }

    @Test
    public void getAuthorFirstName() throws Exception {
        book = new Book(title, year, firtName, lastName);
        assertEquals(firtName, book.getAuthorFirstName());
    }

    @Test
    public void getAuthorLastName() throws Exception {
        book = new Book(title, year, firtName, lastName);
        assertEquals(lastName, book.getAuthorLastName());
    }
}