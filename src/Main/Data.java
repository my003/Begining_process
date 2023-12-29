package Main;

public class Data extends Subject{

    public Data(GamePanel gamePanel){
        super(gamePanel);
        addData();
    }

    private void addData() {
        for (Block fire: fires){
            fire.setData(this);
        }
        for (Block ice: ices){
            ice.setData(this);
        }
        for (Block item: items){
            item.setData(this);
        }
        for (Explosion explosion: explosions){
            explosion.setData(this);
        }
    }

    public void trap(String trap, int i){
        notifyPlayer(trap, i);
    }

    public void explode(int damage, int i){
        explodePlayer(damage, i);
    }
}