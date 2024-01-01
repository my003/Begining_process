package Main;

import GameState.Play;
import entity.Entity;

import java.util.ArrayList;
import java.awt.Graphics;

import static GameState.Play.resetCover;

public class CoverOrder {
    private GamePanel gamePanel;

    public void setEntityRow(ArrayList<Entity>[] entityRow) {
        this.entityRow = entityRow;
    }

    private ArrayList<Entity>[] entityRow;

    public ArrayList<Entity>[] getEntityRow1() {
        return entityRow;
    }
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
            //for (Entity entity:entityRow[i]) entity.render(g);
            while (temp<entityRow[i].size()) {entityRow[i].get(temp++).render(g);}
            temp = 0;
            if (gamePanel.getGame().getPlayer(1).getRow() == i) gamePanel.getGame().getPlayer(1).render(g);
            if (gamePanel.getGame().getPlayer(2).getRow() == i) gamePanel.getGame().getPlayer(2).render(g);
            if (gamePanel.getGame().getBoss(1).getRow() == i) gamePanel.getGame().getBoss(1).render(g);
            if (gamePanel.getGame().getBoss(2).getRow() == i) gamePanel.getGame().getBoss(2).render(g);

        }
    }
    public ArrayList<Entity> getEntityRow(int row){
        return entityRow[row];
    }
}