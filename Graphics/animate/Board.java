package animate;

import javax.swing.JFrame;
import java.awt.Color;
public class Board extends JFrame {
    public static int FRAME_WIDTH = 800;
    public static int FRAME_HEIGHT = 600;

    public Board(String title) {
        setTitle(title);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /* lets create a red and blue frame thats split red and blue on the background */
    public void initUI() {
       add (new Board("Red and Blue"));
        setBackground(Color.BLUE);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    }

    public static void main(String[] args) {
        Board ex = new Board("Red and Blue");
        ex.setVisible(true);
    }



    
}
