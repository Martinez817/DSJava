/*
 * 11/22/24
 * Sw design with Java 
 * Jonathan Martinez 
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class redAndBlue {
  
    public static final int TILE_SIZE = 100;
    public static final int GRID_SIZE = 400; 


    public static Color getTileColor (int row, int col){
        if ((row + col) % 2 == 0){
           return Color.BLUE; 
        } else {
            return Color.RED; 
        }
    }

    public static void RowBuilder(Graphics g, Color color, int x, int y){
        g.setColor(color); 
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

    }

    public static void draw(Graphics g) {
        
    
        for (int i = 0; i < GRID_SIZE / TILE_SIZE; i++){
            for (int col = 0; col < GRID_SIZE / TILE_SIZE; col++){
                Color color = getTileColor(i , col); 
                RowBuilder(g, color, col * TILE_SIZE, i * TILE_SIZE); 
            }
            
        }
        
    }




    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}


