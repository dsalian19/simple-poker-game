import java.util.Scanner;
/**
 * Run the game class to play
 * 
 * 2 player game
 */
public class Game
{
    public static void main (String[] args)
    {
        //create a new deck and shuffle it
        Deck d1 = new Deck();
        System.out.println("Shuffling...");
        d1.shuffleDeck();
        
        //creating each player's hand
        Hand h1 = new Hand();
        Hand h2 = new Hand();
        
        //dealing the cards to each hand
        System.out.println("Dealing...");
        for(int i = 0; i<10; i++)
        {
            if(i%2 == 0)
            {
                h1.addCard(d1.getCard());
            }
            else
            {
                h2.addCard(d1.getCard());
            }
        }
        
        System.out.println("Ready! Hit ENTER to continue.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("-------------------------------------");
        
        //Player 1 decisions
        System.out.println("Player 1 Hand: ");
        h1.printHand();
        System.out.println("");
        System.out.print("Player 1 - How many cards do you want to discard? ");
        int num1 = sc.nextInt(); 
        for(int j = 1; j<=num1; j++)
        {
            System.out.print("Which card would you like to discard? (1,2,3...) ");
            int x = sc.nextInt() -1;
            h1.discardCard(x);
            h1.printHand();
        }
        
        
        //player 2 decisions
        System.out.println("-------------------------------------");
        System.out.println("Player 2 Hand: ");
        h2.printHand();
        System.out.println("");
        System.out.print("Player 2 - How many cards do you want to discard? ");
        int num2 = sc.nextInt(); 
        for(int j = 1; j<=num2; j++)
        {
            System.out.print("Which card would you like to discard? (1,2,3...) ");
            int x = sc.nextInt() -1;
            h2.discardCard(x);
            h2.printHand();
        }
        System.out.println("-------------------------------------");
        
        //adding new cards to each player's hand depending on how many they discarded
        for(int k = 0; k<num1; k++)
        {
            h1.addCard(d1.getCard());
        }
        for(int k = 0; k<num2; k++)
        {
            h2.addCard(d1.getCard());
        }
        
        //printing each player's final hand
        System.out.println("Player 1 Hand:");
        h1.printHand();
        System.out.println("");
        System.out.println("Player 2 Hand:");
        h2.printHand();
        System.out.println("-------------------------------------");
        
        //printing results
        System.out.println("Player 1's Results:");
        int h1Score = h1.checkBestHand();
        System.out.println("");
        System.out.println("Player 2's Results:");
        int h2Score = h2.checkBestHand();
        System.out.println("-------------------------------------");
        System.out.println("And the result is: ");
        
        //printing winner
        if(h1Score < h2Score)
        {
            System.out.println("Player 1 Wins!");
        }
        else
        {
            System.out.println("Player 2 Wins!");
        }
    }
}
