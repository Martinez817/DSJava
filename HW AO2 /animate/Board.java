package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Board extends JPanel {
    private final int B_WIDTH = 600                                                                                                           ;
    private final int B_HEIGHT = 600;
    private Image image;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImage();
    }

    private void loadImage() {
        java.net.URL imageUrl = getClass().getResource("/media/Celtics.jpg");
        if (imageUrl == null) {
            System.out.println("Error: Image not found.");
            return;
        }
        image = new ImageIcon(imageUrl).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            System.out.println("Error: Image not loaded.");
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);

        // Calculate scaling factors to fit the image in the bottom-right quadrant
        double scaleX = (B_WIDTH / 2.0) / imgWidth;
        double scaleY = (B_HEIGHT / 2.0) / imgHeight;
        double scale = Math.min(scaleX, scaleY); // Maintain aspect ratio

        int scaledWidth = (int) (imgWidth * scale);
        int scaledHeight = (int) (imgHeight * scale);

        // Position the image in the bottom-right quadrant
        int x_t = B_WIDTH / 2 + (B_WIDTH / 2 - scaledWidth) / 2;
        int y_t = B_HEIGHT / 2 + (B_HEIGHT / 2 - scaledHeight) / 2;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x_t, y_t);
        affineTransform.scale(scale, scale);

        g2d.drawImage(image, affineTransform, this);

        System.out.println("Drawing image at: (" + x_t + ", " + y_t + ") with size: " + scaledWidth + "x" + scaledHeight);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mini Demo - Image Transformation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            Board board = new Board();
            frame.add(board);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
