package sample;

public class Hero extends GameObject {
    private int jumpHeight;
    private int movingForwardLength;
    private int coins;
    private Weapon weapon;
    private Helmet helmet;

    public Hero(){
        this.coins = 0;
    }

    public void moveForward(){

    }

    public void updatePosition(float x, float y){

    }
//    protected Position getPosition()

    protected void setWeapon(Weapon w){
        this.weapon = w;
    }

    protected void updateCoins(int c){
        this.coins += c;
    }

    protected int getCoins(){
        return this.coins;
    }

    protected Weapon getWeapon(){
        return this.weapon;
    }
    public void fallfromAbyss(){

    }

}
