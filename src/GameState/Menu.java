/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Design the Menu state (import image and add buttons)
             following the concept of implement from Statemethod and extend from State
*/
package GameState;

import Main.Game;
import Main.GamePanel;
import UI.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import UI.MenuButton;

public class Menu extends State implements Statemethods{
    private MenuButton[] buttons = new MenuButton[3];
    private Image background;
    private int menuX, menuY, menuWidth, menuHeight;
    private GamePanel gamePanel;

    public Menu (Game game){
        super(game);
        loadBackground();
        loadButtons();
        gamePanel = game.getGamePanel();
        initMouse();
    }

    private void initMouse(){
        gamePanel.addMouseListener(this);

    }
    private void loadBackground() {
        background = new ImageIcon(this.getClass().getResource("ui/mainWindow.png")).getImage();
        menuWidth = 947;
        menuHeight = 675;
        menuX = 0 ;
        menuY = 0;

    }
    private void loadButtons() {
        buttons[0] = new MenuButton(384, 337, 0, GameStates.PLAY);
        buttons[1] = new MenuButton(384, 445, 1, GameStates.CREDIT);
        buttons[2] = new MenuButton(384, 553, 2, GameStates.EXIT);
    }
    @Override
    public void update() {
        for (MenuButton mb : buttons)
            mb.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, menuX, menuY, menuWidth, menuHeight, null);
        for (MenuButton mb : buttons)
            mb.draw(g);
    }
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                Game.playSE(5);
                mb.setMousePressed(true);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                if (mb.isMousePressed())
                    mb.applyGamestate();
                break;
            }
        }
        resetButtons();
    }


    private void resetButtons(){
        for (MenuButton mb: buttons)
            mb.resetBools();
    }
    public void mouseMoved(MouseEvent e){
        for (MenuButton mb : buttons)
            mb.setMouseOver(false);
        for (MenuButton mb : buttons)
            if (isIn(e, mb)) {
                mb.setMouseOver(true);
                break;
            }
    }
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
}
