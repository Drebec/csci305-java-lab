/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Class to represent MyBot. MyBot cheats, and is therefore unbeatable.
 * @author Drew
 */
public class MyBot extends Player {
    public MyBot(String name) {
        super(name);
    }

    @Override
    public Element play(Element el) {   // MyBot does use the argument to play()
      if(el == null) {    // if el is null return Spock i.e. the first round
        return Main.moves.get("Spock");
      }
        switch(el.getName()) {    // based on the input, play the counter move. From Main, the input will always be the other players move.
          case "Rock": return Main.moves.get("Paper");
          case "Paper": return Main.moves.get("Scissors");
          case "Scissors": return Main.moves.get("Rock");
          case "Lizard": return Main.moves.get("Scissors");
          case "Spock": return Main.moves.get("Lizard");
          default: return Main.moves.get("Spock");
        }
    }
}
