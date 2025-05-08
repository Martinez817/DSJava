package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import javax.sound.sampled.*;

public class Cannon {
    private double x, y, angle;
    private Image image;
    private Clip wheelClip, cannonClip;

    public Cannon(double x, double y) {
        this.x = x;
        this.y = y;
        this.angle = Math.toRadians(45);

        try {
            image = new ImageIcon(getClass().getResource("/media/sm_cannon.png")).getImage();
            AudioInputStream wheelStream = AudioSystem.getAudioInputStream(new File("media/wheel.wav"));
            wheelClip = AudioSystem.getClip();
            wheelClip.open(wheelStream);
            AudioInputStream cannonStream = AudioSystem.getAudioInputStream(new File("media/cannon.wav"));
            cannonClip = AudioSystem.getClip();
            cannonClip.open(cannonStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rotateLeft() {
        if (angle < Math.toRadians(90)) {
            angle += Math.toRadians(5);
            if (wheelClip.isRunning()) wheelClip.stop();
            wheelClip.setFramePosition(0);
            wheelClip.start();
        }
    }

    public void rotateRight() {
        if (angle > 0) {
            angle -= Math.toRadians(5);
            if (wheelClip.isRunning()) wheelClip.stop();
            wheelClip.setFramePosition(0);
            wheelClip.start();
        }
    }

    public void fire() {
        if (cannonClip.isRunning()) cannonClip.stop();
        cannonClip.setFramePosition(0);
        cannonClip.start();
    }

    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        AffineTransform at = new AffineTransform();

        double pivotX = x + 15;
        double pivotY = y + 25.5;

        at.translate(pivotX, pivotY);
        at.rotate(-angle);
        at.translate(-15, -25.5);

        g2d.drawImage(image, at, null);
        g2d.setTransform(old);

        g2d.setColor(Color.BLUE);
        g2d.fillOval((int)(pivotX - 5), (int)(pivotY - 5), 10, 10);

        Polygon base = new Polygon();
        base.addPoint((int)pivotX - 20, (int)pivotY);
        base.addPoint((int)pivotX + 20, (int)pivotY);
        base.addPoint((int)pivotX, (int)(pivotY + 30));

        double flipAngle = Math.toRadians(180);
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        for (int i = 0; i < 3; i++) {
            int xOffset = base.xpoints[i] - (int)pivotX;
            int yOffset = base.ypoints[i] - (int)pivotY;
            xPoints[i] = (int)(pivotX + xOffset * Math.cos(flipAngle) - yOffset * Math.sin(flipAngle));
            yPoints[i] = (int)(pivotY + xOffset * Math.sin(flipAngle) + yOffset * Math.cos(flipAngle));
        }

        int triangleOffsetY = 30;
        for (int i = 0; i < 3; i++) {
            yPoints[i] += triangleOffsetY;
        }

        g2d.setColor(Color.PINK);
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xPoints, yPoints, 3);
    }
}
