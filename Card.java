/**
 * Represents a single playing card from a deck of cards.
 */
public class Card
{   
    private String suit;
    private int value;
    private String rank;
    public static final String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"}; 
    public static final String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"}; 
    public static final int[] values = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; 

    /** 
     * Takes a number between 0 and 51 and converts it to a unique
     * card from a standard 52 card deck. 
     * @ param an integer between 0 and 51
     */
    public Card (int card)
    {
        int index = card % 4;
        suit = suits[index];

        index = (card / 4) % 13;
        rank = ranks[index];
        value = values[index];

    }

    /**
     * Produces a string that contains the card's rank and suit
     * @return string with card's rank and suit (e.g. Ace of Hearts)
     */
    public String toString()
    {
        return rank + " of " + suit;  
    }

    /**
     * Get the cards value for a game of Blackjack
     * @return int between 1 and 11
     */
    public int getValue()
    {
        return value;
    }
    public String getRank()
    {
        return rank;
    }
    public String getSuit()
    {
        return suit;
    }
}
