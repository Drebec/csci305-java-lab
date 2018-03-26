/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

import java.util.Scanner;

/**
 *
 * @author drewb
 */
public class Human extends Player{
    Scanner in = new Scanner(System.in);
    
    public Human(String name) {
        super(name);
    }
    
    private void printMenu() {
        System.out.println("(1) : Rock");
        System.out.println("(2) : Paper");
        System.out.println("(3) : Scissors");
        System.out.println("(4) : Lizard");
        System.out.println("(5) : Spock");
    }
    
    @Override
    public Element play(Element el) {
        int input = -1;
        printMenu();
        while(true) {
            System.out.println("Enter your move: ");
            try {
                input = in.nextInt();
                if(input > 0 && input < 6) {
                    break;
                }
            } catch (java.util.InputMismatchException e){
                in.next();
            };
            System.out.println("Invalid move.Please try again.");
        }
        
        switch(input) {
            case 1: return Main.moves.get("Rock");
            case 2: return Main.moves.get("Paper");
            case 3: return Main.moves.get("Scissors");
            case 4: return Main.moves.get("Lizard");
            case 5: return Main.moves.get("Spock");
            default: return null;
        }        
    }
}
