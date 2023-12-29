//package Main;
//
//import State.State;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//
//public class Game implements Runnable, MouseListener, MouseMotionListener {
//    MouseEvent e;
//    private Image backGround;
//    private GameWindow gameWindow;
//    private GamePanel gamePanel;
//    private LoadMap load;
//    public State state = new State(this);
//    public int gameState;
//    public final int guideState = 5;
//    public final int creditState = 4;
//    public final int titleState = 0;
//    public final int playState = 1;
//    public final int optionsState = 2;
//    private final int FPS = 100 , UPS = 200;
//    private Thread thread;
//
//    private Player player;
//
//    public Game(){
//        load = new LoadMap();
//        gamePanel = new GamePanel(this);
//        player = new Player(400, 400, gamePanel);
//        //player1 = new Player(400,400,entity.DOWN,gamePanel);
//        gameWindow = new GameWindow(gamePanel);
//
//        startgameloop();
//    }
//
//    private void startgameloop() {
//        thread = new Thread(this);
//        thread.start();
//    }
//
//    public void update(){
//        //player1.update();
//        if (gameState == playState) {
//            playImage();
//            player.update();
//        }
//        if (gameState == titleState) {
//            state.drawTitleScreen();
//        }
//        if (gameState == optionsState) {
//            state.drawOptionsScreen();
//        }
//    }
//    private void playImage() {
//        backGround = new ImageIcon(this.getClass().getResource("Image/background_Play3.png")).getImage();
//    }
//    public void render(Graphics g){
//        Graphics2D g2 = (Graphics2D) g;
//        if (gameState == titleState)
//            state.draw(g2);
//        if (gameState == playState){
//            player.render(g);
//            load.draw(g);
//            playImage();
//
//        }
//    }
//
//    @Override
//    public void run() {
//        double timeperframe = 1000000000.0/FPS;
//        double timeperupdate = 1000000000.0/UPS;
//        long previous = System.nanoTime();
//        double deltaF = 0;
//        double deltaU = 0;
//
//        while (true) {
//            long current = System.nanoTime();
//            deltaF += (current - previous) / timeperframe;
//            deltaU += (current - previous) / timeperupdate;
//            previous = current;
//
//            if (deltaF>=1) {deltaF--; gamePanel.repaint();}
//            if (deltaU>=1) {deltaU--; update();}
//        }
//    }
//    public Player getPlayer(){
//        return player;
//    }
//
//    public LoadMap getMap(){
//        return load;
//    }
//    public void mouseClicked(MouseEvent e) {
//        int mx = e.getX();
//        int my = e.getY();
//        if (gameState == titleState) {
//            if (mx >= (worldWidth / 2) - 200 && mx <= ((worldWidth / 2) - 200) + getTitleSize() * 9
//                    && my >= (worldHeight / 2) - 50 && my <= (worldHeight / 2) - 50 + (getTitleSize() * 2)) {
//                gameState = playState;
//            } else if (mx >= (worldWidth / 2) - 100 && mx <= ((worldWidth / 2) - 100) + (getTitleSize() * 5)
//                    && my >= ((worldHeight / 2) + 50) && my <= ((worldHeight / 2) + 50) + (getTitleSize() * 2)) {
//                gameState = guideState;
//            } else if (mx >= (worldWidth / 2) - 100 && mx <= ((worldWidth / 2) - 100) + (getTitleSize() * 5)
//                    && my >= (worldHeight / 2) + 150 && my <= ((worldHeight / 2) + 150) + (getTitleSize() * 2)) {
//                gameState = creditState;
//            } else if (mx >= (worldWidth / 2) - 100 && mx <= ((worldWidth / 2) - 100) + (getTitleSize() * 5)
//                    && my >= (worldHeight / 2) + 250 && my <= ((worldHeight / 2) + 250) + (getTitleSize() * 2)) {
//                System.exit(1);
//            }
//
//        }
//        else if (gameState == guideState) {
//            if (mx >= 0 && mx <= worldWidth && my >= 0 && my <= worldHeight) {
//                gameState = titleState;
//            }
//        }
//        else if (gameState == creditState) {
//            if (mx >= 0 && mx <= worldWidth && my >= 0 && my <= worldHeight) {
//                gameState = titleState;
//            }
//        }
//        else if (gameState == playState) {
//            if (mx >= 70 && mx <= 70 + 50 && my >= 55 && my <= 105) {
//                if (gameState == playState)
//                    gameState = optionsState;
//            }
//        }
//        if (gameState == optionsState) {
//            if (mx >= 372 && mx <= 372 + 50 && my >= 286 && my <= 336) { // Reset room
//                //resetRoom = true;
//                System.out.println("Reset room");
//            }
//            else if (mx >= 532 && mx <= 532 + 50 && my >= 286 && my <= 336) { // Menu
//                gameState = titleState;
//                System.out.println("Menu");
//            }
//            else if (mx >= 444 && mx <= 444 + 50 && my >= 382 && my <= 432) { // Continue
//                // if (gameState == optionsState)
//                gameState = playState;
//                System.out.println("Continue");
//            }
////            else if (mx >= 382 && mx <= 382 + 50 && my >= 488 && my <= 538) { // Music
////                if (commandNum_music == 1) {
////                    commandNum_music = 2;
////                    stopMusic();
////                } else if (commandNum_music == 2) {
////                    commandNum_music = 1;
////                    playMusic(0);
////                }
////                // setUpGame();
////                System.out.println("Sound Music");
////            }
////            else if (mx >= 532 && mx <= 532 + 50 && my >= 488 && my <= 538) { // Effect
////                if (commandNum_effect == 3)
////                    commandNum_effect = 4;
////                else if (commandNum_effect == 4)
////                    commandNum_effect = 3;
////                System.out.println("Sound Effect");
////            }
//        }
//    }
//    @Override
//    public void mousePressed(MouseEvent e) {}
//    @Override
//    public void mouseReleased(MouseEvent e) {}
//    @Override
//    public void mouseEntered(MouseEvent e) {}
//    @Override
//    public void mouseExited(MouseEvent e) {}
//    @Override
//    public void mouseDragged(MouseEvent e) {}
//    @Override
//    public void mouseMoved(MouseEvent e) {}
//
//    private final int originalSizeTile = 16; // size of subject 16x16
//    private final int scale = 3; // rate to scale size of subject
//    private final int titleSize = originalSizeTile * scale;
//    // SETTING THE SCREEN
//    private final int maxScreenCol = 20;
//    private final int maxScreenRow = 20;
//    private final int screenHeight = titleSize * maxScreenRow;
//    private final int screenWidth = titleSize * maxScreenCol;
//    // SETTING SIZE OF MAP
//    public final int maxWorldCol = 100;
//    public final int maxWorldRow = 100;
//    public final int worldWidth = titleSize * maxScreenCol;
//    public final int worldHeight = titleSize * maxScreenRow;
//    public int getTitleSize() {
//        return titleSize;
//    }
//
//}
package Main;

