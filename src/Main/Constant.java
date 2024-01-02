/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Setting up 4 direction (up, right, down, left) for player to load the animation when walking
             For player1, the key set include (W, D, S, A) and set bom = "SPACE"
             For player2, the key set include (up, right, down, left) and set bom = "p"
*/
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