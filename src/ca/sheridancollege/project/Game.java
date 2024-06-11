package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Saurav Bedi June 2024.
 */
public abstract class Game {

    private final String name; //the title of the game
    private ArrayList<Player> players; // the players of the game.

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    // returns the name.
    public String getName() {
        return name;
    }

    //returns the player of this game.
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // players of the game.
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    // Method to play the game.
    public abstract void play();

    // Use this method to declare and display the winner of the game.
    public abstract void declareWinner();
}
