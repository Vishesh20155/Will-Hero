package sample;

import javafx.scene.image.ImageView;

public abstract class Weapon extends GameObject {
    private int level = 1;
    private int damage;
    private int hitRange;

    public void upgradeWeapon(){

    }

    public abstract void hit(ImageView s);
}
