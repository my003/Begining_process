package Main;

import static GameState.Play.resetData;

public class Data extends Subject{

    public Data(GamePanel gamePanel){
        super(gamePanel);
        addData();
    }

    public void addData() {
        if (resetData){
            fires.clear();
            ices.clear();
            items.clear();
            explosions.clear();
            resetData = false;
        }
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