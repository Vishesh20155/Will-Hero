package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private Hero hero;
    private boolean resurrectionDone = false;
    private Game game;
    private int coins;

    public void Resurrect(){

    }
    public void useCoins(){

    }
    protected int getCoins(){
        return coins;
    }
}
