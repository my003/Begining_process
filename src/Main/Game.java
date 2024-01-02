/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose:
*/
package Main;

import Audio.Sound;
import GameState.*;
import GameState.Menu;
import entity.Entity;
import entity.Player;


import java.awt.*;
import java.util.ArrayList;

import static GameState.Play.*;

public class Game{
    public GameWindow gameWindow;
    private GamePanel gamePanel;
    private Play play;
    private Menu menu;
    private Credit credit;
    static Sound music = new Sound();
    static Sound soundfe = new Sound();
    private Win win;
    public Game() {
        gamePanel = new GamePanel(this);
        intiClasses();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
    private void intiClasses(){
        menu = new Menu(this);
        credit = new Credit(this);
        play = new Play(this);
        win = new Win(this);
    }
    public void initPlay(){
        playMusic(0);
        play.initGame();
    }

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
             case WIN:
                 win.update();
                 break;
             case EXIT:
                 System.exit(0);
                 break;
             default:
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
            case WIN:
                win.draw(g);
                break;
            default:
                break;
        }
    }

    public static void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public static void stopMusic() {
        music.stop();
    }
    public static void playSE(int i) {
        if (commandNum_effect == 0) {
            soundfe.setFile(i);
            soundfe.play();
        }
    }

    public Player getPlayer(int n) {
        if (n == 1)
            return play.getPlayer(1);
        return play.getPlayer(2);
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
}
