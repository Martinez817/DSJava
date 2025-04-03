package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    
    private Image image;
    private double x = 0;
    private double y = 0;
    private double angle = 0;

    private final double xSpeed = 1;
    private final double ySpeed = 1;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITIAL_DELAY, PERIOD_INTERVAL);
    }

    private void loadImage() {
        try {
            String filePath = "/Users/martinez/Documents/GitHub/DSJava/HW AO2 PART 2/media/Andy.png";
            image = new ImageIcon(filePath).getImage();
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private class ScheduledUpdate extends TimerTask {
        public void run() {
            x += xSpeed;
            y += ySpeed;

            angle += 5;
            if (angle >= 360) {
                angle = 0;
            }

            if (x > B_WIDTH) {
                x = 0;
            }
            if (y > B_HEIGHT) {
                y = 0;
            }

            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        affineTransform.rotate(Math.toRadians(angle), image.getWidth(null) / 2.0, image.getHeight(null) / 2.0);

        g2d.drawImage(image, affineTransform, this);
    }

    public static void main(String[] args) {
        Application app = new Application("Rotating Image");
        Board board = new Board();
        app.add(board);
        app.pack();
        app.setVisible(true);
    }
}
