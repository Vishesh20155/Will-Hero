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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static sample.CommonAnimation.*;

public class MainGame extends Application implements Initializable {

    //Checking again

    private ArrayList<Position> AbyssStartingPostion = new ArrayList<Position>();
    private ArrayList<Position> AbyssEndingPosition = new ArrayList<Position>();



    private void InitializingAbyssStartingandEndingPosition(){
        Position p1_s = new Position(860,0);
        Position p1_e = new Position(960,0);
        AbyssStartingPostion.add(p1_s);
        AbyssEndingPosition.add(p1_e);
        Position p2_s = new Position(1140,0);
        Position p2_e = new Position(1260,0);
        AbyssStartingPostion.add(p2_s);
        AbyssEndingPosition.add(p2_e);
        Position p3_s = new Position(1580,0);
        Position p3_e = new Position(1670,0);
        AbyssStartingPostion.add(p3_s);
        AbyssEndingPosition.add(p3_e);
        Position p4_s = new Position(2090,0);
        Position p4_e = new Position(2090,0);
        AbyssStartingPostion.add(p4_s);
        AbyssEndingPosition.add(p4_e);
        Position p5_s = new Position(2360,0);
        Position p5_e = new Position(2399,0);
        AbyssStartingPostion.add(p5_s);
        AbyssEndingPosition.add(p5_e);
        Position p6_s = new Position(2610,0);
        Position p6_e = new Position(2697,0);
        AbyssStartingPostion.add(p6_s);
        AbyssEndingPosition.add(p6_e);
        Position p7_s = new Position(3010,0);
        Position p7_e = new Position(3100,0);
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
        Position p10_e = new Position(4378,0);
        AbyssStartingPostion.add(p10_s);
        AbyssEndingPosition.add(p10_e);



    }


    private boolean firstClick = true;
    private static Parent p_root;
    private static Stage myStage;
    private static Scene getCurrentScene;
    private static LoadSavedGameController currentSceneController;
    private Hero heroObject = new Hero();
    private Player player = new Player();
    private Sword sword1 = new Sword();
    private Knife knife1 = new Knife();
    private Knife knife2 = new Knife();
    private boolean groupOrc1Dead = false;
    private TNT tnt1 = new TNT();
    private TNT tnt2 = new TNT();
    private ArrayList<Float> AbyssList = new ArrayList<Float>();
    private boolean AbyssFallorNot = false;

    @FXML
    private Group Hero;

    @FXML
    private ImageView HeroOnly;

    @FXML
    private ImageView Sword;

    @FXML
    private ImageView Knife;

    @FXML
    private ImageView Knife2;

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

    //@FXML
    //private ImageView Orc4;

    @FXML
    private ImageView Orc5;

    @FXML
    private ImageView Orc6;

    @FXML
    private Group GroupOrc3;


    @FXML
    private ImageView Orc7;

    @FXML
    private Group CoinGroup;

    @FXML
    private Group CoinGroup1;

    @FXML
    private Text CoinNumberText;

    @FXML
    private Text displayText;

    @FXML
    private ImageView chest1closed;

    @FXML
    private ImageView chest1open;


    @FXML
    private ImageView chest2closed;

    @FXML
    private ImageView chest2open;

    @FXML
    private ImageView chest3closed;

    @FXML
    private ImageView chest3open;

    @FXML
    private ImageView chest4closed;

    @FXML
    private ImageView chest4open;

    @FXML
    private ImageView chest5closed;

    @FXML
    private ImageView chest5open;

    @FXML
    private ImageView chest6closed;

    @FXML
    private ImageView chest6open;


    @FXML
    private ImageView TNT1;

    @FXML
    private Circle ExplosionCloud1;

    @FXML
    private Circle ExplosionCloud11;

    @FXML
    private ImageView TNT2;

    private static double position;
    private static int coinNumber = 0;



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
        //runTranslateTransition(Orc4, 0, -100, 600, Timeline.INDEFINITE, true).play();
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

    int noOfClicks = 0;

    private void InitaialiseAbyssList(){
        AbyssList.add(-360F);
        AbyssList.add(-600F);
        AbyssList.add(-960F);
        AbyssList.add(-1400F);
        AbyssList.add(-1800F);
//        AbyssList.add(-2280F);
        AbyssList.add(-2400F);
        AbyssList.add(-2760F);
        AbyssList.add(-3360F);
        AbyssList.add(-3720F);
        AbyssList.add(-4080F);
        AbyssList.add(-5400F);
        AbyssList.add(-5520F);
        AbyssList.add(-6120F);
    }

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

