package GameState;

import Main.Game;
import Main.GamePanel;
import UI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import UI.WinButton;
import UI.WinButton;

public class Win extends State implements Statemethods{
    private WinButton menu, retry;
    private Play play;
    private Image background,background1, background2;
    private int menuX, menuY, menuWidth, menuHeight;
    private GamePanel gamePanel;

    public Win (Game game){
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
        background = new ImageIcon(this.getClass().getResource("ui/winner_wait.png")).getImage();
        background1 = new ImageIcon(this.getClass().getResource("ui/winner1.png")).getImage();
        background2 = new ImageIcon(this.getClass().getResource("ui/winner2.png")).getImage();

        menuWidth = 400;
        menuHeight = 427;
        menuX = 273;
        menuY = 124;

    }
    private void loadButtons() {
        menu = new WinButton(324, 458, 0, GameStates.MENU);
        retry = new WinButton(494, 458, 1, GameStates.EXIT);
    }
    @Override
    public void update() {
//        for (WinButton mb : buttons)
//            mb.update();
        menu.update();
        retry.update();
    }
    public void draw(Graphics g) {
        g.drawImage(background, 0,0,947, 675,  null);
        if (Play.winner == 1)
            g.drawImage(background1, menuX, menuY, menuWidth, menuHeight, null);
        if (Play.winner == 2)
            g.drawImage(background2, menuX, menuY, menuWidth, menuHeight, null);
//        for (WinButton mb : buttons)
//            mb.draw(g);
        menu.draw(g);
        retry.draw(g);
    }
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if (GameStates.state == GameStates.WIN){
            if (mx >= 324 && mx <= 324 + 122 && my >= 462 && my <= 462 + 50) {
                System.out.println("HOME");
                GameStates.state = GameStates.MENU;
            }
            else
            if (mx >= 498 && mx <= 498 + 122 && my >= 462 && my <= 462 + 50) {
                Play.reset = true;
                System.out.println("Restart");
                GameStates.state = GameStates.EXIT;
            }
        }
    }
    public void mousePressed(MouseEvent e){
//        for (WinButton wb : buttons) {
//            if (isIn4(e, wb)) {
//                wb.setMousePressed(true);
//                game.reset = true;
//                Play.winner = 0;
//            }
//        }
        if (isIn(menu, e)){
            Game.playSE(5);
            Play.reset = true;
            menu.setMousePressed(true);

        } else if (isIn(retry, e)) {
            Game.playSE(5);
            retry.setMousePressed(true);
            Play.reset = true;
        }
        }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(menu, e)) {
            if (menu.isMousePressed()) {
                menu.applyGamestate();
                Play.winner = 0;
                Play.paused = false;
            }
        } else if (isIn(retry, e))
            if (retry.isMousePressed()) {
                retry.applyGamestate();
                Play.winner = 0;
                Play.paused = false;
            }

        menu.resetBools();
        retry.resetBools();
//        for (WinButton wb : buttons) {
//            if (isIn4(e, wb)) {
//                if (wb.isMousePressed())
//                    wb.applyGamestate();
//                break;
//            }
//        }
//        resetButtons();
    }

//    private void resetButtons(){
//        for (WinButton mb: buttons)
//            mb.resetBools();
//    }
    public void mouseMoved(MouseEvent e){
        menu.setMouseOver(false);
        retry.setMouseOver(false);

        if (isIn(menu, e))
            menu.setMouseOver(true);
        else if (isIn(retry, e))
            retry.setMouseOver(true);
    }

//        for (WinButton mb : buttons)
//            mb.setMouseOver(false);
//        for (WinButton wb : buttons)
//            if (isIn4(e, wb)) {
//                wb.setMouseOver(true);
//                break;
//            }
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
    public boolean isIn(WinButton wb, MouseEvent e){
        return wb.getBounds().contains(e.getX(), e.getY());
    }
}
