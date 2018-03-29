/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent the RandonBot. RandomBot picks a move randomply and plays it
 * @author Drew
 */
public class RandomBot extends Player{
    private Element elements[] = new Element[5];    // array to hold each possible move, easier to iterate over than a Hash

    public RandomBot(String name) {
        super(name);
        // adding each move to elements
        elements[0] = Main.moves.get("Rock");
        elements[1] = Main.moves.get("Paper");
        elements[2] = Main.moves.get("Scissors");
        elements[3] = Main.moves.get("Lizard");
        elements[4] = Main.moves.get("Spock");
    }

    @Override
    public Element play(Element el) {
        return elements[(int)(Math.random() * 5)];    //pick a random move and play it
    }
}
