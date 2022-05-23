package chessgui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUIFrame extends JFrame {
    Component component;
    public GUIFrame(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess Game");
        this.setResizable(false);
        component = new chessBoard();
        this.add(component, BorderLayout.CENTER);
        
        this.setLocation(200, 50);
        this.pack();
        this.setVisible(true);
    }
}
