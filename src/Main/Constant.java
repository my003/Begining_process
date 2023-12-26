package Main;

import java.awt.event.KeyEvent;

public class Constant {
    public static class AnimationConstant {
        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
    }

    public class KeySetForPlayer1 {
        public static final int UP = KeyEvent.VK_W;
        public static final int RIGHT = KeyEvent.VK_D;
        public static final int DOWN = KeyEvent.VK_S;
        public static final int LEFT = KeyEvent.VK_A;
        public static final char SET_BOMB = ' ';
    }

    public class KeySetForPlayer2 {
        public static final int UP = KeyEvent.VK_UP;
        public static final int RIGHT = KeyEvent.VK_RIGHT;
        public static final int DOWN = KeyEvent.VK_DOWN;
        public static final int LEFT = KeyEvent.VK_LEFT;
        public static final char SET_BOMB = 'p';
    }

}