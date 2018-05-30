package BookLibrary;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BookItem b = new BookItem("W Pustynie i w Puszczy", "Henryk Sienkiewicz", 1992);
        BookItem b_1 = new BookItem("W Pustynie i w Puszczy", "Henryk Sienkiewicz", 1992);
        BookItem c = new BookItem("Potop", "Henryk Sienkiewicz", 2002);
        BookItem c_1 = new BookItem("Potop", "Henryk Sienkiewicz", 1992);
        Library lib = new Library();
        lib.addBook(b);
        lib.addBook(b_1);
        lib.addBook(c);
        lib.addBook(c_1);
        b_1.lendBook("Jan Kowalski");
        b_1.returnBook();
        lib.listAllBooks();
    }
}
