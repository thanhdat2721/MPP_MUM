package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;
import model.CheckOut;
import model.LibraryMember;
import model.Role;
import model.User;

public final class DummyData {
	static ObservableList<User> users = FXCollections.observableArrayList();
	static ObservableList<LibraryMember> memberData = FXCollections.observableArrayList();
	static ObservableList<CheckOut> checkoutData = FXCollections.observableArrayList();

	static {
		users.add(new User("John","Mathew","012345667","john@gmail.com","admin","123",Role.ADMIN));
		users.add(new User("May","Mathew","012345667","may@gmail.com","librarian","123",Role.LIBRARIAN));
		memberData.add(new LibraryMember("Bat", "Bold", "999089000", "batbold@", 1, LocalDate.of(2019, 12, 1)));
		memberData.add(new LibraryMember("John", "Smith", "666666444", "johns@", 2, LocalDate.of(2019, 11, 1)));
		memberData.add(new LibraryMember("James", "Haltur", "44555444", "james@", 3, LocalDate.of(2019, 1, 23)));
		memberData.add(new LibraryMember("Hagen", "Peterson", "88899089000", "peterh@", 4, LocalDate.of(2019, 3, 4)));
		checkoutData.add(new CheckOut("Computer Science ","Bat", LocalDate.now().minusDays(7), LocalDate.now().plusDays(7), LocalDate.now(), "Returned"));
		checkoutData.add(new CheckOut("Information Technology ","Bat", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().minusDays(7), "borrowed"));
		checkoutData.add(new CheckOut("Data Management/Data Analytic ","John", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().minusDays(7), "borrowed"));
		checkoutData.add(new CheckOut("Cybersecurity and Information Assurance ","James", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now(), "Returned"));
		checkoutData.add(new CheckOut("Computer Science ","Hagen", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"));
		checkoutData.add(new CheckOut("Data Management/Data Analytic ","John", LocalDate.now(), LocalDate.now(), LocalDate.now().minusDays(7), "borrowed"));
		checkoutData.add(new CheckOut("Cybersecurity and Information Assurance ","Hagen", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"));	
	}
}
 