package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import application.MainCheckOut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BorrowReturnBook;

public class CheckOutController implements Initializable {
	@FXML
	private Button btnRefresh;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnCheckOut;

	@FXML
	private Button btnSearch;

	@FXML
	private TextField txtmemberID;

	@FXML
	private TextField txtBookID;

	@FXML
	private TextField txtSearch;

	// date time picker
	@FXML
	private DatePicker dtBorrowDate;
	private DatePicker dtDueDate;

	@FXML
	private TableView<BorrowReturnBook> checkoutTable;

	@FXML
	private TableColumn<BorrowReturnBook, String> cBook;

	@FXML
	private TableColumn<BorrowReturnBook, String> cMem;

	@FXML
	private TableColumn<BorrowReturnBook, Date> cBor;

	@FXML
	private TableColumn<BorrowReturnBook, Date> cDue;

	@FXML
	private TableColumn<BorrowReturnBook, String> cStatus;

	@FXML
	private TableColumn<BorrowReturnBook, Date> cReturn;

	@FXML
	private Label statusLabel;

	ObservableList<BorrowReturnBook> borrowbooks;
	BorrowReturnBook lBorrow;

	private MainCheckOut mainApp;

	public MainCheckOut getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainCheckOut mainApp) {
		this.mainApp = mainApp;
	}

	public CheckOutController() {

	}

	public Button getBtnRefresh() {
		return btnRefresh;
	}

	public void setBtnRefresh(Button btnRefresh) {
		this.btnRefresh = btnRefresh;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}

	public Button getBtnCheckOut() {
		return btnCheckOut;
	}

	public void setBtnCheckOut(Button btnCheckOut) {
		this.btnCheckOut = btnCheckOut;
	}

	public Button getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(Button btnSearch) {
		this.btnSearch = btnSearch;
	}

	public TextField getTxtmemberID() {
		return txtmemberID;
	}

	public void setTxtmemberID(TextField txtmemberID) {
		this.txtmemberID = txtmemberID;
	}

	public TextField getTxtBookID() {
		return txtBookID;
	}

	public void setTxtBookID(TextField txtBookID) {
		this.txtBookID = txtBookID;
	}

	public TextField getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(TextField txtSearch) {
		this.txtSearch = txtSearch;
	}

	public DatePicker getDtBorrowDate() {
		return dtBorrowDate;
	}

	public void setDtBorrowDate(DatePicker dtBorrowDate) {
		this.dtBorrowDate = dtBorrowDate;
	}

	public DatePicker getDtDueDate() {
		return dtDueDate;
	}

	public void setDtDueDate(DatePicker dtDueDate) {
		this.dtDueDate = dtDueDate;
	}

	public Label getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(Label statusLabel) {
		this.statusLabel = statusLabel;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		borrowbooks = FXCollections.observableArrayList(
			
		new BorrowReturnBook("Computer Science ","Hung", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Information Technology ","Peter", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Data Management/Data Analytic ","John", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Cybersecurity and Information Assurance ","Lion", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Computer Science ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Data Management/Data Analytic ","Bella", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new BorrowReturnBook("Cybersecurity and Information Assurance ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned")	
			);

		cBook.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("getBookt()")); //getMembern()
		cMem.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("getMembern()"));
		cBor.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,Date>("borrowDate"));
		cDue.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,Date>("dueDate"));
		cReturn.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,Date>("returnDate"));
		cStatus.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("status"));
		
		checkoutTable.setItems(borrowbooks);
		
	}

}
