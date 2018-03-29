/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent the outcome of comparing two elements.
 * @author Drew
 */
public class Outcome {
    private final String outputString;    // Outcome of the comparison
    private final String winLoseTie;    // win, lose, or tie

    public Outcome(String outputString, String winLoseTie) {
        this.outputString = outputString;
        this.winLoseTie = winLoseTie;
    }

    // getters for each class variable
    public String getWinLoseTie() {
        return winLoseTie;
    }

    @Override
    public String toString() {
        return outputString;
    }
}
