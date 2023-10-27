package Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class LoadMap {
    private ArrayList<Block> blocks;
    private int[][] map = Maps.Map.map1;
    public LoadMap(){
        blocks = new ArrayList<>();
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
    }

}
