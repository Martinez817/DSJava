package animate;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Board extends JPanel {
   
   
    
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private Image image;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new java.awt.Dimension(B_WIDTH, B_HEIGHT));
        loadImage();
    }

    private void loadImage() {
      
        ImageIcon ii = new ImageIcon(getClass().getResource("/HW_AO2/media/Celtics.jpeg")); // Ensure the image is in the 'media' folder within the classpath
        image = ii.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calculate scaling factors
        double scaleX = 0.25;
        double scaleY = 0.25;

        // Calculate translation to lower-right corner
        int imgWidth = (int) (image.getWidth(null) * scaleX);
        int imgHeight = (int) (image.getHeight(null) * scaleY);
        int x_t = B_WIDTH - imgWidth;
        int y_t = B_HEIGHT - imgHeight;

        // Apply transformations
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x_t, y_t);
        affineTransform.scale(scaleX, scaleY);

        // Draw the transformed image
        g2d.drawImage(image, affineTransform, this);
    }

    public static void main(String[] args) {
        Application app = new Application("Image Transformation");
        Board board = new Board();
        app.add(board);
        app.pack();
        app.setVisible(true);
    
}
}