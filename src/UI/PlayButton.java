//package UI;
//import GameState.GameStates;
//import GameState.Play;
//
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import javax.swing.*;
//import java.awt.Image;
//import static Utilz.Constants.UI.Buttons.*;
//import java.awt.event.MouseEvent;
//
//import GameState.GameStates;
//import GameState.Play;
//
//import javax.swing.*;
//
//public class PlayButton {
//    private int xPos, yPos, rowIndex, index;
//    private int xOffsetCenter = B_WIDTH / 2;
//    private GameStates state;
//    private GameState.Play play;
//
//    private Image imgs[];
//    private boolean mouseOver, mousePressed;
//    private Rectangle bounds;
//    private Play play;
//    private Image background,screen;
//    private int bgX, bgY, bgW, bgH;
//    private SoundButton soundButton;
//    private MusicButton musicButton;
//    private Button menuB, replayB, unpauseB;
//    protected int x, y, width, height;
//    protected Rectangle bounds;
//    public PlayButton(int x, int y, int width, int height){
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        initBounds();
//    }
//    private void createButtons() {
//        soundButton = new SoundButton(740, 489, 190, 115);
//        musicButton = new MusicButton(740, 297, 190, 115);
//    }
//    private void initBounds() {
//        bounds = new Rectangle(xPos, yPos, 180, 39);
//    }
//    private void importImage() {
//        imgs = new Image[8];
//        imgs[0] = new ImageIcon(this.getClass().getResource("btn/pausebtn.png")).getImage();
//        imgs[1] = new ImageIcon(this.getClass().getResource("btn/pausebtn(1).png")).getImage();
//        imgs[2] = new ImageIcon(this.getClass().getResource("btn/soundbtn.png")).getImage();
//        imgs[3] = new ImageIcon(this.getClass().getResource("btn/soundbtn(1).png")).getImage();
//        imgs[4] = new ImageIcon(this.getClass().getResource("btn/musicbtn.png")).getImage();
//        imgs[5] = new ImageIcon(this.getClass().getResource("btn/musicbtn(1).png")).getImage();
//        imgs[6] = new ImageIcon(this.getClass().getResource("btn/exitbtn.png")).getImage();
//        imgs[7] = new ImageIcon(this.getClass().getResource("btn/exitbtn(1).png")).getImage();
//    }
//    public boolean isMouseOver(){
//        return mouseOver;
//    }
//    public void setMouseOver(boolean mouseOver){
//        this.mouseOver = mouseOver;
//    }
//    public boolean isMousePressed() { return mousePressed; }
//    public void setMousePressed(boolean mousePressed){
//        this.mousePressed = mousePressed;
//    }
//    public Rectangle getBounds(){
//        return bounds;
//    }
//    public void applyGamestate(){
//        GameStates.state = state;
//    }
//    public void resetBools(){
//        mouseOver = false;
//        mousePressed = false;
//    }
//
//
////    private void loadBackground() {
////        background = new ImageIcon(this.getClass().getResource("btn/pausebg.png")).getImage();
////        screen = new ImageIcon(this.getClass().getResource("btn/subbg.png")).getImage();
////        bgW = 947;
////        bgH = 675;
////        bgX = 0;
////        bgY = 0;
////    }
//
//    public void update() {
//        soundButton.update();
//        musicButton.update();
//    }
//
//    public void draw(Graphics g) {
//        // Background
//        g.drawImage(background, bgX, bgY, bgW, bgH, null);
//        g.drawImage(screen, 247, 152, 400, 400, null);
//        musicButton.draw(g);
//        soundButton.draw(g);
//    }
//
//    public void mousePressed(MouseEvent e) {
//    }
//
//    public void mouseReleased(MouseEvent e) {
//    }
//
//    public void mouseMoved(MouseEvent e) {
//    }
//
//    private boolean isIn(MouseEvent e, PauseButton b) {
//        return b.getBounds().contains(e.getX(), e.getY());
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    private void initBounds() {
//        bounds = new Rectangle(x, y, width, height);
//    }
//
//}
//
//

package UI;
import GameState.GameStates;
import GameState.Play;
import Main.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;
import static Utilz.Constants.UI.Buttons.*;

public class PlayButton {
    private int xPos, yPos, rowIndex, index;
    private int xOffsetCenter = B_WIDTH / 2;
    private GameStates state;
    private GameState.Play play;

    protected int x, y, width, height;
    protected Rectangle bounds;
    public PlayButton(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }
    private void initBounds() {
        bounds = new Rectangle(x, y, width, height);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}

