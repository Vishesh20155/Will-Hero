package sample;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sword extends Weapon{
    @Override
    public void hit(ImageView s) {
        System.out.println("hitting");
        Timeline rotate = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            CommonAnimation.runRotateTransition(s, 90, 500).play();
        }));

        Timeline rotateBack = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            CommonAnimation.runRotateTransition(s, 0, 500).play();
        }));

        Timeline push = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            CommonAnimation.runTranslateTransition(s, 120, 0, 500, 2, true).play();
        }));

        new SequentialTransition(CommonAnimation.delay(1000), rotate, push, rotateBack).play();
    }
}
