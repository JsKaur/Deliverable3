package ca.sheridancollege.project;

// Concrete class extending Card class, representing a specific card.
// This class is Model of MVC pattern as it is showing internal representation of information.
public class CardEx extends Card {
    private String suit;
    private String rank;
    private int value;

    // Factory Method pattern for creating cards. Now, it is encapsulating instantiation logic and allows easy modification.
   public static CardEx createCard(String suit, String rank, int value) {
        return new CardEx(suit, rank, value);
    }

    private CardEx(String suit, String rank, int value) {
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

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
