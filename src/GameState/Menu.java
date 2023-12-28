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
    public static int state = 0;
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
    private void loadFont(Graphics2D g2){

        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 180F));
        String text = "BOM IT";
        int x = getXForCenteredText(text);
        int y = 48 * 6;
        Color color = new Color(201, 92, 151, 255);
        g2.setColor(color);
        g2.drawString(text, x, y);
    }

    private int getXForCenteredText(String text) {
        return (int) (947/2);
    }

    private void loadBackground() {
        background = new ImageIcon(this.getClass().getResource("ui/bghome.jpg")).getImage();
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
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if (mx >= 384 && mx <= 384 + 180 && my >= 337 && my <= 337 + 67) {
            state = 0;
            GameStates.state = GameStates.PLAY;
        }
        else
            if (mx >= 384 && mx <= 384 + 180 && my >= 445 && my <= 445 + 67) {
                state = 1;
                System.out.println("Credit");
                GameStates.state = GameStates.CREDIT;
            }
            else
                if (mx >= 384 && mx <= 384 + 180 && my >= 553 && my <= 553 + 67) {
                    state = 2;
                    System.exit(1);
                }
    }
    public void mousePressed(MouseEvent e){
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                mb.setMousePressed(true);
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
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            GameStates.state = GameStates.PLAY;
    }
    public void keyReleased(KeyEvent e) {
    }
}
