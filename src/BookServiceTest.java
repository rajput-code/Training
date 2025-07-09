

import cfg.lms.daos.BookDAO;
import cfg.lms.exception.BookNotFoundException;
import cfg.lms.services.BookService;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService;
    private BookDAO bookDAO;

    @Before
    public void setUp() {
        bookService = new BookService();
        bookDAO = new BookDAO();
    }

    @Test
    public void testSearchBook_Success() throws SQLException, ClassNotFoundException, BookNotFoundException {
        String keyword = "Java";
        Map<String, String> mockBooks = new HashMap<>();
        mockBooks.put("Java", "oracle");
        mockBooks.put("Dotnet", "Microsoft");
        mockBooks.put("React", "facebook");
        mockBooks.put("Angular", "google");
        mockBooks.put("MySQL", "oracle");
        mockBooks.put("Derby", "apache");
        mockBooks.put("JDBC", "java");
        mockBooks.put("Collections", "java");

        bookDAO = new BookDAO() {
            @Override
            public Map<String, String> searchBooks(String keyword) {
                Map<String, String> result = new HashMap<>();
                for (Map.Entry<String, String> entry : mockBooks.entrySet()) {
                    if (entry.getKey().toLowerCase().contains(keyword.toLowerCase())) {
                        result.put(entry.getKey(), entry.getValue());
                    }
                }
                return result;
            }
        };

        Map<String, String> result = bookService.searchBook(keyword);
        System.out.println("Search Result: " + result);

        assertNotNull(result);
        assertTrue(result.containsKey("Java"));
        assertEquals("oracle", result.get("Java"));
    }

    @Test
    public void testSearchBook_InvalidKeyword() throws ClassNotFoundException, SQLException, BookNotFoundException {
        String invalidKeyword = "Py";

        try {
            bookService.searchBook(invalidKeyword);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Search keyword should be at least 4 characters long and only contain alphabets.", e.getMessage());
        }
    }

    @Test
    public void testSearchBook_NoResults() throws SQLException, ClassNotFoundException {
        String keyword = "Python";

        bookDAO = new BookDAO() {
            @Override
            public Map<String, String> searchBooks(String keyword) {
                return new HashMap<>();
            }
        };

        try {
            bookService.searchBook(keyword);
            fail("Expected BookNotFoundException to be thrown");
        } catch (BookNotFoundException e) {
            assertEquals("No books found for the given keyword: Python", e.getMessage());
        }
    }
}
