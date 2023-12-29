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

public class Play extends State implements Statemethods {
    private PlayButton[] buttons = new PlayButton[4];
    private Player player1, player2;
    private Boss boss1, boss2;
    private Data data;
    public LoadMap load;
    private GamePanel gamePanel;
    private CoverOrder coverOrder;
    private GameWindow gameWindow;
    private PauseOverPlay pauseOverPlay;
    private boolean paused = false;
    public static int winner = 2;
    private SoundButton musicButton, soundButton;
    private Buttons exit, unpause;

    public Play(Game game) {
        super(game);
        this.gamePanel = game.getGamePanel();
    }
    public void initGame(){
        load = new LoadMap(gamePanel);
        //initEntityOrder();
        //loadButtons();
        coverOrder = new CoverOrder(gamePanel);
        player1 = new Player(40, 40, gamePanel, 1);
        player2 = new Player(675, 585, gamePanel, 2);
        boss1 = new Boss(100,40,gamePanel,1);
        boss2 = new Boss( 575,585,gamePanel,2);
        data = new Data(gamePanel);
        createButtons();
        loadButtons();
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
        if (!paused) {
            player1.update();
            player2.update();
            boss1.update();
            boss2.update();
            data.trapSensor();
            musicButton.update();
            soundButton.update();

            exit.update();
            unpause.update();
        }
        else {
            pauseOverPlay.update();
        }
    }
    @Override
    public void draw(Graphics g) {
        load.draw(g);
        coverOrder.render(g);

        if (paused)
            pauseOverPlay.draw(g);

        // Sound buttons
        musicButton.draw(g);
        soundButton.draw(g);

        // UrmButtons
        exit.draw(g);
        unpause.draw(g);
        loaddata(g);

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
        buttons[0] = new PlayButton(740, 438, 0, GameStates.PAUSE.ordinal());
        buttons[1] = new PlayButton(740, 489, 1, GameStates.SOUND.ordinal());
        buttons[2] = new PlayButton(740, 540, 2, GameStates.MUSIC.ordinal());
        buttons[3] = new PlayButton(740, 594, 3, GameStates.EXIT.ordinal());
    }
    private void loaddata(Graphics g){
        String bom1 = String.valueOf(gamePanel.getGame().getPlayer(1).getBombs().size());
        String bom2 = String.valueOf(gamePanel.getGame().getPlayer(2).getBombs().size());
        String health1 = String.valueOf(gamePanel.getGame().getPlayer(1).getBarHealth());
        String health2 = String.valueOf(gamePanel.getGame().getPlayer(2).getBarHealth());
        String drug1 = String.valueOf(gamePanel.getGame().getPlayer(1).getDrug()-1);
        String drug2 = String.valueOf(gamePanel.getGame().getPlayer(2).getDrug()-1);
        String shoe1 = String.valueOf(gamePanel.getGame().getPlayer(1).getSpeed()-1);
        String shoe2 = String.valueOf(gamePanel.getGame().getPlayer(2).getSpeed()-1);

        g.drawString(health1,874,149 + 16);
        g.drawString(bom1,887,174 + 16);
        g.drawString(drug1,887,199 + 16);
        g.drawString(shoe1,887,222 + 16);

        g.drawString(health2,874,304 + 16);
        g.drawString(bom2,887,328 + 16);
        g.drawString(drug2,887,354 + 16);
        g.drawString(shoe2,887,377 + 16);


    }
    private void createButtons() {
        soundButton = new SoundButton(740, 489, 187, 39);
        musicButton = new SoundButton(740, 540, 187, 39);

        exit = new Buttons(740, 594, 190, 115, 0);
        unpause = new Buttons(740, 438, 190, 115, 1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (GameStates.state == GameStates.PLAY){
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
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn1(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn1(e, soundButton))
            soundButton.setMousePressed(true);
        else if (isIn2(e, exit))
            exit.setMousePressed(true);
        else if (isIn2(e, unpause))
            unpause.setMousePressed(true);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
//        if (paused) pauseOverPlay.mouseReleased(e);
        if (isIn1(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());

        } else if (isIn1(e, soundButton)) {
            if (soundButton.isMousePressed())
                soundButton.setMuted(!soundButton.isMuted());
        }
        else if (isIn2(e, exit)) {
            if (exit.isMousePressed()) {
                GameStates.state = GameStates.MENU;
                unpauseGame();
            }
        } else if (isIn2(e, unpause)) {
            if (unpause.isMousePressed())
                unpauseGame();
        }

        musicButton.resetBools();
        soundButton.resetBools();
        exit.resetBools();
        unpause.resetBools();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        //if (paused) pauseOverPlay.mouseMoved(e);
        musicButton.setMouseOver(false);
        soundButton.setMouseOver(false);
        exit.setMouseOver(false);
        unpause.setMouseOver(false);

        if (isIn1(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn1(e, soundButton))
            soundButton.setMouseOver(true);
        else if (isIn2(e, exit))
            exit.setMouseOver(true);
        else if (isIn2(e, unpause))
            unpause.setMouseOver(true);
    }
    private boolean isIn1(MouseEvent e, SoundButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
    private boolean isIn2(MouseEvent e, Buttons b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
}