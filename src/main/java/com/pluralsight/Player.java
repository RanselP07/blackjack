package com.pluralsight;

import java.util.Scanner;

public class Player {

    public static String[] name(Scanner myScanner) {
        System.out.println("");

        String[] name = new String[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            name[i] = myScanner.nextLine();

            if (name[i] == null || name[i].isBlank()) {
                name[i] = "P" + (i + 1);
            }
        }

        System.out.print("\n" + name[0] + " Vs. " + name[1]);
        return name;
    }

    public static int play(Scanner myScanner, Deck deck){
        boolean done = false;

        //Handles player 1 hand
        Hand player1 = new Hand();

        //get a card from the dack and add it to player 1 hand
        player1.draw(deck.deal());
        int p1Value = player1.getValue();
        System.out.println("\n\nThe face up card value: " + p1Value);

        do {
            System.out.print("Would you like another card: ");
            String input = myScanner.nextLine().toLowerCase().trim();

            switch (input){
                case "yes" -> {
                    // add a card everytime the user enters "yes" and add it to the visible value
                    player1.draw(deck.deal());
                    p1Value = player1.getValue();
                    System.out.println("The face up card value: " + p1Value);

                    // for when the player exceeds 21 from the value he can see.
                    if (p1Value >= 21){
                        done = true;
                    }
                }
                case "no" -> {done = true;}
                default -> System.out.println("Invalid input");
            }

        } while (!done);

        player1.draw(deck.deal());
        p1Value = player1.getValue();

        return p1Value;

    }
}
