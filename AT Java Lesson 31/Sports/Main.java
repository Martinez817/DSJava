
public class Main {
        public static void main(String[] args) {
            System.out.printf("%nThank you for using the Baseball Card Collection Tracker!%n%n");
            BaseballCard card1 = new BaseballCard("Babe Ruth", 1933);
            BaseballCard card2 = new BaseballCard("Babe Ruth", 1933);
            System.out.println(card1);
            System.out.println(card2);
            System.out.println(card1.equals(card2));
        }
    
}
