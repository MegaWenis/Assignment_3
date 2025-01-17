package org.uob.a3.gameobjects;

import java.util.List;

/**
 * Represents the case resolution logic for the game.
 *
 * <p>
 * The {@code CaseResolution} class checks whether the player has collected all the required clues and
 * provides a solution to the case. It also validates the player's attempt to solve the case.
 * </p>
 */
public class CaseResolution {

    private final List<String> requiredClues;
    private final String solution;
    private boolean resolved;

    //constructor with list of required clues and solution string with character name
    public CaseResolution(List<String> requiredClues, String solution) {
        this.requiredClues =requiredClues;
        this.solution = solution;
        this.resolved = false;
    }

    //checks players notebook to attempt resolution
    public boolean attemptResolution(Player player,String playerSolution) {

        Boolean correctPlayer = false;
        String case1 = "moriarty";
        String case2 = "mr.moriarty";

        if (solution.equalsIgnoreCase(playerSolution.trim())||case1.equalsIgnoreCase(playerSolution.trim())||case2.equalsIgnoreCase(playerSolution.trim())){
            correctPlayer = true;
        }

        if (player.getNotebook().containsAll(requiredClues) && correctPlayer) {
            resolved = true;
            return true;
        }
        return false;
    }

   //getters
    public String getSolution() {
        return solution;
    }

    public List<String> getRequiredClues() {
        return requiredClues;
    }

    //checks if casse is solved
    public boolean isResolved(){
        return resolved;
    }


    @Override
    public String toString() {
        StringBuilder resolutionString = new StringBuilder();
        resolutionString.append("Case Resolution Status: ");

        resolutionString.append(resolved ? "Resolved" : "Unresolved").append("\n");
        resolutionString.append("Required Clues:\n");
        for (String clue : requiredClues){
            resolutionString.append("- ").append(clue).append("\n");
        }
        return resolutionString.toString();
    }
}

