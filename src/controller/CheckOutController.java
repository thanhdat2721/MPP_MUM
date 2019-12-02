package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import application.MainCheckOut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
	private Label bookLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label dborrowedLabel;
	@FXML
	private Label ddueLabel;
	@FXML
	private Label dreturnLabel;
	@FXML
	private Label statusLabel; //searchLabel
	@FXML
	private Label searchLabel;

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
		new BorrowReturnBook("Information Technology ","Peter", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Processing"),
		new BorrowReturnBook("Data Management/Data Analytic ","John", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Processing"),
		new BorrowReturnBook("Cybersecurity and Information Assurance ","Lion", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Processing"),
		new BorrowReturnBook("Computer Science ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Processing"),
		new BorrowReturnBook("Data Management/Data Analytic ","Bella", LocalDate.now(), LocalDate.now(), LocalDate.now(), "New"),
		new BorrowReturnBook("Cybersecurity and Information Assurance ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned")	
			);

		cBook.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("bookname")); //getMembern()
		cMem.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("membername"));
		cBor.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,Date>("borrowDate"));
		cStatus.setCellValueFactory(new PropertyValueFactory<BorrowReturnBook,String>("status"));
		
		checkoutTable.setItems(borrowbooks);
		showCheckOutDetails(null);
		
		checkoutTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showCheckOutDetails(newValue));
		
	}
	private void showCheckOutDetails(BorrowReturnBook item) {
		if (item != null) {
			// Fill the labels with info from the person object.
			bookLabel.setText(item.getBookname());
			memberLabel.setText(item.getMembername());
			dborrowedLabel.setText(item.getBorrowDate().toString());
			ddueLabel.setText(item.getDueDate().toString());
			dreturnLabel.setText(item.getReturnDate().toString());
			statusLabel.setText(item.getStatus());

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			// Person is null, remove all the text.
			bookLabel.setText("");
			memberLabel.setText("");
			dborrowedLabel.setText("");
			ddueLabel.setText("");
			dreturnLabel.setText("");
			statusLabel.setText("");
		}
	}
	public void checkoutbook (ActionEvent e){
		BorrowReturnBook ne= new BorrowReturnBook();
		ne.setBookname(txtBookID.getText());
		ne.setMembername(txtmemberID.getText());
		ne.setBorrowDate(dtBorrowDate.getValue());
		ne.setDueDate(dtBorrowDate.getValue().plusDays(12));
		ne.setReturnDate(null);
		ne.setStatus("Processing");
		borrowbooks.add(ne);
		

	
	}
	public void cancelcheckoutbook (ActionEvent e){
		txtBookID.setText(null);
		txtmemberID.setText(null);
		txtSearch.setText(null);
		dtBorrowDate.setValue(null);
		
	}
	public void refreshcheckoutbook (ActionEvent e){
		txtBookID.setText(null);
		txtmemberID.setText(null);
		txtSearch.setText(null);
		dtBorrowDate.setValue(null);
		
	}
	public void searchcheckoutbook (ActionEvent e){
		if (txtSearch.getText()==""||txtSearch.getText()==null) {
			checkoutTable.setItems(borrowbooks);
			
		} else {
			ObservableList<BorrowReturnBook> resultlist = borrowbooks.filtered(chk -> chk.getBookname().toLowerCase()== txtSearch.getText().toLowerCase());
			if (resultlist.isEmpty()) {
				searchLabel.setText("Not found any book you search");
				checkoutTable.setItems(resultlist);
				
			} else {
				checkoutTable.setItems(resultlist);
				searchLabel.setText("I have found something!");

			}
					//.filtered(mem -> mem.getMemberNum() == new Integer(txtSearch.getText()));
		}
	}

}
