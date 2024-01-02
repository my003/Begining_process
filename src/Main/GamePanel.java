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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel {
    private Image backGround, card1, card2;
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game){
        mouseInputs = new MouseInputs(this);
        this.game = game;
        importImage();
        getPanelSize();
        addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        backGround = new ImageIcon(this.getClass().getResource("Image/map.png")).getImage();
        card1 = new ImageIcon(this.getClass().getResource("mainGame/profileP1.png")).getImage();
        card2 = new ImageIcon(this.getClass().getResource("mainGame/profileP2.png")).getImage();
    }

    private void getPanelSize() {
        Dimension size = new Dimension(947, 675);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    private void updateGame(){}
    public void paintComponent(Graphics g){
        g.drawImage(backGround, 0, 0, null);
        g.drawImage(card1, 737, 142, null);
        g.drawImage(card2, 737, 297, null);
        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}