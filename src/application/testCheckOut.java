package application;


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
	
	

	public static void main(String[] args) {
		launch(args);
	}

}
