package application;

import java.time.LocalTime;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BorrowReturnBook;

public class testCheckOut extends Application {
	private ObservableList<BorrowReturnBook> checkoutData= FXCollections.observableArrayList();


	public ObservableList<BorrowReturnBook> getCheckoutData() {
		return checkoutData;
	}

	public void setCheckoutData(ObservableList<BorrowReturnBook> checkoutData) {
		this.checkoutData = checkoutData;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/CheckOutBook.fxml"));		
			primaryStage.setTitle("Check Out Book");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public testCheckOut() {
		/*checkoutData.add(new BorrowReturnBook("Computer Science ","Hung", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Cybersecurity and Information Assurance ","Hung", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Information Technology ","Peter", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Data Management/Data Analytic ","John", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Cybersecurity and Information Assurance ","Lion", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Computer Science ","Melisa", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Data Management/Data Analytic ","Bella", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
		checkoutData.add(new BorrowReturnBook("Cybersecurity and Information Assurance ","Melisa", LocalTime.now(), LocalTime.of(2019,12, 11), LocalTime.now(), "Returned"));
	
*/	}

	public static void main(String[] args) {
		launch(args);
	}

}
