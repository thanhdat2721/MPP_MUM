package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button btn =new Button();
        Label userName = new Label("UserName");
        Label password = new Label("Password");
        TextField nameText = new TextField();
        TextField passwordText = new TextField();
        btn.setText("Hello World");
        GridPane pane = new GridPane();
        pane.getChildren().addAll(userName,nameText);
        pane.getChildren().addAll(password,passwordText);
        pane.getChildren().add(btn);
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
