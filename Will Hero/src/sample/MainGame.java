package sample;

import com.sun.scenario.Settings;
import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
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
        Position p1_s = new Position(860,0);
        Position p1_e = new Position(960,0);
        AbyssStartingPostion.add(p1_s);
        AbyssEndingPosition.add(p1_e);
        Position p2_s = new Position(1160,0);
        Position p2_e = new Position(1261,0);
        AbyssStartingPostion.add(p2_s);
        AbyssEndingPosition.add(p2_e);
        Position p3_s = new Position(1610,0);
        Position p3_e = new Position(1711,0);
        AbyssStartingPostion.add(p3_s);
        AbyssEndingPosition.add(p3_e);
        Position p4_s = new Position(2060,0);
        Position p4_e = new Position(2110,0);
        AbyssStartingPostion.add(p4_s);
        AbyssEndingPosition.add(p4_e);
        Position p5_s = new Position(2360,0);
        Position p5_e = new Position(2410,0);
        AbyssStartingPostion.add(p5_s);
        AbyssEndingPosition.add(p5_e);
        Position p6_s = new Position(2610,0);
        Position p6_e = new Position(2711,0);
        AbyssStartingPostion.add(p6_s);
        AbyssEndingPosition.add(p6_e);
        Position p7_s = new Position(3010,0);
        Position p7_e = new Position(3111,0);
        AbyssStartingPostion.add(p7_s);
        AbyssEndingPosition.add(p7_e);
        Position p8_s = new Position(3610,0);
        Position p8_e = new Position(3660,0);
        AbyssStartingPostion.add(p8_s);
        AbyssEndingPosition.add(p8_e);
        Position p9_s = new Position(3960,0);
        Position p9_e = new Position(4061,0);
        AbyssStartingPostion.add(p9_s);
        AbyssEndingPosition.add(p9_e);
        Position p10_s = new Position(4310,0);
        Position p10_e = new Position(4411,0);
        AbyssStartingPostion.add(p10_s);
        AbyssEndingPosition.add(p10_e);



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
    private Group GroupOrc1;

    @FXML
    private Group GroupOrc2;

    @FXML
    private Pane pane2;

    @FXML
    private ImageView Orc1;

    @FXML
    private ImageView Orc2;

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

    @FXML
    private Text ScoreLabel;

    @FXML
    private ImageView Orc3;

    @FXML
    private ImageView Orc4;

    @FXML
    private ImageView Orc5;

    @FXML
    private ImageView Orc6;

    @FXML
    private Group GroupOrc3;


    @FXML
    private ImageView Orc7;


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
        runTranslateTransition(Orc1, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc2, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(GroupOrc1, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(GroupOrc2, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc3, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc4, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc5, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc6, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(Orc7, 0, -100, 600, Timeline.INDEFINITE, true).play();
        runTranslateTransition(GroupOrc3, 0, -100, 600, Timeline.INDEFINITE, true).play();

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
                if (x<AbyssEndingPosition.get(i).getX()){
                    return true;
                }
            }

        }
        return false;
    }

    void checkOrc(){
        if(pane2.getTranslateX() <= -120 && pane2.getTranslateX() >= -180) {
            System.out.println("check orc function");
            if(Orc1.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc1, 6000, 0, 2000).play();
            return;
        }

        if(Hero.getTranslateX()==300) {
            System.out.println("check orc2 function");
            if(Orc2.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc2, 6000, 0, 2000).play();
            return;
        }

        // Changed the group orc 1 to a better coordinate

        if(pane2.getTranslateX() <= -1040 && pane2.getTranslateX() >= -1140) {

            System.out.println("check GroupOrc1 function");
            if(GroupOrc1.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(GroupOrc1, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -1040 && pane2.getTranslateX() >= -1140) {

            System.out.println("check GroupOrc2 function");
            if(GroupOrc2.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(GroupOrc2, 6000, 0, 2000).play();
            return;

        }
        if(pane2.getTranslateX() <= -1540 && pane2.getTranslateX() >= -1640) {

            System.out.println("check GroupOrc2 function");
            if(GroupOrc2.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(GroupOrc2, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -1860 && pane2.getTranslateX() >= -1960) {

            System.out.println("check Orc3 function");
            if(Orc3.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc3, 6000, 0, 2000).play();
            return;

        }
        if(pane2.getTranslateX() <= -2500 && pane2.getTranslateX() >= -2600) {

            System.out.println("check Orc4 function");
            if(Orc4.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc4, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -2900 && pane2.getTranslateX() >= -3020) {

            System.out.println("check Orc5 function");
            if(Orc5.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc5, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -3100 && pane2.getTranslateX() >= -3200) {

            System.out.println("check Orc6 function");
            if(Orc6.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc6, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -3400 && pane2.getTranslateX() >= -3500) {

            System.out.println("check Orc7 function");
            if(Orc7.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(Orc7, 6000, 0, 2000).play();
            return;

        }

        if(pane2.getTranslateX() <= -4280 && pane2.getTranslateX() >= -4400) {

            System.out.println("check GroupOrc3 function");
            if(GroupOrc3.getTranslateY()<Hero.getTranslateY())
                death();
            else
                runTranslateTransition(GroupOrc3, 6000, 0, 2000).play();
            return;

        }






    }


    private static int score = 0;


    @FXML
    void click(MouseEvent event) throws InterruptedException {
        printCoordinateDetails();

        score++;

        ScoreLabel.setText(Integer.toString(score));

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

        if(checkFall((float) (Hero.getTranslateX()-pane2.getTranslateX()))) {
            death();
        }
        else {
            checkOrc();
        }

    }

    @FXML
    void click2(MouseEvent event) {
        System.out.println("DRAGGED");
        printCoordinateDetails();

        score+=2;

        ScoreLabel.setText(Integer.toString(score));

        if(firstClick)
        {
            Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                afterFirstClickTransition();
            }));
            InitializingAbyssStartingandEndingPosition();
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

        if(checkFall((float) (Hero.getTranslateX()-pane2.getTranslateX()))){
            death();
        }
        else{
            checkOrc();
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

    private void printCoordinateDetails(){
        System.out.println("hello");
        System.out.println("Hero Translate X: " + Hero.getTranslateX());
        System.out.println("Hero Translate Y: " + Hero.getTranslateY());
        System.out.println("Pane 2 Translate X: " + pane2.getTranslateX());
        System.out.println();
    }

    private void death(){
        System.out.println("death");
        runTranslateTransitionForHero(Hero, 0, 500, 2000).play();
    }

}
