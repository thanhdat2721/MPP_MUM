package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;
import model.LibraryMember;

public final class DummyData {
	static ObservableList<Book> bookData = FXCollections.observableArrayList();

	static {
//		bookData.add(new Book("The Stranger", "Albert Camus"));
//		bookData.add(new Book("Don Quixote", "Miguel de Cervantes"));
//		bookData.add(new Book("The Sun Also Rises", "Ernest Hemingway"));
//		bookData.add(new Book("To Kill a Mockingbird", "Harper Lee"));
//		bookData.add(new Book("Invisible Man", "Ralph Ellison"));
//		bookData.add(new Book("Pride and Prejudice", "Jane Austen"));
	}

	static ObservableList<LibraryMember> memberData = FXCollections.observableArrayList();
	static {
		memberData.add(new LibraryMember(new Integer(1), "Bat", "Bold", "999089000", "batbold@"));
		memberData.add(new LibraryMember(new Integer(2), "John", "Smith", "666666444", "johns@"));
		memberData.add(new LibraryMember(new Integer(3), "James", "Haltur", "44555444", "james@"));
		memberData.add(new LibraryMember(new Integer(4), "Hagen", "Peterson", "88899089000", "peterh@"));
	}
}
