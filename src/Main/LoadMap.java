package Main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class LoadMap {
    private ArrayList<Block> blocks;
    private ArrayList<Block> items;
    private ArrayList<Block> iceTraps;
    private ArrayList<Block> fireTraps;
    private int[][] item_trap = Maps.Map.map_item_trap1;
    private int[][] map = Maps.Map.map1;
    private GamePanel gamePanel;

    public LoadMap(GamePanel gamePanel){
        blocks = new ArrayList<>();
        items = new ArrayList<>();
        iceTraps = new ArrayList<>();
        fireTraps = new ArrayList<>();
        this.gamePanel = gamePanel;
        createMap();
    }

    private void createMap() {
        Random random = new Random();
        for (int i = 0; i<13; ++i)
            for (int j = 0; j<15; ++j){
                switch (item_trap[i][j]) {
                    case 8:
                        items.add(BlockStore.createItem_Trap("Bomb", j, i));
                        break;
                    case 9:
                        items.add(BlockStore.createItem_Trap("Shoe", j, i));
                        break;
                    case 6:
                        items.add(BlockStore.createItem_Trap("Drug", j, i));
                        break;
                    case 5:
                        fireTraps.add(BlockStore.createItem_Trap("Fire", j, i));
                        break;
                    case 7:
                        iceTraps.add(BlockStore.createItem_Trap("Ice", j, i));
                        break;
                    default:
                        break;
                }
            }

        for (int i = 0; i<13; ++i)
            for (int j = 0; j<15; ++j){
                if (map[i][j] == 3)
                    switch (random.nextInt(6)) {
                        case 1:
                            items.add(BlockStore.createItem_Trap("Drug", j, i));
                            break;
                        case 2:
                            items.add(BlockStore.createItem_Trap("Shoe", j, i));
                            break;
                        case 3:
                            items.add(BlockStore.createItem_Trap("Bomb", j, i));
                            break;
                        default:
                            break;
                    }
            }

        for (int i = 0; i<13; ++i)
            for (int j = 0; j<15; ++j){
                switch (map[i][j]) {
                    case 3:
                        blocks.add(BlockStore.createBlock("Wood", j, i));
                        break;
                    case 4:
                        blocks.add(BlockStore.createBlock("Stone", j, i));
                        break;
                    default:
                        break;
                }
            }
    }

    public void draw(Graphics g){
        for (Block ice: iceTraps){
            ice.render(g);
        }
        for (Block fire:fireTraps){
            fire.render(g);
        }
        gamePanel.getGame().getPlayer(1).getBombAdapter().drawExplosion(g);
        gamePanel.getGame().getPlayer(2).getBombAdapter().drawExplosion(g);
        for (Block item: items){
            item.render(g);
        }
        // for (Block block: blocks){
        //     block.render(g);
        // }
    }

    public ArrayList<Block> getMap(){
        return blocks;
    }

    public ArrayList<Bomb> getBombs(int playerNumber){
        return gamePanel.getGame().getPlayer(playerNumber).getBombAdapter().getBombs();
    }

    public ArrayList<Block> getFires(){
        return fireTraps;
    }

    public ArrayList<Block> getIces(){
        return iceTraps;
    }

    public ArrayList<Block> getItems(){
        return items;
    }

    public int[][] getMapIndex(){
        return map;
    }

    public void setMapIndex(int x, int y, int value){
        map[x][y] = value;
    }
    public int getIndex(int x, int y){
        return map[x][y];
    }

}