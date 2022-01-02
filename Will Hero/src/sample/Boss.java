package sample;

import javafx.scene.Node;

import javax.swing.text.html.ImageView;
import java.util.Timer;
import java.util.TimerTask;

import static sample.CommonAnimation.runTranslateTransition;

public class Boss extends Orc{
    void BossOrcForwardMovement(Node boss){
        runTranslateTransition(boss , -60 , -60 , 300).play();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {

                               runTranslateTransition(boss , -60 , 60 , 300  ).play();


                           }
                       }
                , 300);



    }
    void BossBackwardMovement(Node boss){

        runTranslateTransition(boss , 60 , -60 , 300).play();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {

                               runTranslateTransition(boss , 60 , 60 , 300  ).play();


                           }
                       }
                , 300);




    }
}
