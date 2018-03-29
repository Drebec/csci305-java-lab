/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

// imports
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Drew
 */
public class Main {
    // static class variables
    public static final Map<String, Element> moves = new HashMap<String, Element>(5); //Hash to hold instances of each Element
    public static Element lastPlayed = null;    //Holds the opponente previously played value. Only used by lastPlayedBot.
    public static Scanner in = new Scanner(System.in);    //User input
    public static Player[] players = new Player[2];   //Array to hold both instances of players
    public static Element[] playerMoves = new Element[2];   //Array to hold both player's moves
    public static Outcome playResult;   //Saves the result of each round
    public static int numTies = 0;    //Tracks the number of ties during the game


    // main method
    public static void main(String args[]) {
      // adding all moves to the Moves Hash
        moves.put("Rock", new Rock("Rock"));
        moves.put("Paper", new Paper("Paper"));
        moves.put("Scissors", new Scissors("Scissors"));
        moves.put("Lizard", new Lizard("Lizard"));
        moves.put("Spock", new Spock("Spock"));

        // run the game
        playGame();
    }

    public static void playGame() {
        printIntro();   //print the intro message
        playerSelect();   //print the player select message and choose players

        System.out.format("\n%s vs %s, GO!\n\n", players[0].getName(), players[1].getName());   //Print GO! message

        //Store player moves and wins
        Element player1Move;
        Element player2Move;
        int player1Wins = 0;
        int player2Wins = 0;

        // Play 5 rounds
        for(int i = 0; i < 5; i++) {
          //This section handles the case where either player is a MyBot and facilitates its cheating
          //Basically just tells the MyBot which move the other player played before the moves are compared
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

            //Prints what each player played
            System.out.format("%s played %s\n", players[0].getName(), player1Move.getName());
            System.out.format("%s played %s\n", players[1].getName(), player2Move.getName());


            //If a LastPlayBot is involved, save the opponents move for use next round
            if(players[0].getName().equals("LastPlayBot")) {
                lastPlayed = player2Move;
            } else if(players[1].getName().equals("LastPlayBot")) {
                lastPlayed = player1Move;
            }

            //Compare the two moves
            playResult = player1Move.compareTo(player2Move);
            //Print the result
            System.out.println(playResult);

            //Because player1 is alwasy the first in the comparison, if the Outcome is a win, player one won.
            //If the outcome is a loss, player two won. Otherwise, it was a tie.
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

        //After the game is over, print the game over message detailing each players wins and the number of ties.
        System.out.println("Game Over!");
        System.out.format("%s had %d win(s)\n", players[0].getName(), player1Wins);
        System.out.format("%s had %d win(s)\n", players[1].getName(), player2Wins);
        System.out.format("There was %d tie(s)\n", numTies);

        //Based on the number of wins each player had, print the game winner
        if(player1Wins > player2Wins) {
          System.out.format("%s won the game!", players[0].getName());
        } else if (player2Wins > player1Wins) {
          System.out.format("%s won the game!", players[1].getName());
        } else {
          System.out.println("It was a tie!");
        }
    }

    //This method just handles printing the intro menu
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

    //Prints the select player message and handles user input with error checking
    public static void playerSelect() {
        int input;    // stores user input
        for(int i = 0; i < 2; i++) {    // get two players
            while(true){
                System.out.printf("Select player %d: ", i+1);   // print select player 1 or 2

                try {   // try catch detects improper inputs i.e. strings instead of ints
                    input = in.nextInt();   //get user input
                    if(input > 0 && input < 7) {    //check for input out of range
                        break;    //this break means the input was correct
                    }
                } catch (java.util.InputMismatchException e) {    //catches anything that doesn't match what in.nextInt() is expecting
                    in.next();    //clears the buffer to prevent infinite invalid selections when input was initially a string
                };
                System.out.println("Invalid selection. Please try again.");   // Print invalid message
            }
            switch(input) {   //choose a player to create based on user selection
                case 1:
                    System.out.print("Enter you name: ");
                    players[i] = new Human(in.next()); break;
                case 2: players[i] = new StupidBot("StupidBot"); break;
                case 3: players[i] = new RandomBot("RandomBot"); break;
                case 4: players[i] = new IterativeBot("IterativeBot"); break;
                case 5: players[i] = new LastPlayBot("LastPlayBot"); break;
                case 6: players[i] = new MyBot("MyBot"); break;
                default: players[i] = new RandomBot("RandomBot");   //default is RandomBot
            }
        }
    }
}
