/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Drew
 */
public class Main {
    public static final Map<String, Element> moves = new HashMap<String, Element>(5);
    public static Element lastPlayed = null;
    public static Scanner in = new Scanner(System.in);
    public static Player[] players = new Player[2];
    public static Element[] playerMoves = new Element[2];
    public static Outcome playResult;
    public static int numTies = 0;


    public static void main(String args[]) {
        moves.put("Rock", new Rock("Rock"));
        moves.put("Paper", new Paper("Paper"));
        moves.put("Scissors", new Scissors("Scissors"));
        moves.put("Lizard", new Lizard("Lizard"));
        moves.put("Spock", new Spock("Spock"));

        playGame();
    }

    public static void playGame() {
        printIntro();
        playerSelect();

        System.out.format("\n%s vs %s, GO!\n\n", players[0].getName(), players[1].getName());

        Element player1Move;
        Element player2Move;
        int player1Wins = 0;
        int player2Wins = 0;

        for(int i = 0; i < 5; i++) {
          if(players[0].getName().equals("MyBot")) {
            player2Move = players[1].play(lastPlayed);
            player1Move = players[0].play(player2Move);
          } else if (players[1].getName().equals("MyBot")) {
            player1Move = players[0].play(lastPlayed);
            player2Move = players[1].play(player1Move);
          } else {
            player1Move = players[0].play(lastPlayed);
            player2Move = players[1].play(lastPlayed);
          }

            System.out.format("%s played %s\n", players[0].getName(), player1Move.getName());
            System.out.format("%s played %s\n", players[1].getName(), player2Move.getName());


            if(players[0].getName().equals("LastPlayBot")) {
                lastPlayed = player2Move;
            } else if(players[1].getName().equals("LastPlayBot")) {
                lastPlayed = player1Move;
            }
            playResult = player1Move.compareTo(player2Move);
            System.out.println(playResult);
            if (playResult.getWinLoseTie().equals("Win")) {
                System.out.format("%s won this round\n\n", players[0].getName());
                player1Wins++;
            } else if (playResult.getWinLoseTie().equals("Lose")) {
                System.out.format("%s won this round\n\n", players[1].getName());
                player2Wins++;
            } else {
                numTies++;
            }
        }
        System.out.println("Game Over!");
        System.out.format("%s had %d win(s)\n", players[0].getName(), player1Wins);
        System.out.format("%s had %d win(s)\n", players[1].getName(), player2Wins);
        System.out.format("There was %d tie(s)\n", numTies);

        if(player1Wins > player2Wins) {
          System.out.format("%s won the game!", players[0].getName());
        } else if (player2Wins > player1Wins) {
          System.out.format("%s won the game!", players[1].getName());
        } else {
          System.out.println("It was a tie!");
        }
    }


    public static void printIntro() {
        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by Andrew Beck\n");
        System.out.println("Please choose two players");
        System.out.println("   (1) Human");
        System.out.println("   (2) StupidBot");
        System.out.println("   (3) RandomBot");
        System.out.println("   (4) IterativeBot");
        System.out.println("   (5) LastPlayBot");
        System.out.println("   (6) MyBot");
    }

    public static void playerSelect() {
        int input;
        for(int i = 0; i < 2; i++) {
            while(true){
                System.out.printf("Select player %d: ", i+1);

                try {
                    input = in.nextInt();
                    if(input > 0 && input < 7) {
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    in.next();
                };
                System.out.println("Invalid selection. Please try again.");
            }
            switch(input) {
                case 1:
                    System.out.print("Enter you name: ");
                    players[i] = new Human(in.next()); break;
                case 2: players[i] = new StupidBot("StupidBot"); break;
                case 3: players[i] = new RandomBot("RandomBot"); break;
                case 4: players[i] = new IterativeBot("IterativeBot"); break;
                case 5: players[i] = new LastPlayBot("LastPlayBot"); break;
                case 6: players[i] = new MyBot("MyBot"); break;
                default: players[i] = new RandomBot("RandomBot");
            }
        }
    }
}
