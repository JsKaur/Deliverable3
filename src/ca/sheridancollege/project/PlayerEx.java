package ca.sheridancollege.project;

import java.util.ArrayList;

// this class extends Player Class. 
public class PlayerEx extends Player {

    private ArrayList<Card> cards; // represents deck of card.

    public PlayerEx(String name) {
        super(name);
        
        cards = new ArrayList<>();
    }

    @Override
    public void play() {
        
    }

    // returns list of cards held by player.
    public ArrayList<Card> getCards() {
        return cards;
    }

    // sets player cards.
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // removes first card.
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0); 
    }

    // adds list of card to player's hand.
    public void addCards(ArrayList<Card> wonCards) {
        cards.addAll(wonCards); 
    }

    

    // returns number of cards.
    public int getDeckSize() {
        return cards.size();
    }
}