    void checkChest(){
        if(pane2.getTranslateX() == -600){
            fade(chest1closed, 0, 500).play();
            fade(chest1open, 1, 500).play();
            heroObject.setWeapon(knife1);
            displayText.setText("Equipped Knife");
            fade(displayText, 1, 1000, true, 4).play();
            Knife.setOpacity(1);
            score+=4;
            return;
        }

        if(pane2.getTranslateX() == -1560 ){
            fade(chest2closed, 0, 500).play();
            fade(chest2open, 1, 500).play();
            heroObject.setWeapon(sword1);
            Knife.setOpacity(0);
            sword1.hit(Sword);
            displayText.setText("Equipped Sword");
            fade(displayText, 1, 1000, true, 4).play();
            Sword.setOpacity(1);
            runTranslateTransition(GroupOrc2, 6000, 0, 2000).play();
            score+=4;
            return;
        }

        if(pane2.getTranslateX() == -2280){
            fade(chest3closed, 0, 500).play();
            fade(chest3open, 1, 500).play();
            CoinChest coinChest = new CoinChest();
            displayText.setText("Received " + coinChest.getNumCoins() + "coins!!");
            fade(displayText, 1, 1000, true, 4).play();
            heroObject.updateCoins(coinChest.getNumCoins());
            CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + coinChest.getNumCoins()));
            coinNumber += coinChest.getNumCoins();
            runTranslateTransition(CoinGroup, 0, -300, 2000).play();
            fade(CoinGroup, 1, 300, true, 6).play();
            score+=10;
            return;
        }


        if( pane2.getTranslateX() == -3840){
            fade(chest4closed, 0, 500).play();
            fade(chest4open, 1, 500).play();
            heroObject.getWeapon().upgradeWeapon();
            displayText.setText("Upgraded Sword");
            Knife.setOpacity(0);
            fade(displayText, 1, 1000, true, 4).play();
            Sword.setFitHeight(80);
            return;
        }

        if( pane2.getTranslateX() == -4800){
            fade(chest5closed, 0, 500).play();
            fade(chest5open, 1, 500).play();
            Sword.setOpacity(0);
            heroObject.setWeapon(knife2);
            displayText.setText("Equipped Knife ");
            fade(displayText, 1, 1000, true, 4).play();
            Knife2.setOpacity(1);
            score+=4;
            return;
        }

        if(pane2.getTranslateX() == -6240){
            fade(chest6closed, 0, 500).play();
            fade(chest6open, 1, 500).play();
            CoinChest coinChest = new CoinChest();
            displayText.setText("Received " + coinChest.getNumCoins() + "coins!!");
            fade(displayText, 1, 1000, true, 4).play();
            heroObject.updateCoins(coinChest.getNumCoins());
            CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + coinChest.getNumCoins()));
            coinNumber += coinChest.getNumCoins();
            runTranslateTransition(CoinGroup1, 0, -300, 2000).play();
            fade(CoinGroup1, 1, 300, true, 6).play();
            score+=10;
            return;
        }
    }

    private void checkAttack(){
        if(pane2.getTranslateX() == -1080){
            knife1.hit(Knife);
            if(Hero.getTranslateY()-GroupOrc1.getTranslateY() < -40) {
                System.out.println("hitting group failed");
                return;
            }
            else
            {
                System.out.println("hitting group");
                groupOrc1Dead = true;
                runTranslateTransition(GroupOrc1, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 4));
                coinNumber += 4;
            }

        }

        if(pane2.getTranslateX() == -4920){
            knife2.hit(Knife2);
            if(Hero.getTranslateY()-Orc6.getTranslateY() < -40) {
                System.out.println("hitting Orc6 failed");
                return;
            }
            else
            {
                System.out.println("hitting Orc6");
                //Fix groupOrc1 variable
                groupOrc1Dead = true;
                runTranslateTransition(Orc6, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 4));
                coinNumber += 4;
            }

        }
    }

    void checkObstacle(){
        if(pane2.getTranslateX() == -2520){
            tnt1.explode(TNT1, ExplosionCloud1);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    fade(ExplosionCloud1, 0.8, 500).play();
                    if (pane2.getTranslateX() >= -2760){
                        System.out.println("death from tnt");
                        death();
                    }
                }
            }, 3000);
        }

        if(pane2.getTranslateX() == -5760){
            tnt2.explode(TNT2, ExplosionCloud11);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    fade(ExplosionCloud11, 0.8, 500).play();
                    if (pane2.getTranslateX() >= -6000){
                        System.out.println("death from tnt");
                        death();
                    }
                }
            }, 3000);
        }
    }

    void checkAbyss(float x){
//        if ((k = pane2.getTranslateX()) == -600){         //checkAbyss(k = pane2.getTranslateX)
//            System.out.println("at abyss");
//            Timer t = new Timer();
//            t.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println("inside timer thread");
//                    if(pane2.getTranslateX() >= k-120){
//                        System.out.println("inside timer thread 2");
//                        System.out.println(pane2.getTranslateX());
//                        death();
//                    }
//                }
//            }, 1000);
//        }
        for(int i = 0 ; i<AbyssList.size() ; i++){
            float AbyssCoordinate = AbyssList.get(i);
            if(AbyssCoordinate == x){
                System.out.println("At Abyss");
                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Inside timer thread");
                        if(pane2.getTranslateX() >= AbyssCoordinate-120){
                            System.out.println("Inside timer thread 2");
                            System.out.println(x);
                            //AbyssFallorNot = true;
                            death();

                        }
                    }
                } , 1000);
            }
        }
        //return AbyssFallorNot;

        }


    void checkOrc(){
        if(pane2.getTranslateX() == -240) {
            System.out.println("check orc function");
            if(Orc1.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                runTranslateTransition(Orc1, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber+=2;
                score+=3;
            }
            return;
        }

        if(Hero.getTranslateX()==360 && pane2.getTranslateX() == 0) {
            System.out.println("check orc2 function");
            if(Orc2.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                runTranslateTransition(Orc2, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber += 2;
                score+=3;
            }
            return;
        }

        // Changed the group orc 1 to a better coordinate

        if(pane2.getTranslateX() == -1080) {

            System.out.println("check GroupOrc1 function");
            if(GroupOrc1.getTranslateY()<Hero.getTranslateY() && (GroupOrc1.getTranslateX() == -1080))
                death();
            else {
                runTranslateTransition(GroupOrc1, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 4));
                coinNumber += 4;
                score+=3;
            }
            return;

        }

        if(pane2.getTranslateX() <= -1040 && pane2.getTranslateX() >= -1140) {

            System.out.println("check GroupOrc2 function");
            if(GroupOrc2.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                runTranslateTransition(GroupOrc2, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 4));
                coinNumber += 4;
                score+=3;
            }
            return;

        }
//        if(pane2.getTranslateX() <= -1540 && pane2.getTranslateX() >= -1640) {
//
//            System.out.println("check GroupOrc2 function");
//            if(GroupOrc2.getTranslateY()<Hero.getTranslateY())
//                death();
//            else
//                runTranslateTransition(GroupOrc2, 6000, 0, 2000).play();
//            return;
//
//        }

        if(pane2.getTranslateX() == -1920) {

            System.out.println("check Orc3 function");
            if(Orc3.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    sword1.hit(Sword);
                }));
                Timeline next = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    runTranslateTransition(Orc3, 6000, 0, 2000).play();
                }));
                new SequentialTransition(intro, next).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber +=2;
                score+=3;
            }
            return;

        }


