package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
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
//import javafx.scene.control.cell.PropertyValueFactory;
import model.BorrowReturnBook;
import model.CheckedOutBook;

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

//date time picker 
	@FXML
	private DatePicker dtBorrowDate;
	private DatePicker dtDueDate;
	
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

	public TableView<CheckedOutBook> getTableview() {
		return tableview;
	}

	public void setTableview(TableView<CheckedOutBook> tableview) {
		this.tableview = tableview;
	}

	public TableColumn<CheckedOutBook, String> getcBook() {
		return cBook;
	}

	public void setcBook(TableColumn<CheckedOutBook, String> cBook) {
		this.cBook = cBook;
	}

	public TableColumn<CheckedOutBook, String> getcMem() {
		return cMem;
	}

	public void setcMem(TableColumn<CheckedOutBook, String> cMem) {
		this.cMem = cMem;
	}

	public TableColumn<CheckedOutBook, Date> getcBor() {
		return cBor;
	}

	public void setcBor(TableColumn<CheckedOutBook, Date> cBor) {
		this.cBor = cBor;
	}

	public TableColumn<CheckedOutBook, Date> getcDue() {
		return cDue;
	}

	public void setcDue(TableColumn<CheckedOutBook, Date> cDue) {
		this.cDue = cDue;
	}

	public TableColumn<CheckedOutBook, String> getcStatus() {
		return cStatus;
	}

	public void setcStatus(TableColumn<CheckedOutBook, String> cStatus) {
		this.cStatus = cStatus;
	}

	public TableColumn<CheckedOutBook, Date> getcReturn() {
		return cReturn;
	}

	public void setcReturn(TableColumn<CheckedOutBook, Date> cReturn) {
		this.cReturn = cReturn;
	}

	public Label getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(Label statusLabel) {
		this.statusLabel = statusLabel;
	}

	@FXML
	private TableView<CheckedOutBook> tableview;
	
	@FXML
	private TableColumn<CheckedOutBook, String> cBook;

	@FXML
	private TableColumn<CheckedOutBook, String> cMem;

	@FXML
	private TableColumn<CheckedOutBook, Date> cBor;

	@FXML
	private TableColumn<CheckedOutBook, Date> cDue;

	@FXML
	private TableColumn<CheckedOutBook, String> cStatus;

	@FXML
	private TableColumn<CheckedOutBook, Date> cReturn;
	
	@FXML
	private Label statusLabel;

	ObservableList<BorrowReturnBook> borrowbooks;
	BorrowReturnBook lBorrow;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		borrowbooks = FXCollections.observableArrayList();

		//borrowbooks.add(new BorrowReturnBook("Computer Science ", "11/13/2019", "11/25/2019", "11/173/2019", "Returned"));
		//borrowbooks.add(new BorrowReturnBook("Cybersecurity and Information Assurance", "Peter", "11/13/2019", "11/25/2019"));
		//borrowbooks.add(new BorrowReturnBook("Data Management/Data Analytics", "Haltur", "11/13/2019", "11/25/2019"));
		//borrowbooks.add(new BorrowReturnBook("Information Technology", "Peterson", "11/13/2019", "11/25/2019"));


	}

}
