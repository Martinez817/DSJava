package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel {
    private Cannon cannon;
    private ArrayList<CannonBall> cannonBalls;
    private Timer timer;
    private double velocity = 200;

    public Board(double x, double y) {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(1600, 900));
        setFocusable(true);
        requestFocusInWindow();

        cannon = new Cannon(x, y);
        cannonBalls = new ArrayList<>();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> rotateLeft();
                    case KeyEvent.VK_RIGHT -> rotateRight();
                    case KeyEvent.VK_SPACE -> fire();
                    case KeyEvent.VK_UP -> {
                        velocity += 10;
                        repaint();
                    }
                    case KeyEvent.VK_DOWN -> {
                        velocity = Math.max(10, velocity - 10);
                        repaint();
                    }
                }
            }
        });

        timer = new Timer(20, e -> {
            ArrayList<CannonBall> toRemove = new ArrayList<>();
            for (CannonBall ball : cannonBalls) {
                ball.update(0.02);
                if (!ball.isActive()) {
                    toRemove.add(ball);
                }
            }
            cannonBalls.removeAll(toRemove);
            repaint();
        });
        timer.start();
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
        double angle = cannon.getAngle();
        double[] barrel = cannon.getBarrelEnd();
        double cannonX = barrel[0];
        double cannonY = barrel[1];
        CannonBall ball = new CannonBall(cannonX, cannonY, angle, velocity);
        cannonBalls.add(ball);
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

        for (CannonBall ball : cannonBalls) {
            ball.draw(g2d);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Velocity: " + (int)velocity, 20, 30);
        g2d.drawString("Angle: " + String.format("%.2f", Math.toDegrees(cannon.getAngle())), 20, 60);


    }
}
