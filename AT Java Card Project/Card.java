/*
 * 11/15/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to randomize and display cards. 
 * 
 * 
 */
import java.util.Random; 
public class Card {
        // Enumerations
        public enum Suit {SPADE, CLUB, HEART, DIAMOND}
        public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, JACK, QUEEN, KING, ACE}

        // Private memeber variables 

        private Suit suit; 
        private Rank rank; 


        // Default Constructor (The randomized one)  
        public Card() {
            // added "this" to diffrentiate from local variables with same name 
            Random random = new Random(); 
            this.suit = Suit.values()[random.nextInt(Suit.values().length)];
            this.rank = Rank.values()[random.nextInt(Rank.values().length)]; 

        }
        // Parameterized Constructor (Not Random) 
        public Card(Suit suit, Rank rank) {
            this.suit = suit; 
            this.rank = rank; 
        }


        // Public methods 
        public Suit getSuit() {
            return suit; 
        }
        
        public Rank getRank(){
            return rank; 
        }

        public String getFace(){
            // Assigning and converting the suits
            char suitSymbol; 
            char spade   = '\u2660';    // ♠
            char heart   = '\u2661';    // ♡
            char club    = '\u2663';    // ♣
            char diamond = '\u2662';    // ♢

            // 
            switch (suit){
                default -> throw new IllegalStateException("Error: not a valid suit: " + suit);
                case SPADE -> suitSymbol = spade; 
                case CLUB -> suitSymbol = club;
                case HEART -> suitSymbol = heart;
                case DIAMOND -> suitSymbol = diamond; 
            }
            // Assigning the different Ranks 
            String rankValue; 
            switch (rank){
                default -> throw new IllegalStateException("Error not a valid rank: " + rank); 
                case TWO -> rankValue = "2";
                case THREE -> rankValue = "3";
                case FOUR -> rankValue  = "4";
                case FIVE -> rankValue = "5";
                case SIX -> rankValue = "6";
                case SEVEN -> rankValue = "7";
                case EIGHT -> rankValue = "8";
                case NINE -> rankValue = "9";
                case JACK -> rankValue = "J";
                case QUEEN -> rankValue = "Q";
                case KING -> rankValue = "K";
                case ACE -> rankValue = "A";

            }
            return rankValue + suitSymbol;  

        }


        public static void main(String[] args) {
            Card aceOfSpades = new Card(Suit.SPADE, Rank.ACE); 
            System.out.printf("This card is the Ace of Spades: " + aceOfSpades.getFace() + ". %nAlong with that, here are 10 randomly generated cards: %n");
            for (int i = 0; i < 10; i++){
                Card randomCard = new Card();
                System.out.println(randomCard.getFace());
            }

            
        }
    
}
