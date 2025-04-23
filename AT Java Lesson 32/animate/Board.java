package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class Board extends JPanel implements MouseListener, KeyListener {

    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private final int DIAMETER = 20;

    private int x = B_WIDTH / 2;
    private int y = B_HEIGHT / 2;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);
        requestFocusInWindow();

        addMouseListener(this);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
    }

    private void playSound(String fileName) {
        try {
            File soundFile = new File("media/" + fileName);
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + soundFile.getAbsolutePath());
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.printf("Mouse clicked: (x, y) = (%04d, %04d)%n", e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();
        playSound("blip.wav");
    }

    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            x = B_WIDTH / 2;
            y = B_HEIGHT / 2;
            repaint();
            playSound("blop.wav");
        }
    }

    // Unused event methods:
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        Application app = new Application("Lesson 32");
        Board board = new Board();
        app.add(board);
        app.pack();
        app.setVisible(true);
    }
}
