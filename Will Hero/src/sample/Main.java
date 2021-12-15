package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static sample.CommonAnimation.runTranslateTransition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {
    private static Parent p_root;
    private static Stage myStage;
    private static Scene getCurrentScene;
    private static LoadSavedGameController currentSceneController;

    @FXML
    private ImageView Hero;

    @FXML
    private ImageView cloud1;

    @FXML
    private Text startPlayingTextBox;

    @FXML
    private ImageView cloud2;

    @FXML
    private ImageView SettingsButton;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
        primaryStage.setTitle("Will Hero");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            introTransition(-1);
        }));

        new SequentialTransition(CommonAnimation.delay(1000), intro).play();
    }

    private void introTransition(int i) {

        runTranslateTransition(Hero, 0, -80, 500, Timeline.INDEFINITE, true).play();
    }

    @FXML
    void click(MouseEvent event) {
        runTranslateTransition(cloud1, 1630, 0, 7500, Timeline.INDEFINITE, false).play();
        CommonAnimation.fade(startPlayingTextBox, 0, 2000).play();
        runTranslateTransition(cloud2, 1610, 0, 30000, Timeline.INDEFINITE, false).play();
        System.out.println("hello");
    }


    @FXML
    void SettingsButtonClicked(MouseEvent event) throws IOException {

        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.show();

    }

}
