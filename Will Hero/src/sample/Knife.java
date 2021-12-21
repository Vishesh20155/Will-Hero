package sample;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Knife extends Weapon{
    @Override
    public void hit(ImageView s) {
//        System.out.println("hitting");

        Timeline push = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            CommonAnimation.runTranslateTransition(s, 5500, 0, 1000, 1, true).play();
        }));

        new SequentialTransition(push).play();
    }
}
