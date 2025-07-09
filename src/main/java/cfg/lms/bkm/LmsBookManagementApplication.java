package cfg.lms.bkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LmsBookManagementApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context=SpringApplication.run(LmsBookManagementApplication.class, args);
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student st=context.getBean(Student.class);
		System.out.println(st.getStudentName());
//		Author author=context.getBean(Author.class);
//		author.setAid(1);
//		author.setName("harsh");
//		
//		Book book=context.getBean(Book.class);
//		book.setAuthor(author);
//		book.setBookID(2);
//		book.setTitle("Java");
//		
//		Librarian lib=context.getBean(Librarian.class);
//		
//System.out.println(author.getAid());
//System.out.println(author.getName());
		
//		Book book=context.getBean(Book.class);
//		User user1=context.getBean(Customer.class);
//		user1.setName("harsh");
//		user1.setUserID(2);
//		
//		User user2=context.getBean(Librarian.class);
//		user2.setName("sundar");
//		user2.setUserID(3);
//		
//		Book book1=context.getBean(Book.class);
//		System.out.println(book1.getUser().getName());
//		
//		Book book2=context.getBean(Book.class);
//		System.out.println(book2.getUser().getName());
	}

}
