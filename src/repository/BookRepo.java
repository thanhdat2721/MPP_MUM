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
	static List<BookCopy> bookCopyData = new ArrayList<BookCopy>();

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

	public static Book getBook(int bookId) {
		for (Book b : bookData) {
			if (b.getBookId() == bookId) {
				return b;
			}
		}
		return null;
	}

	public static void addBook(String title, String author, String issn, LocalDate date) {
		Book book = new Book(bookAutoIncrement++, title, author, issn, date);
		bookData.add(book);
	}

	public static void deleteBook(Book book) {
		bookData.remove(book);
	}

	public static void addBookCopy(int bookId) {
		bookCopyData.add(new BookCopy(bookId, bookCopyAutoIncrement++));
	}

	public static int getBookCopyNum(int bookId) {
		int count = 0;
		for (BookCopy c : bookCopyData) {
			if (c.getBookId() == bookId)
				count++;
		}
		return count;
	}

	public static Book getBookByCopyId(int copyId) {
		for (BookCopy c : bookCopyData) {
			if (c.getCopyId() == copyId) {
				return getBook(c.getBookId());
			}
		}
		return null;
	}
}
