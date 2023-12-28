package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Main.*;
import UI.PauseOverPlay;
import entity.Boss;
import entity.Entity;
import entity.Player;

import javax.swing.*;

public class Play extends State implements Statemethods {
    private Player player1, player2;
    private Boss boss1, boss2;
    private Data data;
    private LoadMap load;
    private GamePanel gamePanel;
    private CoverOrder coverOrder;
    private GameWindow gameWindow;
    private PauseOverPlay pauseOverPlay;
    private boolean paused = false;

    public Play(Game game) {
        super(game);
        this.gamePanel = game.getGamePanel();
    }
    public void initGame(){
        load = new LoadMap(gamePanel);
        //initEntityOrder();
        coverOrder = new CoverOrder(gamePanel);
        player1 = new Player(40, 40, gamePanel, 1);
        player2 = new Player(675, 585, gamePanel, 2);
        boss1 = new Boss(100,40,gamePanel,1);
        boss2 = new Boss( 575,585,gamePanel,2);
        data = new Data(gamePanel);
        pauseOverPlay = new PauseOverPlay(this);
        initKeyBoard();
        this.gameWindow = game.getGameWindow();
    }
    private void initKeyBoard() {
        gamePanel.addKeyListener(player1.getKeyBoardInput());
        gamePanel.addKeyListener(player2.getKeyBoardInput());
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }

    @Override
    public void update() {
        if (!paused) {
            player1.update();
            player2.update();
            boss1.update();
            boss2.update();
            data.trapSensor();
        } else {
            pauseOverPlay.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        load.draw(g);
        coverOrder.render(g);
        if (paused)
            pauseOverPlay.draw(g);
    }
    public Player getPlayer(int n) {
        if (n == 1)
            return player1;
        return player2;
    }
    public Boss getBoss(int n){
        if (n == 1)
            return boss1;
        return boss2;
    }
    public LoadMap getMap() {
        return load;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Data getData() {
        return data;
    }

    public ArrayList<Entity> getEntityRow(int row) {
        return coverOrder.getEntityRow(row);
    }
    public void unpauseGame() {
        paused = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.g etButton() == MouseEvent.BUTTON1)
//            player.setAttacking(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                paused = !paused;
                break;
        }
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_A:
//                player.setLeft(true);
//                break;
//            case KeyEvent.VK_D:
//                player.setRight(true);
//                break;
//            case KeyEvent.VK_SPACE:
//                player.setJump(true);
//                break;
//            case KeyEvent.VK_BACK_SPACE:
//                GameStates.state = GameStates.MENU;
//                break;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) { if (paused) pauseOverPlay.mousePressed(e);}
    @Override
    public void mouseReleased(MouseEvent e) { if (paused) pauseOverPlay.mouseReleased(e); }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) { if (paused) pauseOverPlay.mouseMoved(e); }

//    public void windowFocusLost() {
//        player.resetDirBooleans();
//    }
    

}