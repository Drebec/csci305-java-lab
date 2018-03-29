/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.csci305.javalab;

/**
 * Base class from which all Elements inherit their general properties
 * @author Drew
 */
abstract public class Element {
    public String name;

    // constructor
    public Element(String name) {
        this.name = name;
    }

    // returns the name of the element
    public String getName() {
        return this.name;
    }

    // abstract method to represent the comparison between this element and another element
    abstract public Outcome compareTo(Element e);
}
