package controller;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CheckOut;
import model.CheckedOutBook;

public class OverdueBookController implements Initializable{
	
	@FXML
	private DatePicker dtFindDate;
	
	@FXML
	private Button btnFind;
	
	@FXML
	private TableView<CheckOut> bookTableView;

	@FXML
	private TableColumn<CheckOut, String> bookNameCol;

	@FXML
	private TableColumn<CheckOut, String> memberNameCol;

	@FXML
	private TableColumn<CheckOut, String> checkoutDateCol;

	@FXML
	private TableColumn<CheckOut, String> dueDateCol;
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnBookOverdue;
	
	ObservableList<CheckOut> listBooks;
	
	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		bookNameCol.setCellValueFactory(new PropertyValueFactory<CheckOut, String>("bookname"));
		memberNameCol.setCellValueFactory(new PropertyValueFactory<CheckOut, String>("membername"));
		checkoutDateCol.setCellValueFactory(new PropertyValueFactory<CheckOut, String>("borrowDate"));
		dueDateCol.setCellValueFactory(new PropertyValueFactory<CheckOut, String>("dueDate"));
		
		this.listBooks = DummyData.checkoutData;
		bookTableView.setItems(findOverdueBook(LocalDate.parse(LocalDate.now().toString(),FORMATTER)));
		
	}
	
	
	public ObservableList<CheckOut> findOverdueBook(LocalDate dueDate){

		FilteredList<CheckOut> filteredData = new FilteredList<>(listBooks, b -> true);
		filteredData.setPredicate(checkedOutBook -> {
			System.out.println(LocalDate.parse(dueDate.format(FORMATTER).toString(),FORMATTER).until(LocalDate.parse(checkedOutBook.getDueDate().toString(), FORMATTER), ChronoUnit.DAYS));
			if(LocalDate.parse(dueDate.format(FORMATTER).toString(),FORMATTER).until(LocalDate.parse(checkedOutBook.getDueDate().toString(), FORMATTER), ChronoUnit.DAYS) <= 0) {
				return true;
			}
			else {
				return false;
			}
			
		});

		
		return filteredData;
	}
	
	public void findButtonEvent(ActionEvent event) {	
		LocalDate findDate = dtFindDate.getValue();
		if(findDate == null) {
			bookTableView.setItems(listBooks);
			return;
		}
		ObservableList<CheckOut> listBooksOverdue = findOverdueBook(findDate);
		bookTableView.setItems(listBooksOverdue);
		return;
	}
	
	public void checkoutBookButtonEvent(ActionEvent event) {

		if (event.getSource() == btnBookOverdue) {
			try {
				Stage appStage = (Stage) btnBookOverdue.getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("/view/CheckOutBook.fxml"));
				Scene scene = new Scene(root);
				appStage.setScene(scene);
				appStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void logoutAction(ActionEvent event) {
		if (event.getSource() == btnLogout) {

			try {
				Stage appStage = (Stage) btnLogout.getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("../view/Login.css").toExternalForm());
				appStage.setTitle("Login");
				appStage.setScene(scene);
				appStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
