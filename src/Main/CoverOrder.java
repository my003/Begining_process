/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose:
*/
package Main;

import entity.Entity;
import java.util.ArrayList;
import java.awt.Graphics;

public class CoverOrder {
    private GamePanel gamePanel;
    private ArrayList<Entity>[] entityRow;

    private int temp = 0;

    public CoverOrder(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        initEntityOrder();
    }

    public void initEntityOrder() {
        entityRow = new ArrayList[13];
        for (int i=0; i<13; ++i){
            entityRow[i] = new ArrayList<>();
        }
        for (Block block:gamePanel.getGame().getMap().getMap()){
            entityRow[block.getRow()].add(block);
        }
    }
    public void render(Graphics g){
        for (int i=0; i<13; ++i){
            while (temp<entityRow[i].size()) {entityRow[i].get(temp++).render(g);}
            temp = 0;
            if (gamePanel.getGame().getPlayer(1).getRow() == i) gamePanel.getGame().getPlayer(1).render(g);
            if (gamePanel.getGame().getPlayer(2).getRow() == i) gamePanel.getGame().getPlayer(2).render(g);

        }
    }
    public ArrayList<Entity> getEntityRow(int row){
        return entityRow[row];
    }
}