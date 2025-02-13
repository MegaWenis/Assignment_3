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
        this.name = null;
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

    //Player Name: Detective
    //Notebook:
    //[Clue {id='clue1', name='Mysterious Letter', description='A letter with strange markings.', keywords=[letter, mysterious], relevance=5}]>
    // but was: <Name:Detective
    //Notebook: 1 clues collected.>

    @Override
    public String toString() {
        StringBuilder playerDescription = new StringBuilder();

        playerDescription.append("Player Name: ").append(this.name).append("\n");


        playerDescription.append("Notebook:\n");
        for (Clue clue :notebook.getClues()) {
            playerDescription.append("[Clue {id='").append(clue.getId()).append("', ");
            playerDescription.append("name='").append(clue.getName()).append("', ");
            playerDescription.append("description='").append(clue.getDescription()).append("', ");
            playerDescription.append("keywords=").append(clue.getKeywords()).append(", ");
            playerDescription.append("relevance=").append(clue.getRelevance()).append("}]\n");
        }

        return playerDescription.toString().trim();
    }

}


