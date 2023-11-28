package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb extends Entity {
    private Image bomb;

    private int range;
    private int damage;

    private Explode2down explode2down;
    private Explode2left explode2left;
    private Explode2right explode2right;
    private Explode2up explode2up;
    private Explode3down explode3down;
    private Explode3left explode3left;
    private Explode3right explode3right;
    private Explode3up explode3up;
    private Explode4down explode4down;
    private Explode4left explode4left;
    private Explode4right explode4right;
    private Explode4up explode4up;
    
    private boolean permitCollide = true;
    private boolean isExploding = false;

    private int bangup, bangright, bangdown, bangleft;

    public Bomb(int x, int y, int damage) {
        super(x, y);
        bomb = new ImageIcon(this.getClass().getResource("Image/bomb.gif")).getImage();

        explode2down = new Explode2down(x, y);
        explode2left = new Explode2left(x, y);
        explode2right = new Explode2right(x, y);
        explode2up = new Explode2up(x, y);
        explode3down = new Explode3down(x, y);
        explode3left = new Explode3left(x, y);
        explode3right = new Explode3right(x, y);
        explode3up = new Explode3up(x, y);
        explode4down = new Explode4down(x, y);
        explode4left = new Explode4left(x, y);
        explode4right = new Explode4right(x, y);
        explode4up = new Explode4up(x, y);
        
        rectangle = new Rectangle(x*45+45, y*45+45, 45, 45);
        this.damage = damage;
        range = damage;
    }

    public void render(Graphics g){
        g.drawImage(bomb, x*45+45, y*45+45, null);
    }

    public void bang(Graphics g){
        isExploding = true;
        switch (bangup) {
            case 1:
                bangup1(g);
                break;
            case 2:
                bangup2(g);
                break;
            case 3:
                bangup3(g);
                break;
            default:
                break;
        }
        switch (bangright) {
            case 1:
                bangright1(g);
                break;
            case 2:
                bangright2(g);
                break;
            case 3:
                bangright3(g);
                break;
            default:
                break;
        }
        switch (bangdown) {
            case 1:
                bangdown1(g);
                break;
            case 2:
                bangdown2(g);
                break;
            case 3:
                bangdown3(g);
                break;
            default:
                break;
        }
        switch (bangleft) {
            case 1:
                bangleft1(g);
                break;
            case 2:
                bangleft2(g);
                break;
            case 3:
                bangleft3(g);
                break;
            default:
                break;
        }
    }


    public void bangup1(Graphics g){
        explode2up.updatePosition(x, y);
        explode2up.render(g);
    }
    public void bangup2(Graphics g){
        explode3up.updatePosition(x, y);
        explode3up.render(g);
    }
    public void bangup3(Graphics g){
        explode4up.updatePosition(x, y);
        explode4up.render(g);
    }
    public void bangright1(Graphics g){
        explode2right.updatePosition(x, y);
        explode2right.render(g);
    }
    public void bangright2(Graphics g){
        explode3right.updatePosition(x, y);
        explode3right.render(g);
    }
    public void bangright3(Graphics g){
        explode4right.updatePosition(x, y);
        explode4right.render(g);
    }
    public void bangdown1(Graphics g){
        explode2down.updatePosition(x, y);
        explode2down.render(g);
    }
    public void bangdown2(Graphics g){
        explode3down.updatePosition(x, y);
        explode3down.render(g);
    }
    public void bangdown3(Graphics g){
        explode4down.updatePosition(x, y);
        explode4down.render(g);
    }
    public void bangleft1(Graphics g){
        explode2left.updatePosition(x, y);
        explode2left.render(g);
    }
    public void bangleft2(Graphics g){
        explode3left.updatePosition(x, y);
        explode3left.render(g);
    }
    public void bangleft3(Graphics g){
        explode4left.updatePosition(x, y);
        explode4left.render(g);
    }

    public void resetExplosion(){
        isExploding = false;
        bangdown = 0;
        bangleft = 0;
        bangright= 0;
        bangup = 0;
        if (explode2up.getX()>-1) explode2up.updatePosition(-100, y);
        if (explode3up.getX()>-1) explode3up.updatePosition(-100, y);
        if (explode4up.getX()>-1) explode4up.updatePosition(-100, y);
        if (explode2down.getX()>-1) explode2down.updatePosition(-100, y);
        if (explode3down.getX()>-1) explode3down.updatePosition(-100, y);
        if (explode4down.getX()>-1) explode4down.updatePosition(-100, y);
        if (explode2right.getX()>-1) explode2right.updatePosition(-100, y);
        if (explode3right.getX()>-1) explode3right.updatePosition(-100, y);
        if (explode4right.getX()>-1) explode4right.updatePosition(-100, y);
        if (explode2left.getX()>-1) explode2left.updatePosition(-100, y);
        if (explode3left.getX()>-1) explode3left.updatePosition(-100, y);
        if (explode4left.getX()>-1) explode4left.updatePosition(-100, y);
    }

   

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        rectangle.setLocation(x*45+45, y*45+45);
    }

    public void setPermitCollide(boolean c){
        permitCollide = c;
    }

    public boolean getPermitCollide(){
        return permitCollide;
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public int getRange(){
        return range;
    }

    public void setExplode(boolean t){
        this.isExploding = t;
    }

    public boolean getIsExploding(){
        return isExploding;
    }

    public void setBangup(int x){
        bangup = x;
    }

    public void setBangright(int x){
        bangright = x;
    }

    public void setBangdown(int x){
        bangdown = x;
    }

    public void setBangleft(int x){
        bangleft = x;
    }
}
