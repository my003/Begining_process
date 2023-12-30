package GameState;

import Main.Game;
import UI.MenuButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pause extends State implements Statemethods{
    private MenuButton[] buttons = new MenuButton[3];
    private Image background;
    private int menuX, menuY, menuWidth, menuHeight;
    private Graphics2D g2;

    public Pause (Game game){
        super(game);
//        loadBackground();
//        loadButtons();
    }

    @Override
    public void update() {}
    @Override
    public void draw(Graphics g) {}
    @Override
    public void mouseClicked(MouseEvent e) {}

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
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
