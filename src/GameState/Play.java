/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: following the concept of implement from Statemethod and extend from State
*/

package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Main.*;
import UI.*;
import entity.Entity;
import entity.Player;

public class Play extends State implements Statemethods {
    private Player player1, player2;
    private Data data;
    public LoadMap load;
    private GamePanel gamePanel;
    private CoverOrder coverOrder;
    private GameWindow gameWindow;
    private PauseOverPlay pauseOverPlay;
    static boolean paused = false;
    public static int commandNum_music = 0, commandNum_effect = 0;
    public static int winner = 0;
    private SoundButton soundButton;
    private MusicButton musicButton;
    private Buttons exit, unpause;
    public Play(Game game) {
        super(game);
        this.gamePanel = game.getGamePanel();
    }
    public void initGame(){
        load = new LoadMap(gamePanel);
        coverOrder = new CoverOrder(gamePanel);
        player1 = new Player(40, 40, gamePanel, 1);
        player2 = new Player(675, 585, gamePanel, 2);
        data = new Data(gamePanel);
        createButtons();
        pauseOverPlay = new PauseOverPlay(this);
        initKeyBoard();
        initMouse();
        this.gameWindow = game.getGameWindow();
    }
    private void initKeyBoard() {
        gamePanel.addKeyListener(player1.getKeyBoardInput());
        gamePanel.addKeyListener(player2.getKeyBoardInput());
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }

    private void initMouse(){
        gamePanel.addMouseListener(this);
    }
    @Override
    public void update() {
        if (winner == 0)
            if (paused)
                pauseOverPlay.update();
            else
            {

                player1.update();
                player2.update();
                data.trapSensor();
                musicButton.update();
                soundButton.update();

                exit.update();
                unpause.update();
            }
    }
    @Override
    public void draw(Graphics g) {
        if (winner == 0)
            if (paused)
                pauseOverPlay.draw(g);
            else {
                load.draw(g);
                coverOrder.render(g);

                // Sound buttons
                musicButton.draw(g);
                soundButton.draw(g);

                // Buttons
                exit.draw(g);
                unpause.draw(g);
                loaddata(g);
            }
    }
    public Player getPlayer(int n) {
        if (n == 1)
            return player1;
        return player2;
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
    private void loaddata(Graphics g){
        String bom1 = String.valueOf(gamePanel.getGame().getPlayer(1).getBombs().size());
        String bom2 = String.valueOf(gamePanel.getGame().getPlayer(2).getBombs().size());
        String health1 = String.valueOf(gamePanel.getGame().getPlayer(1).getBarHealth());
        String health2 = String.valueOf(gamePanel.getGame().getPlayer(2).getBarHealth());
        String drug1 = String.valueOf(gamePanel.getGame().getPlayer(1).getDrug());
        String drug2 = String.valueOf(gamePanel.getGame().getPlayer(2).getDrug());
        String shoe1 = String.valueOf(gamePanel.getGame().getPlayer(1).getSpeed());
        String shoe2 = String.valueOf(gamePanel.getGame().getPlayer(2).getSpeed());
        g.drawString(health1,874,149 + 16);
        g.drawString(bom1,887,174 + 16);
        g.drawString(drug1,887,199 + 16);
        g.drawString(shoe1,887,222 + 16);

        g.drawString(health2,874,304 + 16);
        g.drawString(bom2,887,328 + 16);
        g.drawString(drug2,887,354 + 16);
        g.drawString(shoe2,887,377 + 16);
        if (gamePanel.getGame().getPlayer(1).getBarHealth() <= 0 || gamePanel.getGame().getPlayer(2).getBarHealth() <= 0) {
            if (gamePanel.getGame().getPlayer(1).getBarHealth() <= 0)
                winner = 2;
            else
                winner = 1;
            Game.playSE(3);
            applyGamestate();
        }
    }
    private void createButtons() {
        soundButton = new SoundButton(740, 489, 187, 39);
        musicButton = new MusicButton(740, 540, 187, 39);

        unpause = new Buttons(740, 438, 187, 39);
        exit = new Buttons(740, 594, 187, 39);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        if (winner == 0)
            if (paused) {
                Game.playSE(5);
                pauseOverPlay.mousePressed(e);
            }
            else {
                if (isIn5(e, musicButton)) {
                    Game.playSE(5);
                    musicButton.setMousePressed(true);
                } else if (isIn2(e, soundButton)) {
                    Game.playSE(5);
                    soundButton.setMousePressed(true);
                } else if (isIn3(e, exit)) {
                    Game.playSE(5);
                    exit.setMousePressed(true);
                }
                else if (isIn3(e, unpause)) {
                    unpause.setMousePressed(true);
                    Game.playSE(5);
                    paused = true;
                }
            }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (winner == 0)
            if (paused)
                pauseOverPlay.mouseReleased(e);
            else {
                if (isIn5(e, musicButton)) {
                    if (musicButton.isMousePressed()) {
                        if (commandNum_music == 0) {
                            Game.stopMusic();
                            commandNum_music = 1;
                        }
                        else {
                            Game.playMusic(0);
                            commandNum_music = 0;
                        }
                        musicButton.setMuted(!musicButton.isMuted());
                    }

                } else if (isIn2(e, soundButton)) {
                    if (commandNum_effect == 0)
                        commandNum_effect = 1;
                    else
                        commandNum_effect = 0;
                    if (soundButton.isMousePressed())
                        soundButton.setMuted(!soundButton.isMuted());
                } else if (isIn3(e, exit)) {
                    if (exit.isMousePressed()) {
                        GameStates.state = GameStates.MENU;
                        unpauseGame();
                    }
                } else if (isIn3(e, unpause)) {
                    if (unpause.isMousePressed()) {
                        unpauseGame();
                    }
                }
                musicButton.resetBools();
                soundButton.resetBools();
                exit.resetBools();
                unpause.resetBools();
            }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        if (winner == 0)
            if (paused)
                pauseOverPlay.mouseMoved(e);
            else {
                musicButton.setMouseOver(false);
                soundButton.setMouseOver(false);
                exit.setMouseOver(false);
                unpause.setMouseOver(false);

                if (isIn5(e, musicButton))
                    musicButton.setMouseOver(true);
                else if (isIn2(e, soundButton))
                    soundButton.setMouseOver(true);
                else if (isIn3(e, exit))
                    exit.setMouseOver(true);
                else if (isIn3(e, unpause)) {
                    unpause.setMouseOver(true);
                }
           }
    }
    public void unpauseGame() {
        paused = false;
    }

    public void applyGamestate(){
        GameStates.state = GameStates.WIN;
    }
    public boolean isIn2(MouseEvent e, SoundButton b) { return b.getBounds().contains(e.getX(), e.getY()); }
    public boolean isIn3(MouseEvent e, Buttons b) { return b.getBounds().contains(e.getX(), e.getY());}
    public boolean isIn5(MouseEvent e, MusicButton b) { return b.getBounds().contains(e.getX(), e.getY()); }

}