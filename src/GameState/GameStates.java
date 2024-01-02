/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Controlling the view of the State when playing
             Display the menu state in the beginning start.
*/
package GameState;

public enum GameStates {
    PLAY, MENU, CREDIT, EXIT, WIN, PAUSE;
    public static GameStates state = MENU;
}


