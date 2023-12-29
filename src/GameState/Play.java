package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Main.*;
import UI.*;
import entity.Boss;
import entity.Entity;
import entity.Player;

import javax.swing.*;

public class Play extends State implements Statemethods {
    private PlayButton[] buttons = new PlayButton[4];
    private Player player1, player2;
    private Boss boss1, boss2;
    private Data data;
    public LoadMap load;
    private GamePanel gamePanel;
    private CoverOrder coverOrder;
    private GameWindow gameWindow;
    //private PauseOverPlay pauseOverPlay;
    private boolean paused = false;
    private SoundButton soundButton;
    private MusicButton musicButton;

    public Play(Game game) {
        super(game);
        this.gamePanel = game.getGamePanel();
    }
    public void initGame(){
        load = new LoadMap(gamePanel);
        //initEntityOrder();
        loadButtons();
        coverOrder = new CoverOrder(gamePanel);
        player1 = new Player(40, 40, gamePanel, 1);
        player2 = new Player(675, 585, gamePanel, 2);
        boss1 = new Boss(100,40,gamePanel,1);
        boss2 = new Boss( 575,585,gamePanel,2);
        data = new Data(gamePanel);
        //pauseOverPlay = new PauseOverPlay(this);
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
        if (!paused) {
            player1.update();
            player2.update();
            boss1.update();
            boss2.update();
            data.trapSensor();
            for (PlayButton pb : buttons)
                pb.update();
        } else {
            //pauseOverPlay.update();
        }
    }
    public void loadCar(){

    }

    @Override
    public void draw(Graphics g) {
        load.draw(g);
        coverOrder.render(g);
        for (PlayButton pb : buttons)
            pb.draw(g);
        soundButton.draw(g);
        musicButton.draw(g);
        //if (paused)
            //pauseOverPlay.draw(g);
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

    private void loadButtons() {
        buttons[0] = new PlayButton(740, 438, 0, GameStates.PAUSE);
        buttons[1] = new PlayButton(740, 489, 1, GameStates.SOUND);
        buttons[2] = new PlayButton(740, 540, 2, GameStates.MUSIC);
        buttons[3] = new PlayButton(740, 594, 3, GameStates.EXIT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mx >= 740 && mx <= 740 + 187 && my >= 438 && my <= 438 + 39) {
            System.out.println("Pause");
            paused = true;
            GameStates.state = GameStates.PAUSE;
        }
        else
        if (mx >= 740 && mx <= 740 + 187 && my >= 489 && my <= 489 + 39) {
            System.out.println("Sound");
            GameStates.state = GameStates.SOUND;
        }
        else
        if (mx >= 740 && mx <= 740 + 187 && my >= 540 && my <= 540 + 39) {
            System.out.println("MUSIC");
            GameStates.state = GameStates.MUSIC;
        }
        else
        if (mx >= 740 && mx <= 740 + 187 && my >= 594 && my <= 594 + 39) {
            GameStates.state = GameStates.MENU;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
//        if (paused) pauseOverPlay.mousePressed(e);
        if (isIn3(e, soundButton))
            musicButton.setMousePressed(true);
        else if (isIn4(e, musicButton))
            musicButton.setMousePressed(true);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
//        if (paused) pauseOverPlay.mouseReleased(e);
        if (isIn3(e, soundButton))
            if (soundButton.isMousePressed())
                soundButton.setMuted(!soundButton.isMuted());

        else
        if (isIn4(e, musicButton))
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());
//        else if (isIn(e, replayB)) {
//            if (replayB.isMousePressed())
//                System.out.println("replay lvl!");
//        } else if (isIn(e, unpauseB)) {
//            if (unpauseB.isMousePressed())
//                play.unpauseGame();
//        }

        soundButton.resetBools();
        musicButton.resetBools();
//        replayB.resetBools();
//        unpauseB.resetBools();
    }
    private void resetButtons(){
        for (PlayButton pb: buttons)
            pb.resetBools();
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        //if (paused) pauseOverPlay.mouseMoved(e);
        soundButton.setMouseOver(false);
        musicButton.setMouseOver(false);
//        replayB.setMouseOver(false);
//        unpauseB.setMouseOver(false);

        if (isIn3(e, soundButton))
            soundButton.setMouseOver(true);
        else if (isIn4(e, musicButton))
            musicButton.setMouseOver(true);
//        else if (isIn(e, replayB))
//            replayB.setMouseOver(true);
//        else if (isIn(e, unpauseB))
//            unpauseB.setMouseOver(true);

    }

}