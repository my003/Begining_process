/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Describe the steps of timeline required for placing a bomb, exploding it, and disappearing.
*/
package Main;

import java.util.ArrayList;
import java.awt.Graphics;

public class BombAdapter {
    private GamePanel gamePanel;
    private int playerNumber;

    private int timeLife = 101;
    private ArrayList<Bomb> bombs;

    private int temp = 0;
    private int temp2;
    private Bomb tempBomb;

    private boolean isExplode = false;
    private int[][] map;
    private ArrayList<Block> blocks;


    public BombAdapter(GamePanel gamePanel, int playerNumber){
        this.gamePanel = gamePanel;
        map = gamePanel.getGame().getMap().getMapIndex();
        blocks = gamePanel.getGame().getMap().getMap();
        bombs = new ArrayList<>();
        this.playerNumber = playerNumber;
    }

    public void addBomb(){
        if (gamePanel.getGame().getPlayer(playerNumber).getBombs().size()>0 && timeLife>100){
            timeLife = 500;
            gamePanel.getGame().getPlayer(playerNumber).getBombs().get(0).setLocation(((gamePanel.getGame().getPlayer(playerNumber).x+21-45)/45), ((gamePanel.getGame().getPlayer(playerNumber).y+32-45)/45));
            tempBomb = gamePanel.getGame().getPlayer(playerNumber).getBombs().remove(0);
            bombs.add(tempBomb);
            gamePanel.getGame().getEntityRow(tempBomb.getRow()).add(tempBomb);
        }
    }

    public void reviseBomb(){
        if (bombs.size()>0) {timeLife--; sensor();}
        if (timeLife==100) {
            isExplode = true;
        }
        if (timeLife==0) {
            isExplode = false;
            while (bombs.size()>0)
            {bombs.get(0).setPermitCollide(true);
                bombs.get(0).resetExplosion();
                tempBomb = bombs.remove(0);
                gamePanel.getGame().getEntityRow(tempBomb.getRow()).remove(tempBomb);
                gamePanel.getGame().getPlayer(playerNumber).getBombs().add(tempBomb);}
            timeLife = 101;
        }
    }

    public void sensor(){
        for (Bomb bomb: bombs)
            if (bomb.getPermitCollide() && !bomb.isCollide(gamePanel.getGame().getPlayer(playerNumber).getRectangle())){
                bomb.setPermitCollide(false);
            }
    }

    public void drawExplosion(Graphics g){
        if (isExplode) setExplode(g);
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
        for (Block b: blocks){
            if (b.getX()==x && b.getY() == y) {b.setLocation(-1000, -1000); break;}
        }
    }

    public ArrayList<Bomb> getBombs(){
        return bombs;
    }

}