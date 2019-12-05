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
import model.Role;
import model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text resultMsg;

    ObservableList<User> users=DummyData.users;


    public void login(ActionEvent actionEvent) {
        Parent pane;
        String email = emailField.getText();
        String password = passwordField.getText();
        FilteredList<User> t = users.filtered(user-> user.getEmail().equals(email) && user.getPassword().equals(password));
        if(t.isEmpty()){
            resultMsg.setText("Invalid Email and Password");
        }
        else {
            resultMsg.setText("Login Successfully!");

            UserSession.setUserSession(t.get(0).getEmail(),t.get(0).userRole());
            System.out.println(t.get(0).userRole());
            try {
                String window = t.get(0).userRole()== Role.ADMIN ? "/view/MemberManagement.fxml":"/view/CheckOutBook.fxml" ;
                pane = FXMLLoader.load(
                        getClass().getResource(window));

                Stage app_state = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                if(t.get(0).userRole()==Role.ADMIN) {
                	app_state.setTitle("Administrator");
                }
                else {
                	app_state.setTitle("Librarian");
                }

                app_state.getScene().setRoot(pane);
                app_state.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
