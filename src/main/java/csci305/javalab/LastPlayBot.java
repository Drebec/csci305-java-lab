/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent a LastPlayBot. LastPlayBot always plays what the opponent played the previous round.
 * @author Drew
 */
public class LastPlayBot extends Player {
    public LastPlayBot(String name) {
        super(name);
    }

    @Override
    public Element play(Element last) {   // LastPlayBot does use the argument to play
        if (last == null) {   // if the input is null i.e. in the first round, play Scissors
            return Main.moves.get("Scissors");
        } else {
            return last;    // otherwise play whatevver was passed as an argument. In Main, this argument is always the opponents previous move.
        }
    }
}
