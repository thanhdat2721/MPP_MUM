package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text resultMsg;

    ObservableList<User> users;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users = FXCollections.observableArrayList();
        users.add(new User("admin1","123",0));
        users.add(new User("admin2","123",1));

//        emailField.textProperty().addListener(new ChangeListener<String>(){
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                emailField.setText(emailField.getText().substring(0, emailField.getText().length() - 1));
//            }
//        });
//
//        emailField.textProperty().addListener(new ChangeListener<String>(){
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                passwordField.setText(passwordField.getText().substring(0, passwordField.getText().length() - 1));
//            }
//        });
    }

    public void login(ActionEvent actionEvent) {
        Parent pane = null;
        String email = emailField.getText();
        String password = passwordField.getText();
        FilteredList<User> t = users.filtered(user-> user.getEmail().equals(email) && user.getPassword().equals(password));
        System.out.println(t);
        if(t.isEmpty()){
            resultMsg.setText("Invalid Email and Password");
        }
        else {
            resultMsg.setText("Login Successfully!");
            try {
                String window = t.get(0).getRole()==0 ? "/view/MemberManagement.fxml":"/view/CheckOutBook.fxml" ;
                pane = FXMLLoader.load(
                        getClass().getResource(window));

                Stage app_state = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                app_state.getScene().setRoot(pane);
                app_state.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
