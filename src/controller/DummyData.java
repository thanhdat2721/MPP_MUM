package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;
import model.LibraryMember;
import model.Role;
import model.User;

public final class DummyData {
	static ObservableList<User> users = FXCollections.observableArrayList();
	static ObservableList<LibraryMember> memberData = FXCollections.observableArrayList();

	static {
		users.add(new User("John","Mathew","012345667","john@gmail.com","admin","123",Role.ADMIN));
		users.add(new User("May","Mathew","012345667","may@gmail.com","librarian","123",Role.LIBRARIAN));
		memberData.add(new LibraryMember(new Integer(1), "Bat", "Bold", "999089000", "batbold@",LocalDate.of(2019, 12, 1)));
		memberData.add(new LibraryMember(new Integer(2), "John", "Smith", "666666444", "johns@", LocalDate.of(2019, 11, 1)));
		memberData.add(new LibraryMember(new Integer(3), "James", "Haltur", "44555444", "james@",LocalDate.of(2019, 1, 23)));
		memberData.add(new LibraryMember(new Integer(4), "Hagen", "Peterson", "88899089000", "peterh@",LocalDate.of(2019, 3, 4)));
	}
}
