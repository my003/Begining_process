//package Subject;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class DrawP2 implements Observer{
//    private Image animation2[][];
//    public void loadAnimation() {
//        animation2 = new Image[4][3];
//        animation2[0][0] = new ImageIcon(this.getClass().getResource("Image/up1.png")).getImage();
//        animation2[0][1] = new ImageIcon(this.getClass().getResource("Image/up2.png")).getImage();
//        animation2[0][2] = new ImageIcon(this.getClass().getResource("Image/up3.png")).getImage();
//        animation2[1][0] = new ImageIcon(this.getClass().getResource("Image/right1.png")).getImage();
//        animation2[1][1] = new ImageIcon(this.getClass().getResource("Image/right2.png")).getImage();
//        animation2[1][2] = new ImageIcon(this.getClass().getResource("Image/right3.png")).getImage();
//        animation2[2][0] = new ImageIcon(this.getClass().getResource("Image/down1.png")).getImage();
//        animation2[2][1] = new ImageIcon(this.getClass().getResource("Image/down2.png")).getImage();
//        animation2[2][2] = new ImageIcon(this.getClass().getResource("Image/down3.png")).getImage();
//        animation2[3][0] = new ImageIcon(this.getClass().getResource("Image/left1.png")).getImage();
//        animation2[3][1] = new ImageIcon(this.getClass().getResource("Image/left2.png")).getImage();
//        animation2[3][2] = new ImageIcon(this.getClass().getResource("Image/left3.png")).getImage();
//    }
//    @Override
//    public void update(Object object) {
//    }
//    public String getStatus() {
//        return "DEAD";
//    }
//}
