package animate;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CannonBall {
    private double x0, y0;
    private double vx, vy0;
    private double time;
    private boolean active = true;
    private boolean hasExploded = false;
    private Image flameImage;
    private Clip boomClip;

    private double finalX, finalY;

    public CannonBall(double startX, double startY, double angle, double velocity) {
        this.x0 = startX;
        this.y0 = startY;
        this.vx = velocity * Math.cos(angle);
        this.vy0 = -velocity * Math.sin(angle);
        try {
            flameImage = new ImageIcon(getClass().getResource("/media/flame01.png")).getImage();
            AudioInputStream boomStream = AudioSystem.getAudioInputStream(new File("media/boom.wav"));
            boomClip = AudioSystem.getClip();
            boomClip.open(boomStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(double dt) {
        if (!active) return;
        time += dt;
        double newY = y0 + vy0 * time + 0.5 * 500 * time * time;
        if (newY >= 760) {
            active = false;
            hasExploded = true;
            finalX = x0 + vx * time;
            finalY = 760;
            playBoomSound();
        }
    }

    private void playBoomSound() {
        if (boomClip != null) {
            boomClip.setFramePosition(0);
            boomClip.start();
        }
    }

    public void draw(Graphics2D g2d) {
        if (active) {
            double currentX = x0 + vx * time;
            double currentY = y0 + vy0 * time + 0.5 * 500 * time * time;
            g2d.setColor(Color.RED);
            g2d.fillOval((int) currentX - 5, (int) currentY - 5, 10, 10);
        } else if (hasExploded && flameImage != null) {
            g2d.drawImage(flameImage, (int) finalX - 32, (int) finalY - 64, 64, 64, null);
        }
    }

    public boolean isActive() {
        return active || hasExploded;
    }
}
