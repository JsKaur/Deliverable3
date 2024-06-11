package ca.sheridancollege.project;

// class extending Card Class.
public class CardEx extends Card {
    private String suit;
    private String rank;
    private int value;

    public CardEx(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    // accessing and modifying the properties of Card:
    
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // implementing method of abstract class Card.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
