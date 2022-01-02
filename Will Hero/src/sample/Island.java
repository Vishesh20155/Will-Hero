package sample;

import javafx.scene.image.ImageView;

public class Island extends GameObject {

    private Position startPosition;
    private Position endPosition;
    private ImageView img;

    protected Position getStartPosition() {
        return startPosition;
    }

    protected Position getEndPosition() {
        return endPosition;
    }

//    public Island(Position start, Position end){
////        img.setImage();
//    }

}
