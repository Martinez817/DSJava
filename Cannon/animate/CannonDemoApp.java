package animate;

import javax.swing.JFrame;

public class CannonDemoApp extends JFrame {
    public CannonDemoApp(String title) {
        super(title);
        Board board = new Board();
        add(board);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        board.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new CannonDemoApp("Cannon Simulation Board");
    }
}
