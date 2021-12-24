package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LoadSavedGameController implements Serializable {

    @FXML
    private Button LoadGameButton;

    @FXML
    private TextField GameIDinput;

    @FXML
    void LoadScreenButtonClicked(MouseEvent event) throws IOException {
        String fileName = "filename.txt";
        ArrayList<Double> positions = new ArrayList<Double>();
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> coins = new ArrayList<>();
        System.out.println("LOAD button clicked");
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            String mystring;
            int j=0;
            while ((mystring = in.readLine()) != null) {
                if(j%3 == 0)
                    positions.add(Double.parseDouble(mystring));
                else if(j%3 == 1)
                    scores.add(Integer.parseInt(mystring));
                else
                    coins.add(Integer.parseInt(mystring));
//                System.out.println(Double.parseDouble(mystring));
                j++;
            }
        }
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
        int inp = Integer.parseInt(GameIDinput.getText());
        System.out.println(inp);

        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("MainGame.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        HomeScreenController.stage.close();
        HomeScreenController.stage = new Stage();
        HomeScreenController.stage.setTitle("Will Hero -- Main Game (continued)");
        HomeScreenController.stage.setScene(secondScene);
        HomeScreenController.stage.show();

        (new MainGame()).setUpGame(positions.get(inp), scores.get(inp), coins.get(inp));
    }



}