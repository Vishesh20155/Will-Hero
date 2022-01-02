package sample;

import java.io.Serializable;

public class GameObject implements Serializable {
    private int id;
    protected Position position;
    protected Position getPosition(){
        return this.position;
    }
    public boolean collision(){
        return true;
    }
}
