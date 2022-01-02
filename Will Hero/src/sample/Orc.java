package sample;

public abstract class Orc extends GameObject {
    private int HealthRemaining;
    private int KillReward;
    private int size;
    private String color;

    protected int getHealthRemaining() {
        return HealthRemaining;
    }
    protected void decreaseHealthRemaining(int x){
        this.HealthRemaining = this.HealthRemaining - x;
        if(this.HealthRemaining<0){
            this.HealthRemaining = 0;
        }
    }
    protected int getKillReward(){
        return KillReward;
    }
    protected void setKillReward(int x){
        this.KillReward = x;
    }
    protected void setHealthRemaining(int x){
        this.HealthRemaining = x;
    }
}
