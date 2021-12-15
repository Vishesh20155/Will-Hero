package sample;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController extends Application implements Initializable {

    @FXML
    private Label GamePaused;

    @FXML
    private Label Home;

    @FXML
    private Label LoadPreviouslySavedGame;

    @FXML
    private Label Resume;

    @FXML
    private Label SaveCurrentGame;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        primaryStage.setTitle("PauseMenu");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        primaryStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline HomeScreen = new Timeline(new KeyFrame(Duration.millis(1) , actionEvent -> {

            CommonAnimation.fade(GamePaused,0.2,1500,true,500).play();

        }));



        new SequentialTransition(CommonAnimation.delay(1000), HomeScreen).play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    void HomeRemoveUnderline(MouseEvent event) {

        Home.setUnderline(false);

    }

    @FXML
    void HomeUnderline(MouseEvent event) {

        Home.setUnderline(true);

    }

    @FXML
    void LoadPreviouslySavedGameRemoveUnderline(MouseEvent event) {

        LoadPreviouslySavedGame.setUnderline(false);

    }

    @FXML
    void LoadPreviouslySavedGameUnderline(MouseEvent event) {

        LoadPreviouslySavedGame.setUnderline(true);

    }

    @FXML
    void ResumeRemoveUnderline(MouseEvent event) {

        Resume.setUnderline(false);

    }

    @FXML
    void ResumeUnderline(MouseEvent event) {

        Resume.setUnderline(true);

    }

    @FXML
    void SaveCurrentGameRemoveUnderline(MouseEvent event) {

        SaveCurrentGame.setUnderline(false);

    }

    @FXML
    void SaveCurrentGameUnderline(MouseEvent event) {

        SaveCurrentGame.setUnderline(true);

    }
}
