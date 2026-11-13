package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean done = false;

        String[] name = Player.name(myScanner);

        //Shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("\n\nIts " + name[0] + " turn...");
        int player1 = Player.play(myScanner, deck);

        System.out.print("\n\nIts " + name[1] + " turn...");
        int player2 = Player.play(myScanner, deck);

        String winner = winner(player1, player2, name);
    }

    private static String winner(int player1, int player2, String[] name) {
        String winner = "";


        System.out.print("\nAnd the winner is...");


        if (player1 <= 21 && (player1 > player2 || player2 > 21)){
            System.out.print("\n" + name[0] + " with a score of " + player1 + ":" + player2);
        } else if (player2 <= 21 && (player2 > player1 || player1 > 21)){
            System.out.print("\n" + name[1]  + " with a score of " + player1 + ":" + player2);
        } else if ((player1 == player2)){
            System.out.print("\nNo one, it's a draw. with a score of " + player1 + ":" + player2);
        } else {
            System.out.println("\nNo one. Both of you are horrible at this game.");
        }

        return winner;
    }

}