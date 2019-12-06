package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.LibraryMember;
import model.UserSession;

public class MemberManagementController implements Initializable {

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnCancel;

	@FXML
	private TextField txtSearch;

	@FXML
	private TextField txtMemberNo;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtMobile;

	@FXML
	private TextField txtEmail;

	@FXML
	private DatePicker dateRegistered;

	@FXML
	private TableView<LibraryMember> tableView;

	@FXML
	private TableColumn<LibraryMember, Integer> memberNoColumn;

	@FXML
	private TableColumn<LibraryMember, String> fNameColumn;

	@FXML
	private TableColumn<LibraryMember, String> lNameColumn;

	@FXML
	private TableColumn<LibraryMember, String> mobileColumn;

	@FXML
	private TableColumn<LibraryMember, String> emailColumn;

	@FXML
	private TableColumn<LibraryMember, Date> rdateColumn;

	@FXML
	private Label statusLabel;

	ObservableList<LibraryMember> members = DummyData.memberData;
	LibraryMember lmember;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setDisableDetailCtrl(true);

		memberNoColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, Integer>("memberNum"));
		fNameColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstName"));
		lNameColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastName"));
		mobileColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("mobileNo"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("email"));
		rdateColumn.setCellValueFactory(new PropertyValueFactory<LibraryMember, Date>("registeredDate"));

		tableView.setItems(members);
		lmember = new LibraryMember();

		txtSearch.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = txtSearch.getText().charAt(oldValue.intValue());
					// Check if the new character is the number or other's
					if (!(ch >= '0' && ch <= '9')) {
						// if it's not number then just setText to previous one
						txtSearch.setText(txtSearch.getText().substring(0, txtSearch.getText().length() - 1));
					}
				}
			}

		});

		txtMemberNo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = txtMemberNo.getText().charAt(oldValue.intValue());
					// Check if the new character is the number or other's
					if (!(ch >= '0' && ch <= '9')) {
						// if it's not number then just setText to previous one
						txtMemberNo.setText(txtMemberNo.getText().substring(0, txtMemberNo.getText().length() - 1));
					}
				}
			}

		});
	}

	// button search - > filter member list
	public void searchMember(ActionEvent event) {
		System.out.println("search btn ");
		statusLabel.setText("");

		if (!txtSearch.getText().isEmpty()) {
			ObservableList<LibraryMember> filtered = members
					.filtered(mem -> mem.getMemberNum() == new Integer(txtSearch.getText()));

			if (filtered.isEmpty()) {
				tableView.setItems(members);
				prepareDetailPanel(event);
				statusLabel.setText("Not found");
			} else {
				tableView.setItems(filtered);
				lmember = filtered.get(0);
				setDetailsInfo(lmember);
				statusLabel.setText("");
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Please enter Member Id");
			alert.setContentText("Please enter Member Id.");
			alert.showAndWait();
		}

	}

	private void setDetailsInfo(LibraryMember member) {
		txtMemberNo.setText(String.valueOf(member.getMemberNum()));
		txtFirstName.setText(member.getFirstName());
		txtLastName.setText(member.getLastName());
		txtMobile.setText(member.getMobileNo());
		txtEmail.setText(member.getEmail());
		dateRegistered.setValue(member.getRegisteredDate());
	}

	// button add create new member object
	public void addNewMember(ActionEvent event) {
		prepareDetailPanel(event);
		lmember = new LibraryMember();
		dateRegistered.setValue(LocalDate.now());
		setDisableDetailCtrl(false);

	}

	// button edit prepare to enable details fields
	public void editMember(ActionEvent event) {
		System.out.println("edit btn");
		if (lmember.getMemberNum() != 0) {
			setDisableDetailCtrl(false);
		}
		txtMemberNo.setDisable(true);
	}

	private void setDisableDetailCtrl(Boolean f) {
		txtMemberNo.setDisable(f);
		txtFirstName.setDisable(f);
		txtLastName.setDisable(f);
		txtMobile.setDisable(f);
		txtEmail.setDisable(f);
		dateRegistered.setDisable(f);
		btnSave.setDisable(f);
		btnCancel.setDisable(f);
	}

	// button save call for add and edit
	public void saveMember(ActionEvent event) {
		if (lmember.getMemberNum() == 0) {
			if (isMemberIdExisting(txtMemberNo.getText())) {

				lmember = new LibraryMember(txtFirstName.getText(),
						txtLastName.getText(), txtMobile.getText(), txtEmail.getText(), Integer.parseInt(txtMemberNo.getText()), dateRegistered.getValue());

				tableView.getItems().add(lmember);
				members = tableView.getItems();
			} else {
				statusLabel.setText("Error:It is already in the list.");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Member Number should be unique");
				alert.setContentText("It is already in the list. Member No: " + txtMemberNo.getText());
				alert.showAndWait();
			}
		} else {
			System.out.println("edit" + lmember.getMemberNum());
			lmember.setMemberNum(Integer.parseInt(txtMemberNo.getText()));
			lmember.setFirstName(txtFirstName.getText());
			lmember.setLastName(txtLastName.getText());
			lmember.setMobileNo(txtMobile.getText());
			lmember.setEmail(txtEmail.getText());
			lmember.setRegisteredDate(dateRegistered.getValue());

			members.set(members.indexOf(tableView.getSelectionModel().getSelectedItem()), lmember);

		}
		prepareDetailPanel(event);

	}

	private boolean isMemberIdExisting(String ID) {
		return members.filtered(mem -> mem.getMemberNum() == new Integer(ID)).isEmpty();
	}

	// selected member show to detail side
	public void selectedMember(MouseEvent event) {
		System.out.println("select btn");

		lmember = tableView.getSelectionModel().getSelectedItem();
		if (lmember != null) {
			setDetailsInfo(lmember);
			statusLabel.setText("");
		}
	}

	// button cancel and clear
	public void prepareDetailPanel(ActionEvent event) {
		txtSearch.setText("");
		txtMemberNo.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtMobile.setText("");
		txtEmail.setText("");

		dateRegistered.setValue(LocalDate.now());
		tableView.setItems(members);
		setDisableDetailCtrl(true);

	}
}