package cfg.lms.services;
import cfg.lms.daos.BookDAO;
import cfg.lms.dtos.BookDTO;
import cfg.lms.exception.BookNotFoundException;
import java.sql.SQLException;
import java.util.Map;

public class BookService {
    public Map<String, String> searchBook(String keyword) throws SQLException, ClassNotFoundException, BookNotFoundException {
        
        if (!isValidSearchKeyword(keyword)) {
            throw new IllegalArgumentException("Search keyword should be at least 4 characters long and only contain alphabets.");
        }

        BookDAO dao = new BookDAO();
        Map<String, String> books = dao.searchBooks(keyword);

        if (books.isEmpty()) {
        	throw new BookNotFoundException("No books found for the given keyword: " + keyword);        }

        return books;
    }

    private boolean isValidSearchKeyword(String keyword) {
        return keyword.length() >= 4 && keyword.matches("[a-zA-Z]+");
    }
}
