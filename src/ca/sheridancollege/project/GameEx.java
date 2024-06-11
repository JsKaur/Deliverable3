package ca.sheridancollege.project;

import java.util.ArrayList;

// This class extends Game class.
public class GameEx extends Game {

    private GroupOfCards deck;// representing the deck of cards.
    private int maxRounds; // the maximum number of rounds to play.

    public GameEx(String name, int maxRounds) {
        super(name);
        this.deck = new GroupOfCards(52);
        this.maxRounds = maxRounds;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    @Override
public void play() {
    ArrayList<Player> players = getPlayers();
    PlayerEx player1 = (PlayerEx) players.get(0);
    PlayerEx player2 = (PlayerEx) players.get(1);

    int round = 0;
    while (player1.getDeckSize() > 0 && player2.getDeckSize() > 0 && (maxRounds == 0 || round < maxRounds)) {
        System.out.println("Round " + (round + 1));

        Card card1 = player1.drawCard();
        Card card2 = player2.drawCard();

        System.out.println(player1.getName() + " plays " + card1);
        System.out.println(player2.getName() + " plays " + card2);

        ArrayList<Card> cardsInPlay = new ArrayList<>();
        cardsInPlay.add(card1);
        cardsInPlay.add(card2);

        // Check for a tie and handle it
        while (((CardEx) card1).getValue() == ((CardEx) card2).getValue()) {
            System.out.println("It's a tie! Starting a war...");
            if (player1.getDeckSize() < 4 || player2.getDeckSize() < 4) {
                System.out.println("Player not having enough cards");
                break;
            }
            for (int i = 0; i < 3; i++) { // Draw three cards face-down
                cardsInPlay.add(player1.drawCard());
                cardsInPlay.add(player2.drawCard());
            }
            card1 = player1.drawCard();
            card2 = player2.drawCard();
            cardsInPlay.add(card1);
            cardsInPlay.add(card2);
            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);
        }

        // Determine the winner of the round
        if (((CardEx) card1).getValue() > ((CardEx) card2).getValue()) {
            player1.addCards(cardsInPlay);
            System.out.println(player1.getName() + " wins the round");
            System.out.println("--------------------------");
        } else if (((CardEx) card1).getValue() < ((CardEx) card2).getValue()) {
            player2.addCards(cardsInPlay);
            System.out.println(player2.getName() + " wins the round");
            System.out.println("--------------------------");
        }

        round++;
    }

    declareWinner();
}

    @Override
    //  overall winner of the game.
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        PlayerEx player1 = (PlayerEx) players.get(0);
        PlayerEx player2 = (PlayerEx) players.get(1);

        if (player1.getDeckSize() > player2.getDeckSize()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1.getDeckSize() < player2.getDeckSize()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }
    }
}


