package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
/**
 * A concrete class that represents any grouping of cards for a Game. 
 *
 
 */
// Model Class representing a group of cards.
public class GroupOfCards {
    //The group of cards, stored in an ArrayList.
    private ArrayList<Card> cards;
    private int size; //the size of the grouping

    
    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    // the group of cards as an ArrayList.
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    // returns the size of the group of cards.
    public int getSize() {
        return size;
    }

    //the max size for the group of cards.
    public void setSize(int size) {
        this.size = size;
    }
}
