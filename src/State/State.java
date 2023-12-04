package State;

import Main.Game;
import Main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class State {
    GamePanel gamePanel;
    Game game;
    public Image menu, cont, reset, sound_music_on, sound_music_off,
        sound_effect_on, sound_effect_off, pause, bg, playgame, guide, sound, credit,right,left,down,up,exit;

    public static int commandNum_music = 1;
    public static int commandNum_effect = 3;
    Font arial_30, arial_80B;
    Graphics2D g2;
    public State(Game game) {
        this.game = game;
        getImage();
        arial_30 = new Font("ThaleahFat", Font.BOLD, 30);
        arial_80B = new Font("ThaleahFat", Font.PLAIN, 80);
        // setupFonts();
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_30);
        g2.setColor(Color.white);
        draw_pause(70, 105);
        if (game.gameState == game.titleState) {
            drawTitleScreen();
        }
        if (game.gameState == game.guideState) {
            draw_guide();
        }
        if (game.gameState == game.creditState) {
            drawCreditState();
        }
        // Play State
        if (game.gameState == game.playState) {
            // Do playState stuff later
        }
        // Pause State
        if (game.gameState == game.optionsState) {
            drawOptionsScreen();
        }
    }
    private void draw_success(){
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 30F));
        g2.setColor(Color.white);
    }

    private void draw_guide() {
        // BACKGOURND
        g2.drawImage(bg, 0, 0, 960, 960, null);
        int frameX = (int) (48 * 5.5);
        int frameY = 48 * 4;
        int frameWidth = (int) (48 * 9.5);
        int frameHeight = (int) (48 * 7.5);
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        int textX;
        int textY;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        int titlesize = 48 + 10;

        // Title
        String text = "How To Play";
        textX = getXForCenteredText(text) - 10;
        textY = frameY;
        g2.drawString("How To Play", textX + 30, textY + 48+10);
        g2.setFont(g2.getFont().deriveFont(20F));

        // RIGHT
        textX = frameX + 48;
        textY += 30;
        textY += 48 * 2;
        g2.drawString("Right", textX + 215, textY + 60);
        g2.drawImage(right, textX + 210, textY + 48 + 25 , titlesize - 10, titlesize - 10, null);

        //down
        text = "Down";
        textY += 20;
        textX = getXForCenteredText(text) ;
        g2.drawString("Down", textX + 15, textY + 48 + 80);
        g2.drawImage(down, textX + 10, textY + 48 + 5, titlesize - 10, titlesize - 10, null); // method to draw

        textY -= 50;

        //up
        text = "Up";
        textY += 30;
        textX = getXForCenteredText(text) ;
        g2.drawString("Up", textX + 15, textY + 5 );
        g2.drawImage(up, textX , textY + 48 - 30 , titlesize - 10, titlesize - 10, null); // method to draw
        textY -= 50;

        //left
        textX = frameX + 48;
        textY += 48 * 2;
        g2.drawString("Left", textX + 110, textY  + 15);
        g2.drawImage(left, textX + 105, textY + 48 -20, titlesize - 10, titlesize - 10, null);

    }

    private void drawCreditState() {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        // BACKGOURND
        g2.drawImage(bg, 0, 0, 960, 960, null);
        // Name
        // PHUC
        String text = "DO DINH PHUC ITCSIU21000";
        int x = getXForCenteredText(text);
        int y = 48 * 3;
        g2.setColor(Color.BLACK);
        g2.drawString(text, x - 40, y + 80);
        // NTNT
        String text1 = "NGUYEN TRAN NGUYEN ANH ITITWE20021";

        g2.setColor(Color.BLACK);
        g2.drawString(text1, x - 40, y + 150);
        // My
        String text2 = "NGUYEN HUYNH THAO MY ITCSIU21204";

        g2.setColor(Color.BLACK);
        g2.drawString(text2, x - 40, y + 220);
        // THU HOANG
        String text3 = "LE THU HOANG ITCSIU21063  ";
        g2.setColor(Color.BLACK);
        g2.drawString(text3, x - 40, y + 290);
    }

    public void drawTitleScreen() {
        // BACKGOURND
        g2.drawImage(bg, 0, 0, 960, 960, null);
        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 180F));
        String text = "BOM IT";
        int x = getXForCenteredText(text);
        int y = 48 * 6;
        Color color = new Color(201, 92, 151, 255);
        g2.setColor(color);
        g2.drawString(text, x, y);

            // playgame
        g2.drawImage(playgame, (960 / 2) - 200, (960 / 2) - 50, 48 * 9,
                48 * 2,
                null);
        // guide
        g2.drawImage(guide, (960 / 2) - 100, (960 / 2) + 50, 48 * 5,
                48 * 2,
                null);
        // sound
        g2.drawImage(credit, (960 / 2) - 100, (960 / 2) + 150, 48 * 5,
                48 * 2,
                null);
        // credit
        g2.drawImage(exit, (960 / 2) - 100, (960 / 2) + 250, 48 * 5,
                48 * 2,
                null);
