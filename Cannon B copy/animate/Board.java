package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel {
    private Cannon cannon;

    public Board(double x, double y) {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(1600, 900));
        setFocusable(true);
        requestFocusInWindow();
        cannon = new Cannon(x, y);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> rotateLeft();
                    case KeyEvent.VK_RIGHT -> rotateRight();
                    case KeyEvent.VK_SPACE -> fire();
                }
            }
        });
    }

    public void rotateLeft() {
        cannon.rotateLeft();
        repaint();
    }

    public void rotateRight() {
        cannon.rotateRight();
        repaint();
    }

    public void fire() {
        cannon.fire();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int floor = getHeight() - 25;
        g.setColor(Color.GREEN);
        g.fillRect(0, floor, getWidth(), getHeight() - floor);
        g.setColor(Color.BLACK);
        g.drawLine(0, floor, getWidth(), floor);
        Graphics2D g2d = (Graphics2D) g;
        cannon.draw(g2d);
    }
}
