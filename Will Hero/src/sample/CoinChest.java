package sample;

public class CoinChest extends Chest{
    private int NumCoins;

    public CoinChest(){
        this.NumCoins = 23;
    }

    protected int getNumCoins(){
        return this.NumCoins;
    }

    @Override
    public void openChest() {

    }
}
