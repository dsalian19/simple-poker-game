import java.util.ArrayList;
import java.util.*;
/**
 * represents a player's hand of 5 cards
 */
public class Hand
{
    private ArrayList<Card> myHand;
    private int[] totalNumber;
    public Hand()
    {
        myHand = new ArrayList<Card>();
        totalNumber = new int[15];
    }
    //return the top card
    public Card getCard ()
    {
        return myHand.remove(0);
    }
    //returns a copy of the card at position x, does not remove it
    public Card getCard(int x)
    {
        return myHand.get(x);
    }
    //returns the number of cards currently in the hand
    public int getHandSize()
    {
        return myHand.size();
    }
    //add a card to the hand
    public void addCard(Card c)
    {
        myHand.add(0,c);
        for(int i=0; i<myHand.size()-1; i++)
        {
            if(myHand.get(i).getValue()>myHand.get(i+1).getValue())
            {
                myHand.set(i,myHand.set(i+1,myHand.get(i)));
            }   
        }
        int v = c.getValue();
        totalNumber[v] ++;
    }
    //remove card from the hand
    public Card discardCard(int i)
    {
        Card c = myHand.remove(i);
        int v = c.getValue();
        totalNumber[v] -=1;
        return c;
    }
    
    //next methods check hand
    public boolean checkRoyal()
    {
        for(int i = 0; i<myHand.size(); i++)
        {
            if(myHand.get(i).getValue() != i+10)
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkFlush()
    {
        String s = myHand.get(0).getSuit();
        for(Card c: myHand)
        {
            if(!c.getSuit().equals(s))
            {
                 return false;
            }
        }
        return true;
    }
    public boolean checkStraight()
    {
        for(int i = 0; i < myHand.size()-1; i++)
        {
            if(myHand.get(i).getValue() != myHand.get(i+1).getValue()-1)
            {
                return false;
            }
        }
        return true;
    }
    public int numberOfAKind()
    {
        int max = 0;
        for(int n: totalNumber)
        {
            if(n>max)
            {
                max = n;
            }
        }
        return max;
    }
    public boolean checkFullHouse()
    {
        boolean checkThree = false;
        boolean checkTwo = false;
        for(int n: totalNumber)
        {
            if(n == 3)
            {
                checkThree = true;
            }
            else if(n == 2)
            {
                checkTwo = true;
            }
        }
        if(checkThree && checkTwo)
        {
            return true;
        }
        return false;
    }
    public boolean checkTwoPair()
    {
        int count = 0;
        for(int n: totalNumber)
        {
            if(n == 2)
            {
                count++;
            }
        }
        if(count == 2)
        {
            return true;
        }
        return false;
    }
    
    public int checkBestHand()
    {
        if(checkRoyal())
        {
            System.out.println("You have a royal flush!");
            return 1;
        }
        else if(checkFlush() && checkStraight())
        {
            System.out.println("You have a straight flush!");
            return 2;
        }
        else if(numberOfAKind() == 4)
        {
            System.out.println("You have 4 of a kind!");
            return 3;
        }
        else if(checkFullHouse())
        {
            System.out.println("You have a full house!");
            return 4;
        }
        else if(checkFlush())
        {
            System.out.println("You have a flush!");
            return 5;
        }
        else if(checkStraight())
        {
            System.out.println("You have a straight!");
            return 6;
        }
        else if(numberOfAKind() == 3)
        {
            System.out.println("You have 3 of a kind!");
            return 7;
        }
        else if(checkTwoPair())
        {
            System.out.println("You have 2 pairs!");
            return 8;
        }
        else if(numberOfAKind() == 2)
        {
            System.out.println("You have 1 pair!");
            return 9;
        }
        else
        {
            System.out.println("You have a high card!");
            return 10;
        }
    }
    
    public void printHand()
    {
        for(int i=0; i<myHand.size(); i++)
        {
            int num = i+1;
            System.out.println(num+". "+myHand.get(i).getRank()+" of "+myHand.get(i).getSuit());
        }
    }
}
