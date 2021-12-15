package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LoadSavedGameController {

    @FXML
    private Button LoadGameButton;

    @FXML
    void LoadScreenButtonClicked(MouseEvent event) {
        System.out.println("LOAD button clicked");
    }

}