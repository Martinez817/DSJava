package animate; 
import javax.swing.Jframe;

public class Application extends JFrame {
    public static int FRAMNE_WIDTH = 800;
    public static int FRAME_HEIGHT = 600;

    public Application(String title) {
        setTitle(title); 
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        
    }
}


 





