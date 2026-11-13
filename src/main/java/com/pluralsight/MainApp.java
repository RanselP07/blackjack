package com.pluralsight;

import java.util.HashMap;
import java.util.Scanner;

public class MainApp {
    static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean playAgain = true;
        String response = "";

        do {
            //Array of player names
            String[] name = Player.name(myScanner);
            //Array of hand
            int[] play = new int[name.length];
            HashMap<Integer, String> stats = new HashMap<>();

            //Shuffle the deck
            Deck deck = new Deck();
            deck.shuffle();

            for (int i = 0; i < name.length; i++) {
                // Each player plays till the end of its turn
                System.out.print("\n\nIt's " + name[i] + " turn...");
                play[i] = Player.play(myScanner, deck);

                // Hashmap only stores the players hand is less than or equal to 21
                if (play[i] <= 21) {
                    stats.put(play[i], name[i]);
                }
            }

            // Shows the winner (if there is any)
            winner(stats);
            // Ask the user if they would like to play again.
            do {
                System.out.print("\nWould you like to play again? (yes/no): ");
                response = myScanner.nextLine().trim().toLowerCase();

                if (!response.equals("yes") && !response.equals("no")) {
                    System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                }
            } while (!response.equals("yes") && !response.equals("no"));

            if (response.equals("no")) {
                playAgain = false;
            }

        } while (playAgain);

        System.out.println("Thanks for playing!");

    }

    private static void winner(HashMap<Integer, String> stats) {

        int winningScore = 0;

        for (Integer score : stats.keySet()) {
            if (score > winningScore) {
                winningScore = score;
            }
        }

        System.out.print("\nAnd the winner is...");

        if (winningScore == 0) {
            System.out.println("\nNo one. All of you are horrible at this game.");
        }

        if (winningScore > 0) {
            String winningPlayer = stats.get(winningScore);
            System.out.println("\n" + winningPlayer + " with a score of " + winningScore);
        }

    }
}
