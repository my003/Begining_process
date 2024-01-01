package Main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import static GameState.Play.resetCover;
import static GameState.Play.resetLoad;


public class LoadMap {
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public int[][] getMap1(){
        return map;
    }

    public ArrayList<Block> getIceTraps() {
        return iceTraps;
    }

    public ArrayList<Block> getFireTraps() {
        return fireTraps;
    }
    public int[][] getItem_trap() {
        return item_trap;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    private ArrayList<Block> blocks;

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public void setItems(ArrayList<Block> items) {
        this.items = items;
    }

    public void setIceTraps(ArrayList<Block> iceTraps) {
        this.iceTraps = iceTraps;
    }

    public void setFireTraps(ArrayList<Block> fireTraps) {
        this.fireTraps = fireTraps;
    }

    public void setItem_trap(int[][] item_trap) {
        this.item_trap = item_trap;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    private ArrayList<Block> items;
    private ArrayList<Block> iceTraps;
    private ArrayList<Block> fireTraps;
    private int[][] item_trap = Maps.Map.map_item_trap1;
    private int[][] map = Maps.Map.map1;
    private GamePanel gamePanel;        
    private int temp = 0;

    public LoadMap(GamePanel gamePanel){
        blocks = new ArrayList<>();
        items = new ArrayList<>();
        iceTraps = new ArrayList<>();
        fireTraps = new ArrayList<>();
        this.gamePanel = gamePanel;
        resetMap();
        createMap();
    }
    public void resetMap(){
        if (resetLoad){
            iceTraps.clear();
            fireTraps.clear();
            blocks.clear();
            items.clear();
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
            resetLoad = false;
        }
    }
    public void createMap() {
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
        // for (Block item: items){
        //     item.render(g);
        // }
        while (temp<items.size()) {items.get(temp++).render(g);}
        temp = 0;
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

    public void setMap(int[][] map){
        this.map = map;
    }
}