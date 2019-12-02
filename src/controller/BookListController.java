package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Book;
import application.Main;

public class BookListController implements Initializable {
	@FXML
	private TableView<Book> tableBook;
	@FXML
	private TableColumn<Book, String> titleColumn;
	@FXML
	private TableColumn<Book, String> authorColumn;
	@FXML
	private TableColumn<Book, String> issnColumn;

	@FXML
	private Label titleLabel;
	@FXML
	private Label authorLabel;
	@FXML
	private Label issnLabel;
	@FXML
	private Label pDateLabel;

	// private Main2 mainApp;

	private ObservableList<Book> bookData = FXCollections.observableArrayList();

	// public void setMainApp(Main2 mainApp) {
	// // this.mainApp = mainApp;
	// // ObservableList<Book> bookData = mainApp.getBookData();
	// // tableBook.setItems(bookData);
	// }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		issnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("issn"));

		tableBook.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showBookDetails(newValue));

		bookData.add(new Book("The Stranger", "Albert Camus"));
		bookData.add(new Book("Don Quixote", "Miguel de Cervantes"));
		bookData.add(new Book("The Sun Also Rises", "Ernest Hemingway"));
		bookData.add(new Book("To Kill a Mockingbird", "Harper Lee"));
		bookData.add(new Book("Invisible Man", "Ralph Ellison"));
		bookData.add(new Book("Pride and Prejudice", "Jane Austen"));
		tableBook.setItems(bookData);

	}

	private void showBookDetails(Book book) {
		if (book != null) {
			this.titleLabel.setText(book.getTitle());
			this.authorLabel.setText(book.getAuthor());
			this.issnLabel.setText(book.getIssn());
			this.pDateLabel.setText(book.getPublishedDate().toString());
		} else {
			this.titleLabel.setText("");
			this.authorLabel.setText("");
			this.issnLabel.setText("");
			this.pDateLabel.setText("");
		}   
	}

	@FXML
	public void handleDeleteBook() {
		int selectedIndex = tableBook.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tableBook.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			// Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(mainApp.getPrimaryStage());
			// alert.setTitle("No Selection");
			// alert.setHeaderText("No Book Selected");
			// alert.setContentText("Please select a book in the table.");
			//
			// alert.showAndWait();
		}
	}

	@FXML
	public void handleEditBook() throws IOException {
		Book selectedBook = tableBook.getSelectionModel().getSelectedItem();
		if (selectedBook != null) {
			boolean okClicked = this.showBookEditDialog(selectedBook);
			if (okClicked) {
				showBookDetails(selectedBook);
			}

		} else {
			// Nothing selected.
			// Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(mainApp.getPrimaryStage());
			// alert.setTitle("No Selection");
			// alert.setHeaderText("No Person Selected");
			// alert.setContentText("Please select a person in the table.");
			//
			// alert.showAndWait();
		}

	}

	@FXML
	public void handleAddBook() throws IOException {
		Book tempBook = new Book();
		boolean okClicked = this.showBookEditDialog(tempBook);
		if (okClicked) {
			bookData.add(tempBook);
		}
	}

	public boolean showBookEditDialog(Book book) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/BookEditDialog.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		// Create the dialog Stage.
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Edit Book");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		// dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);

		BookEditDialogController controller = loader.getController();
		controller.setDialogStage(dialogStage);
		controller.setBook(book);
		dialogStage.showAndWait();

		return controller.isOkClicked();
	}
}
