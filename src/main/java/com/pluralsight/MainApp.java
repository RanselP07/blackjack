package com.pluralsight;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MainApp {
    static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean done = false;

        String[] name = Player.name(myScanner);
        int[] play = new int[name.length];
        HashMap<Integer, String> stats = new HashMap<>();

        //Shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < name.length; i++) {
            System.out.print("\n\nIt's " + name[i] + " turn...");
            play[i] = Player.play(myScanner, deck);

            if (play[i] <= 21) {
                stats.put(play[i], name[i]);
            }
        }

//        System.out.print("\n\nIts " + name[0] + " turn...");
//        int player1 = Player.play(myScanner, deck);
//
//        System.out.print("\n\nIts " + name[1] + " turn...");
//        int player2 = Player.play(myScanner, deck);

        String winner = winner(stats);
    }

    private static String winner(HashMap<Integer, String> stats) {
        String winner = "";

        int winningScore = 0;

        for (Integer score : stats.keySet()){
            if (score > winningScore){
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

        return winner;
    }

}