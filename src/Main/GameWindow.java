package Main;


import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;
    public static final int WIDTHJF = 947 + 6;
	public static final int HEIGHTJF = 675 + 29;

    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
//    @Override
//    public void windowLostFocus(WindowEvent e) {
//        gamePanel.getGame().windowFocusLost();
//    }
//
//    @Override
//    public void windowGainedFocus(WindowEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//});
}
