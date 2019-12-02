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
import model.CheckedOutBook;

public class ListCheckedOutBookController implements Initializable{
	
	@FXML
	private DatePicker dtFindDate;
	
	@FXML
	private Button btnFind;
	
	@FXML
	private TableView<CheckedOutBook> bookTableView;
	
	@FXML
	private TableColumn<CheckedOutBook, Integer> idCol;

	@FXML
	private TableColumn<CheckedOutBook, String> bookNameCol;

	@FXML
	private TableColumn<CheckedOutBook, String> memberNameCol;

	@FXML
	private TableColumn<CheckedOutBook, String> checkoutDateCol;

	@FXML
	private TableColumn<CheckedOutBook, String> dueDateCol;
	
	ObservableList<CheckedOutBook> listBooks;
	
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("[MM/dd/yyyy]");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		idCol.setCellValueFactory(new PropertyValueFactory<CheckedOutBook, Integer>("id"));
		bookNameCol.setCellValueFactory(new PropertyValueFactory<CheckedOutBook, String>("bookName"));
		memberNameCol.setCellValueFactory(new PropertyValueFactory<CheckedOutBook, String>("memberName"));
		checkoutDateCol.setCellValueFactory(new PropertyValueFactory<CheckedOutBook, String>("checkoutDate"));
		dueDateCol.setCellValueFactory(new PropertyValueFactory<CheckedOutBook, String>("dueDate"));
		
		bookTableView.setItems(getListCheckoutBook());
		
	}
	
	public ObservableList<CheckedOutBook> getListCheckoutBook(){
		
		listBooks = FXCollections.observableArrayList();
		listBooks.add(new CheckedOutBook(1, "TM1", "Khanh", "11/01/2019", "12/01/2019"));
		listBooks.add(new CheckedOutBook(2, "Java In Action", "Dat", "10/01/2019", "11/01/2019"));
		return listBooks;
	}
	
	
	public ObservableList<CheckedOutBook> findOverdueBook(LocalDate dueDate){
System.out.println(">>>>>>> "+ LocalDate.parse(dueDate.format(FORMATTER),FORMATTER));
		FilteredList<CheckedOutBook> filteredData = new FilteredList<>(listBooks, b -> true);
		filteredData.setPredicate(checkedOutBook -> {
			if(LocalDate.parse(dueDate.format(FORMATTER), FORMATTER).until(LocalDate.parse(checkedOutBook.getDueDate(), FORMATTER), ChronoUnit.DAYS) <= 0) {
				return true;
			}
			return false;
		});

		
		return filteredData;
	}
	
	public void findButtonEvent(ActionEvent event) {

//		if(event.getSource() == btnFind)
//	    {
//			try {
//				Stage appStage = (Stage)btnFind.getScene().getWindow();
//				Parent root = FXMLLoader.load(getClass().getResource("/view/MemberManagement.fxml"));
//		        Scene scene = new Scene(root);
//		        appStage.setScene(scene);
//		        appStage.show();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//	    }
//		
		
		LocalDate findDate = dtFindDate.getValue();
		if(findDate == null) {
			bookTableView.setItems(listBooks);
			return;
		}
		ObservableList<CheckedOutBook> listBooksOverdue = findOverdueBook(findDate);
		bookTableView.setItems(listBooksOverdue);
		return;
	}
}
