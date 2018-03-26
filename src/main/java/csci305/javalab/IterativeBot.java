/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 *
 * @author Drew
 */
public class IterativeBot extends Player{
    private Element elements[] = new Element[5];
    private int index = 0;
    
    public IterativeBot(String name) {
        super(name);
        elements[0] = Main.moves.get("Rock");
        elements[1] = Main.moves.get("Paper");
        elements[2] = Main.moves.get("Scissors");
        elements[3] = Main.moves.get("Lizard");
        elements[4] = Main.moves.get("Spock");
    }
    
    @Override
    public Element play(Element e) {
        if (index > 4) {
            index = 0;
        }
        return elements[index++];
    }
}