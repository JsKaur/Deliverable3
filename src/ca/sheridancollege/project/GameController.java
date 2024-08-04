/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 *
 * @author Hp
 */
// Following Singleton pattern in this class to handle game logic.
// Controller Class of MVC pattern as it is handling logic of game.
// Reused the logic of card distribution following DRY principle.
public class GameController {
     private static GameController instance;

    private GameController() {
        // private constructor to prevent instantiation
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void playGame(GameEx game) {
        ArrayList<Player> players = game.getPlayers();
        PlayerEx player1 = (PlayerEx) players.get(0);
        PlayerEx player2 = (PlayerEx) players.get(1);

        int round = 0;
        int maxRounds = game.getMaxRounds(); // Access via getter
        while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0 && (maxRounds == 0 || round < maxRounds)) {
            System.out.println("Round " + (round + 1));

            Card card1 = player1.drawCard();
            Card card2 = player2.drawCard();

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            ArrayList<Card> cardsInPlay = new ArrayList<>();
            cardsInPlay.add(card1);
            cardsInPlay.add(card2);

            if (((CardEx) card1).getValue() > ((CardEx) card2).getValue()) {
                System.out.println(player1.getName() + " wins the round.");
                System.out.println("---------------------------------------------------");
                player1.addCards(cardsInPlay);
            } else if (((CardEx) card1).getValue() < ((CardEx) card2).getValue()) {
                System.out.println(player2.getName() + " wins the round.");
                System.out.println("---------------------------------------------------");
                player2.addCards(cardsInPlay);
            } else {
                System.out.println("It's a tie! War is declared!");
                war(player1, player2, cardsInPlay);
            }

            round++;
        }

        declareWinner(game);
    }

    public void declareWinner(GameEx game) {
        PlayerEx player1 = (PlayerEx) game.getPlayers().get(0);
        PlayerEx player2 = (PlayerEx) game.getPlayers().get(1);

        if (player1.getDeckSize() > player2.getDeckSize()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getDeckSize() > player1.getDeckSize()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    public void war(PlayerEx player1, PlayerEx player2, ArrayList<Card> cardsInPlay) {
        // War logic: players put down three cards, then compare the next one
        for (int i = 0; i < 3; i++) {
            if (player1.getDeckSize() > 0) cardsInPlay.add(player1.drawCard());
            if (player2.getDeckSize() > 0) cardsInPlay.add(player2.drawCard());
        }

        if (player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
            Card card1 = player1.drawCard();
            Card card2 = player2.drawCard();
            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            cardsInPlay.add(card1);
            cardsInPlay.add(card2);

            if (((CardEx) card1).getValue() > ((CardEx) card2).getValue()) {
                System.out.println(player1.getName() + " wins the war.");
                player1.addCards(cardsInPlay);
            } else if (((CardEx) card1).getValue() < ((CardEx) card2).getValue()) {
                System.out.println(player2.getName() + " wins the war.");
                player2.addCards(cardsInPlay);
            } else {
                System.out.println("Another tie in war! Continuing war...");
                war(player1, player2, cardsInPlay);
            }
        }
    }

    public static void distributeCards(GroupOfCards deck, PlayerEx player1, PlayerEx player2) {
        // Distribute cards evenly between two players
        ArrayList<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.getCards().add(cards.get(i));
            } else {
                player2.getCards().add(cards.get(i));
            }
        }
    }
}