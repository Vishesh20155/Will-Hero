package sample;

import javafx.scene.image.ImageView;

public abstract class Weapon extends GameObject {
    private int level = 1;
    private int damage;
    private int hitRange;

    public void upgradeWeapon(){

//        level++;
//        damage+=incDamage;
//        hitRange+=incRange;

    }
    protected int getDamage(){
        return damage;
    }

    public void setHitRange(int hitRange) {
        this.hitRange = hitRange;
    }
//    public void equals();

    public abstract void hit(ImageView s);
}
