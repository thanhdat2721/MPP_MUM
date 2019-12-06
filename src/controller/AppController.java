package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Role;
import model.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private Button btn_bookManagement,btn_memberManagement,btn_logOut;
    @FXML private Pane pane_main;

    public void handleMenuClick(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btn_memberManagement){

            Node node;
            try {
                node = (Node) FXMLLoader.load(getClass().getResource("/view/MemberManagement.fxml"));
                btn_memberManagement.setStyle("-fx-background-color: #6ED9A0");
                btn_bookManagement.setStyle("-fx-background-color: #2A363F");
                pane_main.getChildren().setAll(node);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(actionEvent.getSource() == btn_bookManagement){
            Node node;
            try {
                node = (Node) FXMLLoader.load(getClass().getResource("/view/CheckOutBook.fxml"));
                btn_bookManagement.setStyle("-fx-background-color: #6ED9A0");
                btn_memberManagement.setStyle("-fx-background-color: #2A363F");
                pane_main.getChildren().setAll(node);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(actionEvent.getSource() == btn_logOut){
            try {
                Stage appStage = (Stage) btn_logOut.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/view/NewLoginForm.fxml"));
                Scene scene = new Scene(root);
                appStage.setTitle("Login");
                scene.getStylesheets().add(getClass().getResource("../view/Login.css").toExternalForm());
                appStage.setWidth(978);
                appStage.setScene(scene);
                appStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            String windowUrl = UserSession.getRole()== Role.ADMIN ? "/view/MemberManagement.fxml":"/view/CheckOutBook.fxml";
            Node node;
            try {
                node = (Node) FXMLLoader.load(getClass().getResource(windowUrl));
                if(UserSession.getRole()== Role.ADMIN){
                    btn_memberManagement.setStyle("-fx-background-color: #2A363F");
                    btn_bookManagement.setStyle("-fx-background-color: #6ED9A0");
                }else{
                    btn_bookManagement.setStyle("-fx-background-color: #2A363F");
                    btn_memberManagement.setStyle("-fx-background-color: #6ED9A0");
                }
                pane_main.getChildren().setAll(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
