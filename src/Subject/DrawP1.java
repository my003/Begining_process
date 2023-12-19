package Subject;

import javax.swing.*;
import java.awt.*;

public class DrawP1 implements Observer{
    @Override
    public void update(Object object, int orient) {
        if (object instanceof Player1 player1) {
            if (player1.status == entity.DEAD) {
                return;
            }
            player1.setChange(orient);

        }
    }
    public String getStatus() {
        return "DEAD";
    }
}
