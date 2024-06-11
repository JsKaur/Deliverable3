package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        GroupOfCards deck = new GroupOfCards(52);
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.addCard(new CardEx(suit, ranks[i], values[i]));
            }
        }

        //calling shuffle method.
        deck.shuffle();

       
        PlayerEx player1 = new PlayerEx("Player 1");
        PlayerEx player2 = new PlayerEx("Player 2");

        
        distributeCards(deck, player1, player2);

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

    private static void distributeCards(GroupOfCards deck, PlayerEx player1, PlayerEx player2) {
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













