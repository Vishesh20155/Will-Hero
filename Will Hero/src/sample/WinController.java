package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class WinController {
    @FXML
    private Text Text1;

    @FXML
    private Text Text2;

    @FXML
    void RemoveUnderlinePlay(MouseEvent event) {
        Text1.setUnderline(false);
    }

    @FXML
    void UnderlinePlayButton(MouseEvent event) {
        Text1.setUnderline(true);
    }

    @FXML
    void UnderlineHomeButton(MouseEvent event) {
        Text2.setUnderline(true);
    }


    @FXML
    void RemoveUnderlineHome(MouseEvent event) {
        Text2.setUnderline(false);
    }

    @FXML
    void ReturnToHomeClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));

        Stage temp = (Stage) Text1.getScene().getWindow();
        temp.close();
        Scene secondScene = new Scene(secondaryLayout);

        HomeScreenController.stage.close();
        HomeScreenController.stage.setTitle("Will Hero -- Home");
        HomeScreenController.stage.setScene(secondScene);
        HomeScreenController.stage.show();
    }

    @FXML
    void PlayAgainClicked(MouseEvent event) throws IOException {
        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("MainGame.fxml"));

        Stage temp = (Stage) Text1.getScene().getWindow();
        temp.close();
        Scene secondScene = new Scene(secondaryLayout);

        HomeScreenController.stage.close();
        HomeScreenController.stage.setTitle("Will Hero -- Game");
        HomeScreenController.stage.setScene(secondScene);
        HomeScreenController.stage.show();
    }

}