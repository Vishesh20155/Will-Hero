package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController extends Application implements Initializable{

    @FXML
    private Text PlayAgainText;

    @FXML
    private Text HomeText;

    @FXML
    private ImageView FallingOrc;

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
}
