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
    //checks if notebook conatains certain clue by name
    public boolean hasClue(String clueName) {
        for (Clue clue : clues) {
            if (clue.getName().equals(clueName)) {
                return true;
            }
        } return false;
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

    //used for the player to string
    public int getNumberOfClues() {
        return clues.size();
    }

    // returns the clues in notebook
    @Override
    public String toString() {
        return "GameObject {id='notebook', name='Notebook', description='Notebook for your clues.'}"

        //StringBuilder output = new StringBuilder("You have the following clues:\n");
        //for (Clue clue:clues){
            //output.append("- ").append(clue.getName()).append(": ").append(clue.getDescription()).append("\n");
        //}
        //return output.toString();
    }
}

