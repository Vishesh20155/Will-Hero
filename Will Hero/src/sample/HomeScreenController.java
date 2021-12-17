package sample;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;


public class HomeScreenController extends Application implements Initializable {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        primaryStage.setTitle("Will Hero - Home Screen");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        stage = new Stage();
        stage = primaryStage;
        stage.show();
    }


    @FXML
    private Label ContSavedGameonHomeScreen;

    @FXML
    private ImageView HeroonHomeScreen;

    @FXML
    private Label LogoutonHomeScreen;

    @FXML
    private ImageView OrconHomeScreen;

    @FXML
    private Label PlayButtononHomeScreen;

    @FXML
    private ImageView TitleonHomeScreen;

    @FXML
    void ContSavedGameAnimation(MouseEvent event) {
        ContSavedGameonHomeScreen.setUnderline(true);
    }

    @FXML
    void LogoutAnimation(MouseEvent event) {
        LogoutonHomeScreen.setUnderline(true);
    }

    @FXML
    void PlayButtonAnimation(MouseEvent event) {
        PlayButtononHomeScreen.setUnderline(true);
    }

    @FXML
    void ContSavedGameAnimation2(MouseEvent event) {
        ContSavedGameonHomeScreen.setUnderline(false);
    }

    @FXML
    void LogoutAnimation2(MouseEvent event) {
        LogoutonHomeScreen.setUnderline(false);
    }

    @FXML
    void PlayButtonAnimation2(MouseEvent event) {
        PlayButtononHomeScreen.setUnderline(false);
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline HomeScreen = new Timeline(new KeyFrame(Duration.millis(1) , actionEvent -> {
            CommonAnimation.runTranslateTransition(OrconHomeScreen,0,-40,700,Timeline.INDEFINITE,true).play();
            CommonAnimation.runTranslateTransition(HeroonHomeScreen,0,-80,500,Timeline.INDEFINITE,true).play();
        }));
        new SequentialTransition(CommonAnimation.delay(1000), HomeScreen).play();
    }

    @FXML
    void PlayButtonClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        stage.close();
        stage = new Stage();
        stage.setTitle("Will Hero -- Login Page");
        stage.setScene(secondScene);
        stage.show();
    }

    @FXML
    void ContinueSavedGameButtonClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("LoadSavedGame.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        stage.close();
        stage.setTitle("Will Hero -- Saved Games");
        stage.setScene(secondScene);
        stage.show();
    }

    @FXML
    void LogoutButtonClicked(MouseEvent event) throws IOException {
        stage.close();
        System.out.println("Game Closed");
    }




}
