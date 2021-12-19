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
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
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
import java.util.concurrent.TimeUnit;

public class MainGame extends Application implements Initializable {

    private ArrayList<Position> AbyssStartingPostion = new ArrayList<Position>();
    private ArrayList<Position> AbyssEndingPosition = new ArrayList<Position>();



    private void InitializingAbyssStartingandEndingPosition(){
        Position p1_s = new Position(800,0);
        Position p1_e = new Position(850,0);
        AbyssStartingPostion.add(p1_s);
        AbyssEndingPosition.add(p1_e);
        Position p2_s = new Position(1050,0);
        Position p2_e = new Position(1150,0);
        AbyssStartingPostion.add(p2_s);
        AbyssEndingPosition.add(p2_e);
        Position p3_s = new Position(1350,0);
        Position p3_e = new Position(1450,0);
        AbyssStartingPostion.add(p3_s);
        AbyssEndingPosition.add(p3_e);
        Position p4_s = new Position(1800,0);
        Position p4_e = new Position(1900,0);
        AbyssStartingPostion.add(p4_s);
        AbyssEndingPosition.add(p4_e);
        Position p5_s = new Position(2250,0);
        Position p5_e = new Position(2300,0);
        AbyssStartingPostion.add(p5_s);
        AbyssEndingPosition.add(p5_e);
        Position p6_s = new Position(2550,0);
        Position p6_e = new Position(2600,0);
        AbyssStartingPostion.add(p6_s);
        AbyssEndingPosition.add(p6_e);
        Position p7_s = new Position(2800,0);
        Position p7_e = new Position(2900,0);
        AbyssStartingPostion.add(p7_s);
        AbyssEndingPosition.add(p7_e);
        Position p8_s = new Position(3200,0);
        Position p8_e = new Position(3300,0);
        AbyssStartingPostion.add(p8_s);
        AbyssEndingPosition.add(p8_e);
        Position p9_s = new Position(3800,0);
        Position p9_e = new Position(3850,0);
        AbyssStartingPostion.add(p9_s);
        AbyssEndingPosition.add(p9_e);
        Position p10_s = new Position(4150,0);
        Position p10_e = new Position(4250,0);
        AbyssStartingPostion.add(p10_s);
        AbyssEndingPosition.add(p10_e);
        Position p11_s = new Position(4500,0);
        Position p11_e = new Position(4600,0);
        AbyssStartingPostion.add(p11_s);
        AbyssEndingPosition.add(p11_e);


    }


    private boolean firstClick = true;
    private static Parent p_root;
    private static Stage myStage;
    private static Scene getCurrentScene;
    private static LoadSavedGameController currentSceneController;
    private Hero hero;

    @FXML
    private ImageView Hero;

    @FXML
    private Pane pane2;

//    @FXML
//    private Pane pane3;


    @FXML
    private ImageView island1;

    @FXML
    private ImageView island2;

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

    boolean checkFall(float x){
        for(int i = 0 ; i <AbyssStartingPostion.size() ; i++){
            if(x>AbyssStartingPostion.get(i).getX()){
                if (x>AbyssStartingPostion.get(i).getX() && x<AbyssEndingPosition.get(i).getX()){
                    return true;
                }
            }

        }
        return false;
    }

    @FXML
    void click(MouseEvent event) throws InterruptedException {

        if(firstClick)
        {
            Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                afterFirstClickTransition();
            }));
            new SequentialTransition(intro).play();
            firstClick = false;
            InitializingAbyssStartingandEndingPosition();
        }

        {
            if(noOfClicks < 4) {
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
                new SequentialTransition(intro).play();
            }
        }
        System.out.println("hello");
        System.out.println("Hero Translate X: " + Hero.getTranslateX());
        System.out.println("Hero Translate Y: " + Hero.getTranslateY());
        System.out.println("Pane 2 Translate X: " + pane2.getTranslateX());
        System.out.println();
        if(Hero.getTranslateX()-pane2.getTranslateX() > 870 && Hero.getTranslateX()-pane2.getTranslateX() <= 960)
        {
            System.out.println("death");
            runTranslateTransitionForHero(Hero, 0, 500, 2000).play();
        }

    }

    @FXML
    void click2(MouseEvent event) {
        System.out.println("DRAGGED");

        if(firstClick)
        {
            Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                afterFirstClickTransition();
            }));
            new SequentialTransition(intro).play();
            firstClick = false;
        }

        {
            if(noOfClicks < 4) {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    moveHeroForward();
                }));
                new SequentialTransition(intro).play();
                noOfClicks++;
            }
            else{
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    moveScreen2();
                }));
                new SequentialTransition(intro).play();
            }
        }
        System.out.println("hello");
        System.out.println("Hero Translate X: " + Hero.getTranslateX());
        System.out.println("Hero Translate Y: " + Hero.getTranslateY());
        System.out.println("Pane 2 Translate X: " + pane2.getTranslateX());
        System.out.println();
        if(Hero.getTranslateX()-pane2.getTranslateX() > 860 && Hero.getTranslateX()-pane2.getTranslateX() <= 960)
        {
            System.out.println("death");
            runTranslateTransitionForHero(Hero, 0, 500, 2000).play();
        }
    }


    //This function to be placed in Hero Class
    private void moveHeroForward(){
        runTranslateTransitionForHero(Hero, 60, 0, 100).play();
    }

    private void moveScreen()
    {
        runTranslateTransition(pane2, -120, 0, 100).play();
    }

    private void moveScreen2()
    {
        runTranslateTransition(pane2, -180, 0, 100).play();
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
