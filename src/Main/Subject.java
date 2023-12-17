package Main;

import java.util.ArrayList;

public class Subject {
    protected ArrayList<Block> fires;
    protected ArrayList<Block> ices;
    protected ArrayList<Block> items;
    protected ArrayList<Explosion> explosions;
    protected Player[] players = new Player[2];
    private int count = 0;

    public Subject(GamePanel gamePanel){
        fires = gamePanel.getGame().getMap().getFires();
        ices = gamePanel.getGame().getMap().getIces();
        items = gamePanel.getGame().getMap().getItems();
        explosions = new ArrayList<>();
        players[0] = gamePanel.getGame().getPlayer(1);
        players[1] = gamePanel.getGame().getPlayer(2);
        addExplosions();
    }

    private void addExplosions(){
        for (Bomb bomb: players[0].getBombs()) {
            explosions.add(bomb.getExplode2down());
            explosions.add(bomb.getExplode2up());
            explosions.add(bomb.getExplode2right());
            explosions.add(bomb.getExplode2left());
            explosions.add(bomb.getExplode3down());
            explosions.add(bomb.getExplode3up());
            explosions.add(bomb.getExplode3right());
            explosions.add(bomb.getExplode3left());
            explosions.add(bomb.getExplode4down());
            explosions.add(bomb.getExplode4up());
            explosions.add(bomb.getExplode4right());
            explosions.add(bomb.getExplode4left());
        }
        for (Bomb bomb: players[1].getBombs()) {
            explosions.add(bomb.getExplode2down());
            explosions.add(bomb.getExplode2up());
            explosions.add(bomb.getExplode2right());
            explosions.add(bomb.getExplode2left());
            explosions.add(bomb.getExplode3down());
            explosions.add(bomb.getExplode3up());
            explosions.add(bomb.getExplode3right());
            explosions.add(bomb.getExplode3left());
            explosions.add(bomb.getExplode4down());
            explosions.add(bomb.getExplode4up());
            explosions.add(bomb.getExplode4right());
            explosions.add(bomb.getExplode4left());
        }
    }

    protected void detatchItem(Block item){
        items.remove(item);
    }


    public void trapSensor(){
        for (Block ice: ices){
            ice.sensor(players[0].getRectangle(), 0);
            ice.sensor(players[1].getRectangle(), 1);
        }
        for (Block fire: fires){
            fire.sensor(players[0].getRectangle(), 0);
            fire.sensor(players[1].getRectangle(), 1);
        }
        count = 0;
        while (count<items.size()) {
            items.get(count).sensor(players[0].getRectangle(), 0);
            if (items.size()>count) items.get(count).sensor(players[1].getRectangle(), 1);
            count++;
        }
        for (Explosion explosion: explosions){
            explosion.sensor(players[0].getRectangle(), 0);
            explosion.sensor(players[1].getRectangle(), 1);
        }
    }

    protected void notifyPlayer(String trap, int i){
        players[i].setProperty(trap);
    }

    protected void explodePlayer(int damage, int i){
        players[i].beExploded(damage);
    }




}
