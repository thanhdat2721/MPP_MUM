package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Book;

public class BookEditDialogController implements Initializable {

	@FXML
	private TextField txtTitle;

	@FXML
	private TextField txtAuthor;   

	@FXML
	private TextField txtIssn;

	@FXML
	private TextField txtPublishedDate;

	private Stage dialogStage;
	private Book book;
	private boolean okClicked = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // TODO Auto-generated method stub

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	public void setBook(Book book) {
		this.book = book;

		txtTitle.setText(this.book.getTitle());
		txtAuthor.setText(book.getAuthor());
		txtIssn.setText(book.getIssn());
		txtPublishedDate.setText(book.getPublishedDate().toString());
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			book.setTitle(txtTitle.getText());
			book.setAuthor(txtAuthor.getText());
			book.setIssn(txtIssn.getText());
			book.setPublishedDate(LocalDate.parse(txtPublishedDate.getText()));
			
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (txtTitle.getText() == null || txtTitle.getText().length() == 0) {
			errorMessage += "No valid title!\n";
		}
		if (txtAuthor.getText() == null || txtAuthor.getText().length() == 0) {
			errorMessage += "No valid author!\n";
		}
		if (txtIssn.getText() == null || txtIssn.getText().length() == 0) {
			errorMessage += "No valid ISSN!\n";
		}

		if (txtPublishedDate.getText() == null || txtPublishedDate.getText().length() == 0) {
			errorMessage += "No valid date!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
