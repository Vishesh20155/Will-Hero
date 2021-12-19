package sample;

import javafx.geometry.Pos;

public class Position {
    private float x;
    private float y;
    public Position(float _x , float _y){
        x = _x;
        y = _y;
    }

    protected void setX(float x_cordinate){
        this.x = x_cordinate;
    }
    protected void setY(float y_cordinate){
        this.y = y_cordinate;
    }

    protected float getX(){
        return this.x;
    }

    protected float getY(){
        return this.y;
    }
}
