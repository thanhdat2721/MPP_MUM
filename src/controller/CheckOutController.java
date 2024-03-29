package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import application.MainCheckOut;
//import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CheckOut;


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
	private TableView<CheckOut> checkoutTable;

	@FXML
	private TableColumn<CheckOut, String> cBook;

	@FXML
	private TableColumn<CheckOut, String> cMem;

	@FXML
	private TableColumn<CheckOut, Date> cBor;

	@FXML
	private TableColumn<CheckOut, Date> cDue;

	@FXML
	private TableColumn<CheckOut, String> cStatus;

	@FXML
	private TableColumn<CheckOut, Date> cReturn;

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
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnBookOverdue;

	ObservableList<CheckOut> borrowbooks;
	CheckOut lBorrow;

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

		borrowbooks = DummyData.checkoutData;
				/*FXCollections.observableArrayList(
			
		new CheckOut("Computer Science ","Hung", LocalDate.now().minusDays(7), LocalDate.now().plusDays(7), LocalDate.now(), "Returned"),
		new CheckOut("Information Technology ","Peter", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().minusDays(7), "borrowed"),
		new CheckOut("Data Management/Data Analytic ","John", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().minusDays(7), "borrowed"),
		new CheckOut("Cybersecurity and Information Assurance ","Lion", LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now(), "Returned"),
		new CheckOut("Computer Science ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned"),
		new CheckOut("Data Management/Data Analytic ","Bella", LocalDate.now(), LocalDate.now(), LocalDate.now().minusDays(7), "borrowed"),
		new CheckOut("Cybersecurity and Information Assurance ","Melisa", LocalDate.now(), LocalDate.now(), LocalDate.now(), "Returned")	
			);*/

		cBook.setCellValueFactory(new PropertyValueFactory<CheckOut,String>("bookname")); //getMembern()
		cMem.setCellValueFactory(new PropertyValueFactory<CheckOut,String>("membername"));
		cBor.setCellValueFactory(new PropertyValueFactory<CheckOut,Date>("borrowDate"));
		cStatus.setCellValueFactory(new PropertyValueFactory<CheckOut,String>("status"));
		
		checkoutTable.setItems(borrowbooks);
		showCheckOutDetails(null);
		searchLabel.setText("");
		checkoutTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showCheckOutDetails(newValue));
		
	}
	private void showCheckOutDetails(CheckOut item) {
		if (item != null) {
			//item.member =DummyData.memberData.filtered()
			bookLabel.setText(item.getBookname());
			memberLabel.setText(item.getMembername());
			dborrowedLabel.setText(item.getBorrowDate().toString());
			ddueLabel.setText(item.getDueDate().toString());
			dreturnLabel.setText(item.getReturnDate().toString());
			statusLabel.setText(item.getStatus());

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			
			bookLabel.setText("");
			memberLabel.setText("");
			dborrowedLabel.setText("");
			ddueLabel.setText("");
			dreturnLabel.setText("");
			statusLabel.setText("");
		}
	}
	public void checkoutbook (ActionEvent e){
		if (txtBookID.getText()==""|| txtmemberID.getText()==null||dtBorrowDate.getValue()==null) {
			searchLabel.setText("Please input information in Book, Member and Borrowed date");
			//Message("Please input information in Book and Member");
			
		} else {
			CheckOut ne= new CheckOut();
			LocalDate today= LocalDate.now();
			ne.setBookname(txtBookID.getText());
			ne.setMembername(txtmemberID.getText());
			if(dtBorrowDate.getValue()!=null)
			{
			ne.setBorrowDate(dtBorrowDate.getValue());
			ne.setDueDate(dtBorrowDate.getValue().plusDays(12));
			ne.setReturnDate(dtBorrowDate.getValue().minusDays(2));
			ne.setStatus("Borrowed");
			}
			borrowbooks.add(ne);

		}
		
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
			//FilteredList<CheckOut> filteredData = new FilteredList<>(borrowbooks, chk -> true);
			//filteredData.setPredicate(arg0);
			ObservableList<CheckOut> resultlist = borrowbooks.filtered(chk -> chk.getBookname().toLowerCase().contains(txtSearch.getText().toLowerCase()));
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
	
	public void bookOverdueButtonEvent(ActionEvent event) {

		if (event.getSource() == btnBookOverdue) {
			try {
				Stage appStage = (Stage) btnBookOverdue.getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("/view/ListCheckedOutBook.fxml"));
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
