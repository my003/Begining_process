//package Main;
//
//import State.State;
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//import java.awt.*;
//
//
//public class GamePanel extends JPanel {
//    private Image backGround;
//    private Game game;
//    public GamePanel(Game game){
//        this.game = game;
//        addKeyListener(new KeyBoardInput(this));
//        addMouseMotionListener(game);
//        addMouseListener(game);
//        setFocusable(true);
//        requestFocus();
//        importImage();
//        getPanelSize();
//
//    }
//
//    private void importImage() {
//        //backGround = new ImageIcon(this.getClass().getResource("Image/backbround.jpg")).getImage();
//        backGround = new ImageIcon(this.getClass().getResource("Image/background_Play3.png")).getImage();
//    }
//
//
//    private void getPanelSize() {
//        Dimension size = new Dimension(947, 675);
//        setMinimumSize(size);
//        setPreferredSize(size);
//        setMaximumSize(size);
//    }
//
//    public void paintComponent(Graphics g){
//        game.render(g);
//    }
//    public Game getGame(){
//        return game;
//    }
//}

package Main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel {
    private Image backGround, card1, card2;
    private Game game;

    public GamePanel(Game game){
        this.game = game;
        importImage();
        getPanelSize();
    }

    private void importImage() {
        backGround = new ImageIcon(this.getClass().getResource("Image/map.png")).getImage();
        card1 = new ImageIcon(this.getClass().getResource("Image/card.png")).getImage();
        card2 = new ImageIcon(this.getClass().getResource("Image/card.png")).getImage();
    }

    private void getPanelSize() {
        Dimension size = new Dimension(947, 675);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    private void updateGame(){

    }

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