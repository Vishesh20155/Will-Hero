package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private Hero hero;
    private boolean resurrectionDone = false;
    private Game game;
}
