package cfg.lms.ui;
import cfg.lms.services.BookService;
import cfg.lms.exception.BookNotFoundException;

import java.util.Map;
import java.util.Scanner;
public class BookSearchUI {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search keyword (min 4 characters, only alphabets): ");
        String keyword = scanner.nextLine();
        BookService bookService = new BookService();
        try {

            Map<String, String> books = bookService.searchBook(keyword);

            books.forEach((title, author) -> {
                System.out.println("Title: " + title + " | Author: " + author);
            });
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid search keyword: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while searching for books: " + e.getMessage());
        }
    }
}
