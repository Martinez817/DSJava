package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    
    private Image image;
    private double x;
    private double y;
    private double angle = 0;

    private double xSpeed;
    private double ySpeed;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private SoundClip sitarMusic;
    private SoundClip owSound;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();
        loadSounds();

        x = B_WIDTH / 2 - image.getWidth(null) / 2;
        y = B_HEIGHT / 2 - image.getHeight(null) / 2;

        Random random = new Random();
        xSpeed = random.nextInt(5) + 1;
        ySpeed = random.nextInt(5) + 1;

        sitarMusic.setLoop(true);
        sitarMusic.play();

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITIAL_DELAY, PERIOD_INTERVAL);
    }

    private void loadImage() {
        try {
            String filePath = "/Users/martinez/Documents/GitHub/DSJava/HW AO3 PART 2/media/Lucas.png";
            image = new ImageIcon(filePath).getImage();
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private void loadSounds() {
        try {
            sitarMusic = new SoundClip("/Users/martinez/Documents/GitHub/DSJava/HW AO3 PART 2/media/sitar.wav");
            owSound = new SoundClip("/Users/martinez/Documents/GitHub/DSJava/HW AO3 PART 2/media/ow.wav");
        } catch (Exception e) {
            System.out.println("Error loading sounds: " + e.getMessage());
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

            if (x <= 0 || x + image.getWidth(null) >= B_WIDTH) {
                xSpeed = -xSpeed;
                owSound.play();
            }

            if (y <= 0 || y + image.getHeight(null) >= B_HEIGHT) {
                ySpeed = -ySpeed;
                owSound.play();
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
        Application app = new Application("Bouncing Image with Sound");
        Board board = new Board();
        app.add(board);
        app.pack();
        app.setVisible(true);
    }
}
