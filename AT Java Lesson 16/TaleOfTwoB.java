
import java.util.Arrays; 

public class TaleOfTwoB {

    public static void squares(double[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.pow(values[i], 2); 
        }
    }

    public static void main(String[] args) {
        double[] scores = { 32, 54, 67.5, 29, 35 };
        System.out.println("Scores: " + Arrays.toString(scores));
        squares(scores);
        System.out.println("Scores: " + Arrays.toString(scores));
    }
}
