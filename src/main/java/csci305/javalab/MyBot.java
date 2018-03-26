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
public class MyBot extends Player {
    public MyBot(String name) {
        super(name);
    }

    @Override
    public Element play(Element el) {
      if(el == null) {
        return Main.moves.get("Spock");
      }
        switch(el.getName()) {
          case "Rock": return Main.moves.get("Paper");
          case "Paper": return Main.moves.get("Scissors");
          case "Scissors": return Main.moves.get("Rock");
          case "Lizard": return Main.moves.get("Scissors");
          case "Spock": return Main.moves.get("Lizard");
          default: return Main.moves.get("Spock");
        }
    }
}
