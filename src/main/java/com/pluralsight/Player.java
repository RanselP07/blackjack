package com.pluralsight;

import java.util.Scanner;

public class Player {

    public static String[] name(Scanner myScanner) {
        boolean done = false;
        String input = "";
        int names = 0;

        do {
            try {
                System.out.print("Enter the number of players: ");
                input = myScanner.nextLine();
                names = Integer.parseInt(input);

                if (names > 1){
                    done = true;
                } else {
                    System.out.print("2 or more player, try again: ");
                    input = myScanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, it has to be a integer!");
            }

        }while (!done);

        String[] players = new String[names];

        for (int i = 0; i < names; i++) {
            System.out.print("\nPlayer " + (i + 1) + ": ");
            players[i] = myScanner.nextLine();

            if (players[i] == null || players[i].isBlank()) {
                players[i] = "P" + (i + 1);
            }
        }

        String squad = "\n" + players[0];

        for (int i = 1; i < names; i++) {
            squad += " Vs. " + players[i];
        }

        System.out.print(squad);
        return players;
    }

    public static int play(Scanner myScanner, Deck deck){
        boolean done = false;

        //Handles player 1 hand
        Hand player = new Hand();

        //get a card from the dack and add it to player 1 hand
        player.draw(deck.deal());
        int playerValue = player.getValue();
        System.out.println("\n\nThe face up card value: " + playerValue);

        do {
            System.out.print("Would you like another card: ");
            String input = myScanner.nextLine().toLowerCase().trim();

            switch (input){
                case "yes" -> {
                    // add a card everytime the user enters "yes" and add it to the visible value
                    player.draw(deck.deal());
                    playerValue = player.getValue();
                    System.out.println("The face up card value: " + playerValue);

                    // for when the player exceeds 21 from the value he can see.
                    if (playerValue >= 21){
                        done = true;
                    }
                }
                case "no" -> {done = true;}
                default -> System.out.println("Invalid input");
            }

        } while (!done);

        player.draw(deck.deal());
        playerValue = player.getValue();

        System.out.println("Final Score: " + playerValue);

        return playerValue;

    }
}
