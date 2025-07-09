package cfg.lms.bkm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Book {
	private int bookID;
	
	private String title;
	@Autowired
	private Author author;
    
	@Autowired
	@Qualifier("librarian")
	private User user;
	
	
}
