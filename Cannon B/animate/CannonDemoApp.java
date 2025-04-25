package animate;

import javax.swing.*;

public class CannonDemoApp extends JFrame {
    public CannonDemoApp(String title) {
        super(title);

        Board board = new Board(60, 700);
        add(board);
        setSize(1600, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        board.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CannonDemoApp("Cannon Simulation"));
    }
}