//        g2.drawImage(playgame, (960 / 2) - 200, (960 / 2) - 50, 48 * 9,
//                48 * 2,
//                null);
//        // guide
//        g2.drawImage(guide, (960 / 2) - 100, (960 / 2) + 50, 48 * 5,
//                48 * 2,
//                null);
//        // sound
//        g2.drawImage(credit, (960 / 2) - 100, (960 / 2) + 150, 48 * 5,
//                48 * 2,
//                null);
//        // credit
//        g2.drawImage(exit, (960 / 2) - 100, (960 / 2) + 250, 48 * 5,
//                48 * 2,
//                null);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        // mousePressed(e);
        // mouseClicked(e);
        Color color = new Color(0, 0, 0, 186);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawOptionsScreen() {
        g2.setColor(Color.white);
        // g2.setFont(g2.getFont().deriveFont(40F));
        int frameX = (int) (48 * 5.5);
        int frameY = 48 * 4;
        int frameWidth = (int) (48 * 9.5);
        int frameHeight = (int) (48 * 7.5);
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        option_top(frameX, frameY);
    }

    public int getXForCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = 960 / 2 - length / 2;
        return x;
    }

    public void draw_pause(int textX, int textY) {
        g2.drawImage(pause, textX, textY - 70, 48, 48, null); // method to draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
    }

    public void option_top(int frameX, int frameY) {
        int textX;
        int textY;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        int titlesize = 48 + 10;
        // Title
        String text = "Settings";
        textX = getXForCenteredText(text) - 10;
        textY = frameY;
        g2.drawString("Settings", textX + 10, textY + 48);
        g2.setFont(g2.getFont().deriveFont(20F));

        // Reset Room
        textX = frameX + 48;
        textY += 48 * 2;
        g2.drawString("Reset", textX + 70, textY + 48);
        g2.drawImage(reset, textX + 70, textY + 48 - 70, titlesize - 10, titlesize - 10, null); // method
        // to
        // draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY += 48;
        textX += 70;

        // Home
        textY += 48 * 2;
        g2.drawString("Home", textX + 150, textY - 48 * 2);
        // g2.drawString("Home", textX,textY);
        g2.drawImage(menu, textX + 150, textY - 48 * 2 - 70, titlesize - 10, titlesize - 10, null); // method
        // to
        // draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textX += 150;

        // Continue
        // textY += frameY;
        text = "Continue";
        textY += 50;
        textX = getXForCenteredText(text) - 10;
        g2.drawString("Continue", textX + 10, textY - 50);
        g2.drawImage(cont, textX + 20, textY - 120, titlesize - 10, titlesize - 10, null); // method to draw
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY -= 50;

        // Music
        text = "Music";
        textX = frameX + 48;
        if (commandNum_music == 1) {
            g2.drawString("Music: ON", textX + 60, textY + 48 * 2);
            g2.drawImage(sound_music_on, textX + 70, textY + 48 * 2 - 70, titlesize - 10, titlesize - 10,
                    null); // method to draw
        }
        if (commandNum_music == 2) {
            g2.drawString("Music: OFF", textX + 60, textY + 48 * 2);
            g2.drawImage(sound_music_off, textX + 70, textY + 48 * 2 - 70, titlesize - 10,
                    titlesize - 10, null); // method to draw
        }
        textX += 70;
        // System.out.println("textX: " + textX + " - " + "textY" + textY);

        // Effect
        if (commandNum_effect == 3) {
            g2.drawString("Effect: ON", textX + 135, textY + 48 * 2);
            g2.drawImage(sound_effect_on, textX + 150, textY + 48 * 2 - 70, titlesize - 10,
                    titlesize - 10, null); // method to draw
        }
        if (commandNum_effect == 4) {
            g2.drawString("Effect: OFF", textX + 135, textY + 48 * 2);
            g2.drawImage(sound_effect_off, textX + 150, textY + 48 * 2 - 70, titlesize - 10,
                    titlesize - 10, null); // method to draw
        }
        textX += 150;
        // System.out.println("textX: " + textX + " - " + "textY" + textY);
        textY += 48 * 2;
    }

    public void getImage() { // read Image
//        try {
//            menu = ImageIO.read(new File("UI/home.png"));
//            reset = ImageIO.read(new File("UI/Reset.png"));
//            cont = ImageIO.read(new File("UI/play.png"));
//            sound_music_on = ImageIO.read(new File("UI/Sound_Music_on.png"));
//            sound_music_off = ImageIO.read(new File("UI/Sound_Music_off.png"));
//            sound_effect_on = ImageIO.read(new File("UI/Sound_Effect_on.png"));
//            sound_effect_off = ImageIO.read(new File("UI/Sound_Effect_off.png"));
//            pause = ImageIO.read(new File("UI/pause.png"));
//            bg = ImageIO.read(new File("UI/backbround.jpg"));
//            playgame = ImageIO.read(new File("UI/playgamr.png"));
//            guide = ImageIO.read(new File("UI/guide.png"));
//            sound = ImageIO.read(new File("UI/sound.png"));
//            credit = ImageIO.read(new File("UI/credit.png"));
//            right = ImageIO.read(new File("UI/pkl_lite_keys_0_one_arrow_right.png"));
//            down = ImageIO.read(new File("UI/pkl_lite_keys_0_one_arrow_down.png"));
//            up = ImageIO.read(new File("UI/pkl_lite_keys_0_one_arrow_up.png"));
//            left = ImageIO.read(new File("UI/pkl_lite_keys_0_one_arrow_left.png"));
//            exit = ImageIO.read(new File("UI/exit.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        menu = new ImageIcon(this.getClass().getResource("UI/home.png")).getImage();
        reset = new ImageIcon(this.getClass().getResource("UI/Reset.png")).getImage();
        cont = new ImageIcon(this.getClass().getResource("UI/play.png")).getImage();
        sound_music_on = new ImageIcon(this.getClass().getResource("UI/Sound_Music_on.png")).getImage();
        sound_music_off = new ImageIcon(this.getClass().getResource("UI/Sound_Music_off.png")).getImage();
        sound_effect_on = new ImageIcon(this.getClass().getResource("UI/Sound_Effect_on.png")).getImage();
        sound_effect_off = new ImageIcon(this.getClass().getResource("UI/Sound_Effect_off.png")).getImage();
        pause = new ImageIcon(this.getClass().getResource("UI/pause.png")).getImage();
        bg = new ImageIcon(this.getClass().getResource("UI/backround.jpg")).getImage();
        playgame = new ImageIcon(this.getClass().getResource("UI/playgamr.png")).getImage();
        guide = new ImageIcon(this.getClass().getResource("UI/guide.png")).getImage();
        sound = new ImageIcon(this.getClass().getResource("UI/sound.png")).getImage();
        credit = new ImageIcon(this.getClass().getResource("UI/credit.png")).getImage();
        right = new ImageIcon(this.getClass().getResource("UI/pkl_lite_keys_0_one_arrow_right.png")).getImage();
        down = new ImageIcon(this.getClass().getResource("UI/pkl_lite_keys_0_one_arrow_down.png")).getImage();
        up = new ImageIcon(this.getClass().getResource("UI/pkl_lite_keys_0_one_arrow_up.png")).getImage();
        left = new ImageIcon(this.getClass().getResource("UI/pkl_lite_keys_0_one_arrow_left.png")).getImage();
        exit = new ImageIcon(this.getClass().getResource("UI/exit.png")).getImage();
    }
}
