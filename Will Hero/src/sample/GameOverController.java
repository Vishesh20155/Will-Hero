package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController extends Application implements Initializable{

    @FXML
    private Text PlayAgainText;

    @FXML
    private Text HomeText;

    @FXML
    private ImageView FallingOrc;

    @FXML
    private Button ResurrectButton;

    @FXML
    private Text Message;

    @FXML
    private Button showScoreButton;

    @FXML
    private Text NoOfCoinsText;

    @FXML
    private Text CoinsHeadingText;

    @FXML
    private Text ScoreHeadingText;

    @FXML
    private Text ScoreText;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
        primaryStage.setTitle("Will Hero");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    void removeUnderlinePlayAgainText(MouseEvent event) {
        PlayAgainText.setUnderline(false);
    }

    @FXML
    void underlinePlayAgainText(MouseEvent event) {
        PlayAgainText.setUnderline(true);
    }

    @FXML
    void removeUnderlineHomeText(MouseEvent event) {
        HomeText.setUnderline(false);
    }

    @FXML
    void underlineHomeText(MouseEvent event) {
        HomeText.setUnderline(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CommonAnimation.delay(2000).play();
        CommonAnimation.runTranslateTransition(FallingOrc, 0, 320, 2000).play();
        System.out.println("hello");
    }

    @FXML
    void ResurrectClicked(MouseEvent event) {
        if(MainGame.getCoins() >= 35){
            MainGame.setCoins();
            Stage thisStage = (Stage) ResurrectButton.getScene().getWindow();
            thisStage.close();
        }
        else {
            ResurrectButton.setOpacity(0);
            Message.setOpacity(1);
        }
    }

    @FXML
    void showScoreButtonClicked(MouseEvent event) {
        showScoreButton.setOpacity(0);
        NoOfCoinsText.setOpacity(1);
        ScoreText.setOpacity(1);
        ScoreHeadingText.setOpacity(1);
        CoinsHeadingText.setOpacity(1);
        ScoreText.setText(Integer.toString(MainGame.getGameScore()));
        NoOfCoinsText.setText(Integer.toString(MainGame.getCoins()));
    }

    @FXML
    void PlayAgainClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("MainGame.fxml"));

        Stage temp = (Stage) PlayAgainText.getScene().getWindow();
        temp.close();
        Scene secondScene = new Scene(secondaryLayout);

        HomeScreenController.stage.close();
        HomeScreenController.stage.setTitle("Will Hero -- Game");
        HomeScreenController.stage.setScene(secondScene);
        HomeScreenController.stage.show();
    }

    @FXML
    void ReturnToHomeClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));

        Stage temp = (Stage) PlayAgainText.getScene().getWindow();
        temp.close();
        Scene secondScene = new Scene(secondaryLayout);

        HomeScreenController.stage.close();
        HomeScreenController.stage.setTitle("Will Hero -- Home");
        HomeScreenController.stage.setScene(secondScene);
        HomeScreenController.stage.show();
    }
}