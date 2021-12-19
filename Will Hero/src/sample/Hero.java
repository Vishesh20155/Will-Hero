package sample;

public class Hero extends GameObject {
    private int jumpHeight;
    private int movingForwardLength;
    private int coins;
    private Weapon weapon;
    private Helmet helmet;

    public Hero(){
        this.position.setY(0);
        this.position.setX(0);
    }

    public void updatePosition(float x, float y){
        this.position.setX(x + this.position.getX());
        this.position.setY(y + this.position.getY());
    }

}
