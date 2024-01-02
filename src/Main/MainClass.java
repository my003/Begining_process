/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Set up game background and divide into multithread for smooth GUI
*/
package Main;

public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
        game.initPlay();
        new GameThread1(game);
        new GameThread2(game);
    }
}