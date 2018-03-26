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
public class LastPlayBot extends Player {
    public LastPlayBot(String name) {
        super(name);
    }
    
    @Override    
    public Element play(Element last) {
        if (last == null) {
            return Main.moves.get("Scissors");
        } else {
            return last;
        }
    }
}
