/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Design the Credit state (add buttons and image and the team member's information)
             following the concept of implement from Statemethod and extend from State
*/
package GameState;

import Main.Game;
import Main.GamePanel;
import UI.CreditButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Credit extends State implements Statemethods{
    private CreditButton[] buttons = new CreditButton[1];
    private Image background,screen;
    private int menuX, menuY, menuWidth, menuHeight;
    private GamePanel gamePanel;

    public Credit (Game game){
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
        background = new ImageIcon(this.getClass().getResource("ui/bghome.jpg")).getImage();
        screen = new ImageIcon(this.getClass().getResource("ui/img.png")).getImage();
        menuWidth = 947;
        menuHeight = 675;
        menuX = 0 ;
        menuY = 0;

    }
    private void loadButtons() {
        buttons[0] = new CreditButton(414, 462, 0, GameStates.MENU);
    }
    //@Override
    public void update() {
        for (CreditButton cb : buttons)
            cb.update();
    }

    //@Override
    public void draw(Graphics g) {
        // BACKGOURND
        g.drawImage(background, menuX, menuY, menuWidth, menuHeight, null);
        g.drawImage(screen, 264, 139, 400, 400, null);
        for (CreditButton cb : buttons)
            cb.draw(g);
        // Name
        g.setFont(g.getFont().deriveFont(Font.ITALIC,16F));
        // PHUC
        String text0 = "DO DINH PHUC ITCSIU21219";
        int x = 350;
        int y = 48 * 3;
        g.setColor(Color.BLACK);
        g.drawString(text0, x - 40, y + 50);

        // NTNT
        String text1 = "NGUYEN TRAN NGUYEN ANH ITITWE20021";
        g.setColor(Color.BLACK);
        g.drawString(text1, x - 40, y + 100);

        // My
        String text2 = "NGUYEN HUYNH THAO MY ITCSIU21204";
        g.setColor(Color.BLACK);
        g.drawString(text2, x - 40, y + 150);

        // THU HOANG
        String text3 = "LE THU HOANG ITCSIU21063  ";
        g.setColor(Color.BLACK);
        g.drawString(text3, x - 40, y + 200);
    }
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        if (GameStates.state == GameStates.CREDIT)
            for (CreditButton cb: buttons)
                if (isIn1(e,cb)) {
                    Game.playSE(5);
                    cb.setMousePressed(true);
                }
    }
    public void mouseReleased(MouseEvent e){
        if (GameStates.state == GameStates.CREDIT)
            for (CreditButton cb: buttons)
                if (isIn1(e,cb)) {
                    if (cb.isMousePressed())
                        cb.applyGamestate();
                    break;
                }
        resetButtons();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    private void resetButtons(){
        if (GameStates.state == GameStates.CREDIT)
            for (CreditButton cb: buttons)
                cb.resetBools();
    }
    public void mouseMoved(MouseEvent e){
        if (GameStates.state == GameStates.CREDIT) {
            for (CreditButton cb : buttons)
                cb.setMouseOver(false);

            for (CreditButton cb : buttons)
                if (isIn1(e, cb)) {
                    cb.setMouseOver(true);
                    break;
                }
        }
    }
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
    public boolean isIn1(MouseEvent e, CreditButton cb){ return cb.getBounds().contains(e.getX(), e.getY()); }

}
