package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Book;
import repository.BookRepo;
import application.Main;

public class BookListController implements Initializable {
	@FXML
	private TableView<Book> tableBook;
	@FXML
	private TableColumn<Book, String> idColumn;
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
	@FXML
	private Label numLabel;

	@FXML
	Button btnMemberManagement;

	private ObservableList<Book> bookData = BookRepo.bookData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		idColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("bookId"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		issnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("issn"));

		tableBook.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showBookDetails(newValue));
		tableBook.setItems(bookData);

	}

	private void showBookDetails(Book book) {
		if (book != null) {
			this.titleLabel.setText(book.getTitle());
			this.authorLabel.setText(book.getAuthor());
			this.issnLabel.setText(book.getIssn());
			this.pDateLabel.setText(book.getPublishedDate().toString());
			this.numLabel.setText(BookRepo.getBookCopyNum(book.getBookId()).toString());
		} else {
			this.titleLabel.setText("");
			this.authorLabel.setText("");
			this.issnLabel.setText("");
			this.pDateLabel.setText("");
			this.numLabel.setText("");
		}
	}

	@FXML
	public void handleDeleteBook() {
		int selectedIndex = tableBook.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			// tableBook.getItems().remove(selectedIndex);
			BookRepo.deleteBook(tableBook.getItems().get(selectedIndex));
		} else {
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

	@FXML
	public void handleAddBookCopy() {
		Book selectedBook = tableBook.getSelectionModel().getSelectedItem();
		if (selectedBook != null) {
			BookRepo.addBookCopy(selectedBook.getBookId());
			this.numLabel.setText(BookRepo.getBookCopyNum(selectedBook.getBookId()).toString());
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

	public void memberManageButtonEvent(ActionEvent event) {

		if (event.getSource() == btnMemberManagement) {
			try {
				Stage appStage = (Stage) btnMemberManagement.getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("/view/MemberManagement.fxml"));
				Scene scene = new Scene(root);
				appStage.setTitle("Member Management");
				appStage.setScene(scene);
				appStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
