/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent the move Rock
 * @author Drew
 */
public class Rock extends Element{
    public Rock(String name) {
        super(name);
    }

    @Override
    public Outcome compareTo(Element e) {   // given an input element, determine the outcome of the game. This is unique for the Rock class.
        switch (e.getName()) {
            case "Rock": return new Outcome("Rock equals Rock", "Tie");
            case "Paper": return new Outcome("Paper covers Rock", "Lose");
            case "Scissors": return new Outcome("Rock crushes Scissors", "Win");
            case "Lizard": return new Outcome("Rock crushes Lizard", "Win");
            case "Spock": return new Outcome("Spock vaporizes Rock", "Lose");
            default: return new Outcome("Unknown comparison", "Null");
        }
    }
}
