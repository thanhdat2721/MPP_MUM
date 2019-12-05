package application;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CheckOut;

public class testCheckOut extends Application {
	private ObservableList<CheckOut> checkoutData= FXCollections.observableArrayList();


	public ObservableList<CheckOut> getCheckoutData() {
		return checkoutData;
	}

	public void setCheckoutData(ObservableList<CheckOut> checkoutData) {
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
