package application;


import controller.CheckOutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CheckOut;

public class MainCheckOut extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<CheckOut> checkoutData= FXCollections.observableArrayList();

	public MainCheckOut() {
		}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public ObservableList<CheckOut> getCheckoutData() {
		return checkoutData;
	}

	public void setCheckoutData(ObservableList<CheckOut> checkoutData) {
		this.checkoutData = checkoutData;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root;// = FXMLLoader.load(getClass().getResource("/view/CheckOutBook.fxml"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainCheckOut.class.getResource("/view/CheckOutBook.fxml"));
			BorderPane ChecOutBook = (BorderPane) loader.load();
			//rootLayout.setCenter(ChecOutBook);
			CheckOutController controller = loader.getController();
			//controller.setMainApp(this);
			root = FXMLLoader.load(getClass().getResource("/view/CheckOutBook.fxml"));
			primaryStage.setTitle("Check Out Book");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
