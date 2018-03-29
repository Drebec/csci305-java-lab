/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

import java.util.Scanner;

/**
 * Class to represent a human player
 * @author drewb
 */
public class Human extends Player{
    Scanner in = new Scanner(System.in);

    public Human(String name) {
        super(name);
    }

    // prints the 5 possible moves menu
    private void printMenu() {
        System.out.println("(1) : Rock");
        System.out.println("(2) : Paper");
        System.out.println("(3) : Scissors");
        System.out.println("(4) : Lizard");
        System.out.println("(5) : Spock");
    }

    // the human play is going to get user input with error checking and play the users selection
    @Override
    public Element play(Element el) {   // the human class makes no use of the argument to the play function
        int input = -1;   //start user input as invalid
        printMenu();    //print the moves menu
        while(true) {
            System.out.println("Enter your move: ");
            try {   // try catch protects against invalid type inputs i.e. string instead of int
                input = in.nextInt();   //get user input
                if(input > 0 && input < 6) {    //check for input out of bounds
                    break;
                }
            } catch (java.util.InputMismatchException e){
                in.next();    // clear the buffer to prevent infinite improper inputs if the initial input was a string
            };
            System.out.println("Invalid move.Please try again.");   // print invalid message
        }

        switch(input) {   // return the move based on user selection
            case 1: return Main.moves.get("Rock");
            case 2: return Main.moves.get("Paper");
            case 3: return Main.moves.get("Scissors");
            case 4: return Main.moves.get("Lizard");
            case 5: return Main.moves.get("Spock");
            default: return null;
        }
    }
}
