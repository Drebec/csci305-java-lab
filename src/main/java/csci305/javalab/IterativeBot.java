/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent an IterativeBot. IterativeBot iterates through the possible moves.
 * @author Drew
 */
public class IterativeBot extends Player{
    private Element elements[] = new Element[5];    // array to hold each possible move. Easier to iterate over than a Hash
    private int index = 0;    // index for elements[]

    public IterativeBot(String name) {
        super(name);
        // add all moves to elements[]
        elements[0] = Main.moves.get("Rock");
        elements[1] = Main.moves.get("Paper");
        elements[2] = Main.moves.get("Scissors");
        elements[3] = Main.moves.get("Lizard");
        elements[4] = Main.moves.get("Spock");
    }

    @Override
    public Element play(Element e) {  // IterativeBot makes no use of the argument to play()
        if (index > 4) {    // wrap back to zero if the index goes out of bounds
            index = 0;
        }
        return elements[index++];   // return the move at the index with an index post increment
    }
}