import GameState.Credit;
import GameState.GameStates;
import GameState.Menu;
import GameState.Play;
import UI.SoundButton;
import entity.Boss;
import entity.Entity;
import entity.Player;


import java.awt.*;
import java.util.ArrayList;

public class Game{
    public GameWindow gameWindow;
    private GamePanel gamePanel;
//    private LoadMap load;
//    private CoverOrder coverOrder;
    //private ArrayList<Entity>[] entityRow;
    private Play play;
    private Menu menu;
    private Credit credit;

//    private Player player1, player2;
//    private Data data;
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 2f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game() {
        gamePanel = new GamePanel(this);
        intiClasses();
        //load = new LoadMap(gamePanel);
        //initEntityOrder();
        //coverOrder = new CoverOrder(gamePanel);
        //player1 = new Player(40, 40, gamePanel, 1);
        //player2 = new Player(675, 585, gamePanel, 2);
        //data = new Data(gamePanel);
        //initKeyBoard();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

    }
    private void intiClasses(){
        menu = new Menu(this);
        play = new Play(this);
        credit = new Credit(this);
    }

    public void initPlay(){
        play.initGame();
    }

    // private void initEntityOrder() {
    //     entityRow = new ArrayList[13];
    //     for (int i=0; i<13; ++i){
    //         entityRow[i] = new ArrayList<>();
    //     }
    //     for (Block block:load.getMap()){
    //         entityRow[block.getRow()].add(block);
    //     }
    // }

//    private void initKeyBoard() {
//        gamePanel.addKeyListener(player1.getKeyBoardInput());
//        gamePanel.addKeyListener(player2.getKeyBoardInput());
//        gamePanel.setFocusable(true);
//        gamePanel.requestFocus();
//    }

     public void update(){
         switch (GameStates.state) {
             case MENU:
                 menu.update();
                 break;
             case PLAY:
                 play.update();
                 break;
             case CREDIT:
                 credit.update();
                 break;
             case EXIT:
             default:
                 System.exit(0);
                 break;
         }
     }
    public void render(Graphics g) {
        switch (GameStates.state) {
            case MENU:
                menu.draw(g);
                break;
            case PLAY:
                play.draw(g);
                break;
            case CREDIT:
                credit.draw(g);
                break;
            default:
                break;
        }
    }
    public Player getPlayer(int n) {
        if (n == 1)
            return play.getPlayer(1);
        return play.getPlayer(2);
    }
    public Boss getBoss(int n){
        if (n == 1)
            return play.getBoss(1);
        return play.getBoss(2);
    }
    public LoadMap getMap() {
        return play.getMap();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameWindow getGameWindow() {return  gameWindow;}

    public Data getData() {
        return play.getData();
    }

    public ArrayList<Entity> getEntityRow(int row) {
        return play.getEntityRow(row);
    }

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }

    public Credit getCredit() { return credit; }
//    public SoundButton getSound(){ return sound;}

}
