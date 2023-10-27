package Main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;




public class GamePanel extends JPanel {
    private Image backGround;
    private LoadMap load;

    public GamePanel(LoadMap load){
        this.load = load;
        importImage();
        getPanelSize();
    }

    private void importImage() {
        backGround = new ImageIcon(this.getClass().getResource("Image/background_Play3.png")).getImage();
    }

    private void getPanelSize() {   
        Dimension size = new Dimension(947, 675);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        g.  drawImage(backGround, 0, 0, null);
        load.draw(g);
    }
}
