/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent the generic Player all other player inherit from
 * @author Drew
 */
abstract public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    // returns the name of the current player
    public String getName() {
        return name;
    }

    // abstract play method to determine the play strategy for each player
    abstract public Element play(Element e);
}
