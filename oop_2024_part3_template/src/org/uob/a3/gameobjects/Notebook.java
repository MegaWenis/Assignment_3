package org.uob.a3.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Notebook extends GameObject {

    private List<Clue> clues;

    //contructor
    public Notebook() {
        this.clues = new ArrayList<>();
    }

    //adds a new clue unless you aready have it
    public void addClue(Clue clue) {
        if (!clues.contains(clue)) {
            clues.add(clue);
        }
    }

    //returns the list of clues
    public List<Clue> getClues() {
        return new ArrayList<>(clues);
    }

    //checks if you contain all the required clues
    public boolean containsAll(List<String> requiredClues) {
        for(String requiredClue : requiredClues) {
            boolean found =false;
            for (Clue clue : clues) {
                if (clue.getName().equals(requiredClue)) {
                    found = true;
                    break;}
            }
            if (!found) {
                return false;
            }
        }return true;
    }

    public int getNumberOfClues() {
        return clues.size();
    }

    // Returns a string representation of the notebook by calling the superclass's toString method
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("You have the following clues:\n");

        for (Clue clue:clues){

            output.append("- ").append(clue.getName()).append(": ").append(clue.getDescription()).append("\n");

        }
        return output.toString();
    }
}

