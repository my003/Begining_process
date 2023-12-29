package GameState;

import Main.Game;
import Main.GamePanel;
import UI.WinButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import UI.WinButton;
import UI.WinButton;

public class Win extends State implements Statemethods{
    private WinButton[] buttons = new WinButton[2];
    private Image background,background1, background2;
    private int menuX, menuY, menuWidth, menuHeight;
    public static int state = 0;
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
        buttons[0] = new WinButton(324, 458, 0, GameStates.MENU);
        buttons[1] = new WinButton(494, 458, 1, GameStates.PLAY);
    }
    @Override
    public void update() {
        for (WinButton mb : buttons)
            mb.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0,0,947, 675,  null);
        if (Play.winner == 1)
            g.drawImage(background1, menuX, menuY, menuWidth, menuHeight, null);
        else
            g.drawImage(background2, menuX, menuY, menuWidth, menuHeight, null);
        for (WinButton mb : buttons)
            mb.draw(g);
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
                System.out.println("Restart");
                GameStates.state = GameStates.PLAY;
            }
        }
    }
    public void mousePressed(MouseEvent e){
        for (WinButton wb : buttons) {
            if (isIn4(e, wb)) {
                wb.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        for (WinButton wb : buttons) {
            if (isIn4(e, wb)) {
                if (wb.isMousePressed())
                    wb.applyGamestate();
                break;
            }
        }
        resetButtons();

    }

    private void resetButtons(){
        for (WinButton mb: buttons)
            mb.resetBools();
    }
    public void mouseMoved(MouseEvent e){
        for (WinButton mb : buttons)
            mb.setMouseOver(false);

        for (WinButton wb : buttons)
            if (isIn4(e, wb)) {
                wb.setMouseOver(true);
                break;
            }
    }
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
}
