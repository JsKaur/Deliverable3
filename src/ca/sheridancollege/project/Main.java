package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

// Serving as View Class.
public class Main {
    public static void main(String[] args) {
        
        GroupOfCards deck = new GroupOfCards(52);
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        // Using Factory pattern to create CardEx instances.
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                // Use the public factory method to create CardEx instances
                deck.addCard(CardEx.createCard(suit, ranks[i], values[i]));
            }
        }

        //calling shuffle method.
        deck.shuffle();

       // Using Factory pattern to create PlayerEx.
        PlayerEx player1 = new PlayerEx("Player 1");
        PlayerEx player2 = new PlayerEx("Player 2");

        GameController.distributeCards(deck, player1, player2);
        

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of rounds (0 for infinite): ");
        int maxRounds = scanner.nextInt();
        
        GameEx game = new GameEx("War",maxRounds);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game.setPlayers(players);

        //calling play method.
        game.play();
    }
}
    













