package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("PauseMenu");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    void LoginButtonClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("MainGame.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        Stage newWindow = new Stage();
        newWindow.setTitle("Will Hero -- Game");
        newWindow.setScene(secondScene);
        newWindow.show();
    }

}
