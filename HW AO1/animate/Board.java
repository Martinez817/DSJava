package animate;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int SIDE_LEN = 150; 

    public Board() {
        setBackground(Color.CYAN); 
        setPreferredSize(new java.awt.Dimension(B_WIDTH, B_HEIGHT)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    
        int x_t = B_WIDTH / 2 - SIDE_LEN / 2;
        int y_t = B_HEIGHT / 2 - SIDE_LEN / 2;
    
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x_t, y_t);
        affineTransform.rotate(Math.toRadians(22.5), SIDE_LEN / 2.0, SIDE_LEN / 2.0);
    
        Rectangle rect = new Rectangle(0, 0, SIDE_LEN, SIDE_LEN);
        Shape transformedShape = affineTransform.createTransformedShape(rect);
    
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);
    
        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello, world!", 10, 20);
    }
    

    public static void main(String[] args) {
        Application app = new Application("Rotated Rectangle");
        Board board = new Board();
        app.add(board);
        app.pack();
        app.setVisible(true);
    }
}



