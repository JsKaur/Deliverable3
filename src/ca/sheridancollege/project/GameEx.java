package ca.sheridancollege.project;

import java.util.ArrayList;

// This class extends Game class.
public class GameEx extends Game {

    private GroupOfCards deck;// Model: representing the deck of cards.
    private int maxRounds; // the maximum number of rounds to play.
    private GameController controller; // private constructor to prevent direct instantiation.
    
    // Factory Method pattern for creating games as it encapsulates creation of GameEx object.
    public static GameEx createGame(String name, int maxRounds) {
        return new GameEx(name, maxRounds);
    }

    public GameEx(String name, int maxRounds) {
        super(name);
        this.deck = new GroupOfCards(52);
        this.maxRounds = maxRounds;
        this.controller = GameController.getInstance();
    }

    public GroupOfCards getDeck() {
        return deck;
    }
    
    public int getMaxRounds() {
        return maxRounds;
    }

    // Following Single Responsibility Principle as now play() method transfers actual game logic to 'GameController'.
     @Override
    public void play() {
        controller.playGame(this);
    }

    // Following Single Responsibility Principle as now declareWinner() method transfers task of determining winner to 'GameController'.
    @Override
    public void declareWinner() {
        controller.declareWinner(this);
    }
}