//        if(pane2.getTranslateX() <= -2500 && pane2.getTranslateX() >= -2600) {
//
//            System.out.println("check Orc4 function");
//            if(Orc4.getTranslateY()<Hero.getTranslateY())
//                death();
//            else
//                //runTranslateTransition(Orc4, 6000, 0, 2000).play();
//            return;
//
//        }

        if(pane2.getTranslateX() == -3000) {

            System.out.println("check Orc5 function");
            if(Orc5.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    sword1.hit(Sword);
                }));
                Timeline next = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    runTranslateTransition(Orc5, 6000, 0, 2000).play();
                }));
                new SequentialTransition(intro, next).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber +=2;
                score+=3;
            }
            return;

        }

        if(pane2.getTranslateX() == -5040) {

            System.out.println("check Orc6 function");
            if(Orc6.getTranslateY()<Hero.getTranslateY() && Orc6.getTranslateX() == -5040)
                death();
            else {
                runTranslateTransition(Orc6, 6000, 0, 2000).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber += 2;
                score+=3;
            }
            return;

        }

        if(pane2.getTranslateX() == -3480) {

            System.out.println("check Orc7 function");
            if(Orc7.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    sword1.hit(Sword);
                }));
                Timeline next = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    runTranslateTransition(Orc7, 6000, 0, 2000).play();
                }));
                new SequentialTransition(intro, next).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber +=2;
                score+=3;
            }
            return;

        }

        if(pane2.getTranslateX() == -4320) {

            System.out.println("check GroupOrc3 function");
            if(GroupOrc3.getTranslateY()<Hero.getTranslateY())
                death();
            else {
                Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    sword1.hit(Sword);
                }));
                Timeline next = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                    runTranslateTransition(GroupOrc3, 6000, 0, 2000).play();
                }));
                new SequentialTransition(intro, next).play();
                CoinNumberText.setText(Integer.toString(Integer.parseInt(CoinNumberText.getText()) + 2));
                coinNumber +=2;
                score+=3;
            }
            return;

        }

    }

    private static int score = 0;

