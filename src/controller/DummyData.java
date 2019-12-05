package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;

public final class DummyData {
	static ObservableList<Book> bookData = FXCollections.observableArrayList();
	
	static {
		bookData.add(new Book("The Stranger", "Albert Camus"));
		bookData.add(new Book("Don Quixote", "Miguel de Cervantes"));
		bookData.add(new Book("The Sun Also Rises", "Ernest Hemingway"));
		bookData.add(new Book("To Kill a Mockingbird", "Harper Lee"));
		bookData.add(new Book("Invisible Man", "Ralph Ellison"));
		bookData.add(new Book("Pride and Prejudice", "Jane Austen"));
	}
}