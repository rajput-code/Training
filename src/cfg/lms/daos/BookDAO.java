package cfg.lms.daos;
import cfg.lms.entities.BookEntity;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BookDAO {
	  public Map<String, String> searchBooks(String keyword) throws SQLException, ClassNotFoundException {
	        Map<String, String> result = new HashMap<>();
	        Class.forName("org.apache.derby.jdbc.ClientDriver");

	        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/derby", "derby", "derby")) {
	            String query = "SELECT title, author FROM derby.books WHERE title LIKE ? OR author LIKE ?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, "%" + keyword + "%");
	            ps.setString(2, "%" + keyword + "%");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                String title = rs.getString("title");
	                String author = rs.getString("author");
	                result.put(title, author);  
	            }
	        }

	        return result;
	    }
	}

