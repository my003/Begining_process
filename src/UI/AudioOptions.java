//package UI;
//
//
//import java.awt.Graphics;
//import java.awt.event.MouseEvent;
//
//import Main.Game;
//
//public class AudioOptions {
//
//    private SoundButton musicButton, soundButton;
//
//    private Game game;
//
//    public AudioOptions(Game game) {
//        this.game = game;
//        createButtons();
//    }
//
//    private void createButtons() {
//        soundButton = new SoundButton(740, 489, 187, 39);
//        musicButton = new SoundButton(740, 540, 187, 39);
//    }
//
//    public void update() {
//        musicButton.update();
//        soundButton.update();
//    }
//
//    public void draw(Graphics g) {
//        musicButton.draw(g);
//        soundButton.draw(g);
//    }
//
//    public void mousePressed(MouseEvent e) {
//        if (isIn(e, musicButton))
//            musicButton.setMousePressed(true);
//        else if (isIn(e, soundButton))
//            soundButton.setMousePressed(true);
//    }
//
//    public void mouseReleased(MouseEvent e) {
//        if (isIn(e, musicButton)) {
//            if (musicButton.isMousePressed()) {
//                musicButton.setMuted(!musicButton.isMuted());
//                game.getAudioPlayer().toggleSongMute();
//            }
//
//        } else if (isIn(e, soundButton)) {
//            if (soundButton.isMousePressed()) {
//                soundButton.setMuted(!soundButton.isMuted());
//                game.getAudioPlayer().toggleEffectMute();
//            }
//        }
//
//        musicButton.resetBools();
//        soundButton.resetBools();
//    }
//
//    public void mouseMoved(MouseEvent e) {
//        musicButton.setMouseOver(false);
//        soundButton.setMouseOver(false);
//
//        if (isIn(e, musicButton))
//            musicButton.setMouseOver(true);
//        else if (isIn(e, soundButton))
//            soundButton.setMouseOver(true);
//    }
//
//    private boolean isIn(MouseEvent e, PauseButton b) {
//        return b.getBounds().contains(e.getX(), e.getY());
//    }
//
//}