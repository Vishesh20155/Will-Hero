package sample;

import com.sun.scenario.Settings;
import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static sample.CommonAnimation.runTranslateTransition;
import static sample.CommonAnimation.runTranslateTransitionForHero;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {
    private boolean firstClick = true;
    private static Parent p_root;
    private static Stage myStage;
    private static Scene getCurrentScene;
    private static LoadSavedGameController currentSceneController;

    @FXML
    private ImageView Hero;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private ImageView island1;

    @FXML
    private ImageView cloud1;

    @FXML
    private Text startPlayingTextBox;

    @FXML
    private ImageView cloud2;

    @FXML
    private ImageView SettingsButton;

    private Image island3;


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
        runTranslateTransition(Hero, 0, -120, 500, Timeline.INDEFINITE, true).play();
    }

    private void afterFirstClickTransition(){
        runTranslateTransition(cloud1, 1630, 0, 7500, Timeline.INDEFINITE, false).play();
        CommonAnimation.fade(startPlayingTextBox, 0, 2000).play();
        runTranslateTransition(cloud2, 1610, 0, 30000, Timeline.INDEFINITE, false).play();
    }

    static int noOfClicks = 0;

    @FXML
    void click(MouseEvent event) {

        System.out.print("Hero: ");
        System.out.print(Hero.getTranslateX());
        System.out.print("\t");
        System.out.println(Hero.getY());
        if(firstClick)
        {
            Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                afterFirstClickTransition();
            }));
            new SequentialTransition(intro).play();
            firstClick = false;

        }

        else{
            if(noOfClicks < 3) {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    moveHeroForward();
                }));
                new SequentialTransition(intro).play();
                noOfClicks++;
            }
            else{
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    moveScreen();
                }));
//                Timeline intro2 = new Timeline(new KeyFrame(Duration.millis(1), e -> {
//                    moveHeroForward();
//                }));
                new SequentialTransition(intro).play();
            }
        }
        System.out.print("Pane1: ");
        System.out.print(pane1.getTranslateX());
        System.out.print("\n");
        System.out.print("Pane2: ");
        System.out.print(pane2.getTranslateX());
        System.out.print("\n");
        System.out.print("Pane3: ");
        System.out.print(pane3.getTranslateX());
        System.out.print("\n");

    }

    public void createIslands(){
//        ArrayList<GameObject> Islands = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            island3 = island1.getImage();
////            Islands.add(new Island());
//        }
    }

    //This function to be placed in Hero Class
    private void moveHeroForward(){
        runTranslateTransitionForHero(Hero, 120, 0, 100).play();
    }

    private void moveScreen()
    {
        runTranslateTransitionForHero(Hero, 120, 0, 100).play();
        runTranslateTransition(pane1, -120, 0, 100).play();
        runTranslateTransition(pane2, -120, 0, 100).play();
        runTranslateTransition(pane3, -120, 0, 100).play();
        runTranslateTransition(pane4, -120, 0, 100).play();
    }


    @FXML
    void SettingsButtonClicked(MouseEvent event) throws IOException {

        Parent secondaryLayout = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));

        Scene secondScene = new Scene(secondaryLayout);

        Stage current_stage = new Stage();
        current_stage.setTitle("Second Stage");
        current_stage.setScene(secondScene);
        current_stage.show();

    }

}
