/*
 * 2/24/2025
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * Blackjack 
 */


import java.util.Scanner;
import java.util.Random;
 

public class Blackjack {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random random = new Random(); 
        boolean playAgain = true; 

        while (playAgain){
            String[] playerHand = new String[10];
            int[] playerHandValues = new int[10];
            String [] dealerHand = new String[10];
            int[] dealerHandValues = new int[10];
            int playerHandSize = 0;
            int dealerHandSize = 0;

            playerHandSize = drawCard(random, playerHand, playerHandValues, playerHandSize);
            playerHandSize = drawCard(random, dealerHand, dealerHandValues, dealerHandSize);
            dealerHandSize = drawCard(random, dealerHand, dealerHandValues, dealerHandSize);
            dealerHandSize = drawCard(random, dealerHand, dealerHandValues, dealerHandSize);

            System.out.println("Dealer's hand: " );
            System.out.println("Your hand: " + handToString(playerHand, playerHandSize)); 

            boolean playerTurn = true; 
            while (playerTurn) {
                System.out.print("Do you want to hit or stand? (h/s): ");
                String action = in.nextLine();
                if (action.equalsIgnoreCase("h")) {
                    playerHandSize = drawCard(random, playerHand, playerHandValues, playerHandSize);
                    System.out.println("Your hand: " + handToString(playerHand, playerHandSize) + " (Total: " + handValue(playerHandValues, playerHandSize) + ")");
                    if (handValue(playerHandValues, playerHandSize) > 21) {
                        System.out.println("You bust! Dealer wins.");
                        playerTurn = false;
                    }
                } else if (action.equalsIgnoreCase("s")) {
                    playerTurn = false;
                }
                else {
                    System.out.printf("%nInvalid input. Please enter 'h' or 's'.%n");
                }
            }

            if (handValue(playerHandValues, playerHandSize) <= 21) {
                System.out.println("Dealer's hand: " + handToString(dealerHand, dealerHandSize) + " (Total: " + handValue(dealerHandValues, dealerHandSize) + ")");
                while (handValue(dealerHandValues, dealerHandSize) < 17) {
                    dealerHandSize = drawCard(random, dealerHand, dealerHandValues, dealerHandSize);
                    System.out.println("Dealer's hand: " + handToString(dealerHand, dealerHandSize) + " (Total: " + handValue(dealerHandValues, dealerHandSize) + ")");
                }

                if (handValue(dealerHandValues, dealerHandSize) > 21 || handValue(playerHandValues, playerHandSize) > handValue(dealerHandValues, dealerHandSize)) {
                    System.out.println("You win!");
                } else if (handValue(playerHandValues, playerHandSize) < handValue(dealerHandValues, dealerHandSize)) {
                    System.out.println("Dealer wins.");
                } else {
                    System.out.println("It's a tie.");
                }
            }

            System.out.printf("%nDo you want to play again? (Type either 'Yes' or 'No'): ");
            String playAgainResponse = in.nextLine();
            if (playAgainResponse.equalsIgnoreCase("no")){
                System.out.printf("%nThanks for playing!%n");
                playAgain = false;
            } else if (playAgainResponse.equalsIgnoreCase("yes")){

            playAgain = true; 
            }
        }
         in.close();
    }

    
    


    private static int drawCard(Random random, String[] hand, int[] handValues, int handSize){
        Card card = drawCard(random);
        hand[handSize] = card.toString();
        handValues[handSize] = card.getValue();
        handSize++;
        return handSize;
    }
    private static Card drawCard (Random random){
        String suit = SUITS[random.nextInt(SUITS.length)];
        int rankIndex = random.nextInt(RANKS.length); 
        String rank = RANKS[rankIndex];
        int value = VALUES[rankIndex];
        return new Card(suit, rank, value);
    }

    private static int handValue(int[] hand, int cardCount){
        int value = 0; 
        int numAces = 0; 
        for (int cardValue : hand){
            if (cardValue == 11){
                numAces++;
            }
            value += cardValue;
        }
        while (value > 21 && numAces > 0){
            value -= 10;
            numAces--;
        }
        return value;
    }

    private static String handToString(String[] hand, int cardCount){
        String result = ""; 
        for (int i = 0; i < cardCount; i++){
            result += hand[i]; 
            if (i < cardCount - 1){
                result += ", ";
            }
        }
        return result; 
    }

    
}

class Card {
    private String suit; 
    private String rank;
    private int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }
    
}