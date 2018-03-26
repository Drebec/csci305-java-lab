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
public class Outcome {
    private final String outputString;
    private final String winLoseTie;
    
    public Outcome(String outputString, String winLoseTie) {
        this.outputString = outputString;
        this.winLoseTie = winLoseTie;
    }
    
    public String getWinLoseTie() {
        return winLoseTie;
    }
    
    @Override
    public String toString() {
        return outputString;
    }
}