/*
    @FXML
    void click(MouseEvent event) throws InterruptedException {
//        printCoordinateDetails();

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
            checkChest();
            checkAttack();
            checkObstacle();
        }
        printCoordinateDetails();
        if (pane2.getTranslateX() == -600){
            System.out.println("at -600");
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("inside timer thread");
                    if(pane2.getTranslateX() >= -720){
                        System.out.println("inside timer thread 2");
                        System.out.println(pane2.getTranslateX());
                        death();
                    }
                }
            }, 1000);
        }
    }
    */

    @FXML
    void click(MouseEvent event) throws InterruptedException {
//        printCoordinateDetails();

        score++;

        ScoreLabel.setText(Integer.toString(score));
        CoinNumberText.setText(Integer.toString(coinNumber));


        if(firstClick)
        {
            // Initialize abyssListNew()
            InitaialiseAbyssList();
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
                    moveScreen();
                }));
                new SequentialTransition(intro).play();
            }
        }
        double k;

//        if ((k = pane2.getTranslateX()) == -600){         //checkAbyss(k = pane2.getTranslateX)
//            System.out.println("at abyss");
//            Timer t = new Timer();
//            t.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println("inside timer thread");
//                    if(pane2.getTranslateX() >= k-120){
//                        System.out.println("inside timer thread 2");
//                        System.out.println(pane2.getTranslateX());
//                        death();
//                    }
//                }
//            }, 1000);
//        }

        //else
        {
            checkOrc();
            checkChest();
            checkAttack();
            checkObstacle();
            checkAbyss((float) pane2.getTranslateX());
        }
        printCoordinateDetails();

    }


    @FXML
    void click2(MouseEvent event) {
        System.out.println("DRAGGED");

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
            checkChest();
            checkAttack();
            checkObstacle();
        }
        printCoordinateDetails();
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
        position = pane2.getTranslateX();
        System.out.println("position " + position);
        System.out.println();
    }

    private void death(){
        System.out.println("death");
        runTranslateTransitionForHero(Hero, 0, 500, 2000).play();
    }

    public static double getHeroPosition(){
        return position;
    }

    public static int getGameScore(){
        return score;
    }

    public static int getGameCoins(){
        return coinNumber;
    }

    private void loadGameTransition(double pos){
        runTranslateTransition(Hero, pos, 0, 1000).play();
        runTranslateTransition(pane2, pos, 0, 1000).play();
    }

    private boolean prevGame = false;
    private double savedGamePosition = 0;

    public void setUpGame(double pos, int sc, int co){
        prevGame = true;
        System.out.println("Details: " + pos + " " + sc +  " " + co);
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            loadGameTransition(pos);
        }));

        new SequentialTransition(CommonAnimation.delay(1000), intro).play();
        score = sc;
        coinNumber = co;

//        CoinNumberText.setText(Integer.toString(co));
//        ScoreLabel.setText(Integer.toString(sc));
        savedGamePosition = pos;

        System.out.println("INSIDE");
    }
}
