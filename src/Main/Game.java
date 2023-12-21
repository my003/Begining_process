package Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private LoadMap load;

    private ArrayList<Entity>[] entityRow;

    private Player player1, player2;

    private Data data;

    public Game(){
        gamePanel = new GamePanel(this);
        load = new LoadMap(gamePanel);
        initEntityOrder();
        player1 = new Player(40, 40, gamePanel, 1);
        player2 = new Player(675, 585, gamePanel, 2);
        data = new Data(gamePanel);
        initKeyBoard();
        gameWindow = new GameWindow(gamePanel);
    }

    private void initEntityOrder() {
        entityRow = new ArrayList[13];
        for (int i=0; i<13; ++i){
            entityRow[i] = new ArrayList<>();
        }
        for (Block block:load.getMap()){
            entityRow[block.getRow()].add(block);
        }
    }

    private void initKeyBoard(){
        gamePanel.addKeyListener(player1.getKeyBoardInput());
        gamePanel.addKeyListener(player2.getKeyBoardInput());
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }

    // public void update(){
    //     player1.update();
    //     player2.update();
    //     data.trapSensor();
    // }

    public void update1(){
        player1.update();
    }

    public void update2(){
        player2.update();
    }

    public void update3(){
        data.trapSensor();
    }

    public void render(Graphics g){
        load.draw(g);
        for (int i=0; i<13; ++i){
            for (Entity entity:entityRow[i]) entity.render(g);
            if (player1.getRow() == i) player1.render(g);
            if (player2.getRow() == i) player2.render(g);
        }
    }

    public Player getPlayer(int n){
        if (n == 1)
        return player1;
        return player2;
    }

    public LoadMap getMap(){
        return load;
    }

    public GamePanel getGamePanel(){
        return gamePanel;
    }

    public ArrayList<Entity> getEntityRow(int row){
        return entityRow[row];
    }
}
