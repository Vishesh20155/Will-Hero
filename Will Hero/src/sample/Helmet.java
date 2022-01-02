package sample;

public class Helmet extends GameObject {
    private Sword sword;
    private Knife knife;
    private String color;
    public boolean isValidWeapon(Weapon weapon){
        if(weapon.getClass() == sword.getClass() || weapon.getClass() == knife.getClass()){
            return true;
        }
        return false;
    }
}
