package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;
import model.BookCopy;

public final class BookRepo {
	public static ObservableList<Book> bookData = FXCollections.observableArrayList();
	static Map<Integer, List<BookCopy>> bookCopyData = new HashMap<Integer, List<BookCopy>>();

	static int bookAutoIncrement = 6;
	static int bookCopyAutoIncrement = 0;

	static {
		bookData.add(new Book(1, "The Stranger", "Albert Camus", "", LocalDate.of(1992, 5, 12)));
		bookData.add(new Book(2, "Don Quixote", "Miguel de Cervantes", "", LocalDate.of(1992, 5, 12)));
		bookData.add(new Book(3, "The Sun Also Rises", "Ernest Hemingway", "", LocalDate.of(1992, 5, 12)));
		bookData.add(new Book(4, "To Kill a Mockingbird", "Harper Lee", "", LocalDate.of(1992, 5, 12)));
		bookData.add(new Book(5, "Invisible Man", "Ralph Ellison", "", LocalDate.of(1992, 5, 12)));
		bookData.add(new Book(6, "Pride and Prejudice", "Jane Austen", "", LocalDate.of(1992, 5, 12)));
	}

	public static void addBook(String title, String author, String issn, LocalDate date) {
		Book book = new Book(bookAutoIncrement++, title, author, issn, date);
		bookData.add(book);
	}

	public static void deleteBook(Book book) {
		bookData.remove(book);
	}

	public static void addBookCopy(int bookId) {
		List<BookCopy> copies = bookCopyData.get(bookId);
		if (copies == null) {
			copies = new ArrayList<BookCopy>();
			bookCopyData.put(bookId, copies);
		}

		copies.add(new BookCopy(bookId, bookCopyAutoIncrement++));
	}

	public static Integer getBookCopyNum(int bookId) {
		List<BookCopy> copies = bookCopyData.get(bookId);
		if (copies != null) {
			return copies.size();
		}
		return 0;
	}
}
