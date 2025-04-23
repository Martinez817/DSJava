package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener {
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(1600, 900));
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int floor = getHeight() - 25;
        g.setColor(Color.GREEN);
        g.fillRect(0, floor, getWidth(), getHeight() - floor);
        g.setColor(Color.BLACK);
        g.drawLine(0, floor, getWidth(), floor);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
        } else if (key == KeyEvent.VK_LEFT) {
            System.out.println("Left arrow was pressed.");
        } else if (key == KeyEvent.VK_RIGHT) {
            System.out.println("Right arrow was pressed.");
        } else if (key == KeyEvent.VK_UP) {
            System.out.println("Up arrow was pressed.");
        } else if (key == KeyEvent.VK_DOWN) {
            System.out.println("Down arrow was pressed.");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
