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
    private Image menu, reset, sound_music_on, sound_music_off, sound_effect_on, sound_effect_off, pause;

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
    public void importImg(){
        menu = new ImageIcon(this.getClass().getResource("ui/bghome.")).getImage();
        reset = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
        sound_music_on = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
        sound_music_off = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
        sound_effect_on = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
        sound_effect_off = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
        pause = new ImageIcon(this.getClass().getResource("ui/bghome.png")).getImage();
    }

    public void drawSubWindow(int x, int y, int width, int height, Graphics g2) {
        // mousePressed(e);
        // mouseClicked(e);
        Color color = new Color(0, 0, 0, 186);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2.setColor(color);
        //g2.setXORMode(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }
    public void drawPauseScreen(Graphics2D g2) {
        g2.setColor(Color.white);
        // g2.setFont(g2.getFont().deriveFont(40F));
        int frameX = (int) (48 * 5.5);
        int frameY = 48 * 4;
        int frameWidth = (int) (48 * 9.5);
        int frameHeight = (int) (48 * 7.5);
        drawSubWindow(frameX, frameY, frameWidth, frameHeight,g2);
        option_top(frameX, frameY,g2);
    }
    public int getXForCenteredText(String text, Graphics g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = 960 / 2 - length / 2;
        return x;
    }
    public void draw_pause(int textX, int textY,Graphics g2) {
        g2.drawImage(pause, textX, textY - 70, 48, 48, null); // method to draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
    }
    public void option_top(int frameX, int frameY, Graphics g2) {
        int textX;
        int textY;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        int titlesize = 48 + 10;
        // Title
        String text = "PAUSE";
        textX = getXForCenteredText(text,g2) - 10;
        textY = frameY;
        g2.drawString(text, textX + 10, textY + 48);
        g2.setFont(g2.getFont().deriveFont(20F));

        // Reset Room
        textX = frameX + 48;
        textY += 48 * 2;
        g2.drawString("Reset", textX + 70, textY + 48);
        g2.drawImage(reset, textX + 70, textY + 48 - 70, titlesize - 10, titlesize - 10, null); // method
        // to
        // draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY += 48;
        textX += 70;

        // Home
        textY += 48 * 2;
        g2.drawString("Home", textX + 150, textY - 48 * 2);
        // g2.drawString("Home", textX,textY);
        g2.drawImage(menu, textX + 150, textY - 48 * 2 - 70, titlesize - 10, titlesize - 10, null); // method
        // to
        // draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textX += 150;

        // Continue
        // textY += frameY;
        text = "Continue";
        textY += 50;
        //textX = getXForCenteredText(text) - 10;
        g2.drawString("Continue", textX + 10, textY - 50);
        //g2.drawImage(cont, textX + 20, textY - 120, titlesize - 10, titlesize - 10, null); // method to draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY -= 50;

        // Music
        text = "Music";
        textX = frameX + 48;
        g2.drawImage(sound_music_on, textX + 70, textY + 48 * 2 - 70, titlesize - 10, titlesize - 10,
                null); // method to draw

//        if (commandNum_music == 1) {
//            g2.drawString("Music: ON", textX + 60, textY + 48 * 2);
//            g2.drawImage(sound_music_on, textX + 70, textY + 48 * 2 - 70, titlesize - 10, titlesize - 10,
//                    null); // method to draw
//        }
//        if (commandNum_music == 2) {
//            g2.drawString("Music: OFF", textX + 60, textY + 48 * 2);
//            g2.drawImage(sound_music_off, textX + 70, textY + 48 * 2 - 70, titlesize - 10,
//                    titlesize - 10, null); // method to draw
//        }
        textX += 70;
        // System.out.println("textX: " + textX + " - " + "textY" + textY);

        // Effect
        g2.drawString("Effect: ON", textX + 135, textY + 48 * 2);
        g2.drawImage(sound_effect_on, textX + 150, textY + 48 * 2 - 70, titlesize - 10,
                titlesize - 10, null); // method to draw
//        if (commandNum_effect == 3) {
//            g2.drawString("Effect: ON", textX + 135, textY + 48 * 2);
//            g2.drawImage(sound_effect_on, textX + 150, textY + 48 * 2 - 70, titlesize - 10,
//                    titlesize - 10, null); // method to draw
//        }
//        if (commandNum_effect == 4) {
//            g2.drawString("Effect: OFF", textX + 135, textY + 48 * 2);
//            g2.drawImage(sound_effect_off, textX + 150, textY + 48 * 2 - 70, titlesize - 10,
//                    titlesize - 10, null); // method to draw
//        }
        textX += 150;
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY += 48 * 2;
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


    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getButton() == MouseEvent.BUTTON1){
//            player1.setAttacking(true); }
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
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

//    public void windowFocusLost() {
//        player.resetDirBooleans();
//    }
    

}