package sample;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;


public class CommonAnimation {
    private static double speedX = 0.04;
    private static double speedY = 0.04;

    public static FadeTransition fade(Node n, double fadeval) {
        //Fade Duration Must be 1500
        //Setting Fades to 1 for Fast Testing
        FadeTransition fadeload = new FadeTransition();
        fadeload.setDuration(Duration.millis(1500));
        fadeload.setToValue(fadeval);
        fadeload.setNode(n);

        return fadeload;
    }
    public static FadeTransition fade(Node n, double fadeval,double time) {
        //Fade Duration Must be 1500
        //Setting Fades to 1 for Fast Testing
        FadeTransition fadeload = new FadeTransition();
        fadeload.setDuration(Duration.millis(time));
        fadeload.setToValue(fadeval);
        fadeload.setNode(n);

        return fadeload;
    }
    public static FadeTransition fade(Node n, double fadeval,double time , boolean reverse , int cyclecount) {
        //Fade Duration Must be 1500
        //Setting Fades to 1 for Fast Testing
        FadeTransition fadeload = new FadeTransition();
        fadeload.setDuration(Duration.millis(time));
        fadeload.setToValue(fadeval);
        fadeload.setNode(n);
        fadeload.setCycleCount(cyclecount);
        fadeload.setAutoReverse(reverse);

        return fadeload;
    }
    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        return load;
    }

    public static TranslateTransition runTranslateTransitionForHero(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        return load;
    }

    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration, int cycleCount, boolean reverse) {
        TranslateTransition load = new TranslateTransition();
        load.setByY(y);
        load.setByX(x);
        load.setNode(n);
        load.setCycleCount(cycleCount);
        load.setAutoReverse(reverse);
        load.setDuration(Duration.millis(duration));
        return load;
    }

    public static RotateTransition runRotateTransition(Node n, double a, double duration) {
        RotateTransition load = new RotateTransition();
        load.setNode(n);
        load.setByAngle(a);
        load.setDuration(Duration.millis(duration));
        return load;
    }

    public static RotateTransition runRotateTransition(Node n, double ang, double fromAng, double duration, int cycleCount, boolean rev) {
        RotateTransition load = new RotateTransition();
        load.setNode(n);
        load.setByAngle(ang);
        load.setCycleCount(cycleCount);
        load.setAutoReverse(rev);
        load.setFromAngle(fromAng);
        load.setDuration(Duration.millis(duration));
        return load;
    }

    public static Timeline delay(double time)
    {
        return new Timeline(new KeyFrame(Duration.millis(time), e -> { }));
    }

}
