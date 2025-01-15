package org.uob.a3.gameobjects;

import java.util.ArrayList;

/**
 * Represents the player in the game, including their name, inventory, and notebook.
 *
 * <p>
 * The player can collect clues, manage their notebook, and interact with the game world.
 * </p>
 */

public class Player extends Object {

    private String name;
    private Notebook notebook;

    //constructor for Player
    public Player() {
        this.name = "Unknown";
        this.notebook = new Notebook();
    }

    //contructs player given their name
    public Player(String name) {
        this.name = name;
        this.notebook = new Notebook();
    }

    //getters
    public String getName(){return this.name;
    }
    public Notebook getNotebook() {return this.notebook;}

    // Returns a string representation of the player's current state, including their name and the contents of their notebook
    @Override
    public String toString() {
        return "Name:" + name + "\nNotebook: " + notebook.getNumberOfClues() + " clues collected.";
    }
}

