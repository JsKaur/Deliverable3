
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 
 */
public abstract class Player {

    private String name; //the unique name for this player
    private ArrayList<Card> cards;

   // A constructor that allows you to set the player's unique ID
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

   // return the player name.
    public String getName() {
        return name;
    }

    // setting the name of player.
    public void setName(String name) {
        this.name = name;
    }

   

     public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    // abstract method for the logic of the game.
    public abstract void play();

}
