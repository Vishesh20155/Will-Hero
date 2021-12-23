package sample;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TNT extends Obstacles{
    private int explosionRadius;
    private int TimetoExplode;

    public void explode(ImageView i, Circle c){
        CommonAnimation.runRotateTransition(i, 40, -20, 150,20,true).play();
    }
}
