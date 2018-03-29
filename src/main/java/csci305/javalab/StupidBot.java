/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent a StupidBot. StupidBot always plays the same move.
 * @author Drew
 */
public class StupidBot extends Player{
    public StupidBot(String name) {
        super(name);
    }

    @Override
    public Element play(Element el) {   // StupidBot does not use the argument to play
        return Main.moves.get("Rock");    // Always play Rock
    }
}
