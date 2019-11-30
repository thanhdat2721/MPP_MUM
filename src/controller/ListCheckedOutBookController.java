package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.CheckedOutBook;

public class ListCheckedOutBookController implements Initializable{
	
	@FXML
	TableView<CheckedOutBook> bookTableView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
