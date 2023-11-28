package Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class LoadMap {
    private ArrayList<Block> blocks;
    private ArrayList<Bomb> bombs;
    private int[][] map = Maps.Map.map1;

    private int temp = 0;
    private int temp2;
    private int temp3 = -1;
    private Bomb tempBomb;

    private boolean isExplode = false;
    private boolean isFind = false;

    public LoadMap(){
        blocks = new ArrayList<>();
        bombs = new ArrayList<>();
        createMap();
    }

    private void createMap() {
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
        for (Block block: blocks){
            block.render(g);
        }
        for (Bomb bomb: bombs){
            bomb.render(g);
        }
        if (isExplode) setExplode(g);
    }

    public ArrayList<Block> getMap(){
        return blocks;
    }

    public ArrayList<Bomb> getBombs(){
        return bombs;
    }

    public void setExplode(Graphics g){
        while (bombs.size()>temp){
            tempBomb = bombs.get(temp++);
            if (!tempBomb.getIsExploding())
            {
            tempBomb.setBangup(checkup(tempBomb.getX(), tempBomb.getY(), tempBomb.getRange()));
            tempBomb.setBangright(checkright(tempBomb.getX(), tempBomb.getY(), tempBomb.getRange()));
            tempBomb.setBangdown(checkdown(tempBomb.getX(), tempBomb.getY(), tempBomb.getRange()));
            tempBomb.setBangleft(checkleft(tempBomb.getX(), tempBomb.getY(), tempBomb.getRange()));}
            tempBomb.bang(g);
        }
        temp = 0;
    }


    private int checkright(int x, int y, int range){
        temp2 = 0;
        while (temp2<range) {
            if (x+temp2+1 == 15 || map[y][x+temp2+1] != 1) {break;}
            temp2++;
        }
        if (x+temp2+1 != 15 && map[y][x+temp2+1] == 3 && temp2<range) {removeBlock(x+temp2+1, y); map[y][x+temp2+1] = 1;}
        return temp2;
    }

    private int checkdown(int x, int y, int range){
        temp2 = 0;
        while (temp2<range) {
            if (y+temp2+1 == 13 || map[y+temp2+1][x] != 1) {break;}
            temp2++;
        }
        if (y+temp2+1 != 13 && map[y+temp2+1][x] == 3 && temp2<range) {removeBlock(x, y+temp2+1); map[y+temp2+1][x] = 1;}
        return temp2;
    }

    private int checkleft(int x, int y, int range){
        temp2 = 0;
        while (temp2<range) {
            if (x-temp2-1 == -1 || map[y][x-temp2-1] != 1) {break;}
            temp2++;
        }
        if (x-temp2-1 != -1 && map[y][x-temp2-1] == 3 && temp2<range) {removeBlock(x-temp2-1, y); map[y][x-temp2-1] = 1;}
        return temp2;
    }

    private int checkup(int x, int y, int range){
        temp2 = 0;
        while (temp2<range) {
            if (y-temp2-1 == -1 || map[y-temp2-1][x] != 1) {break;}
            temp2++;
        }
        if (y-temp2-1 != -1 && map[y-temp2-1][x] == 3 && temp2<range) {removeBlock(x, y-temp2-1); map[y-temp2-1][x] = 1;}
        return temp2;
    }

    public void removeBlock(int x, int y){
        isFind = false;
        for (Block b: blocks){
            temp3++;
            if (b.getX()==x && b.getY() == y) {isFind = true; break;}
        }
        if (isFind) blocks.remove(temp3);
        temp3 = -1;
        return;
    }

    public void setExplosion(boolean t){
        isExplode = t;
    }


}
