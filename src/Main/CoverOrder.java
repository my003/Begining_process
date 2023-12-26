package Main;

import java.util.ArrayList;
import java.awt.Graphics;

public class CoverOrder {
    private GamePanel gamePanel;
    private ArrayList<Entity>[] entityRow;

    public CoverOrder(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        initEntityOrder();
    }

    private void initEntityOrder() {
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
            for (Entity entity:entityRow[i]) entity.render(g);
            if (gamePanel.getGame().getPlayer(1).getRow() == i) gamePanel.getGame().getPlayer(1).render(g);
            if (gamePanel.getGame().getPlayer(2).getRow() == i) gamePanel.getGame().getPlayer(2).render(g);
        }
    }

    public ArrayList<Entity> getEntityRow(int row){
        return entityRow[row];
    }
}