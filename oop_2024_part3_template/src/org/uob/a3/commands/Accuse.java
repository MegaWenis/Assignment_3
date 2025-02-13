package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "accuse" command, allowing the player to accuse a suspect to attempt to win the game.
 *
 * <p>
 * The accuse command checks if the provided suspect is the correct one. If the accusation is correct,
 * the player wins; otherwise, the player loses.
 * </p>
 */
public class Accuse extends Command {

    public Accuse(String suspect) {
        this.value =suspect;
        this.commandType = commandType.ACCUSE;
    }


    public String execute(GameState gameState) {
        CaseResolution caseResolution = gameState.getCaseResolution();

        if (caseResolution.isResolved()){
            return "The case has already been resolved. Congratulations!";}

        boolean isCorrect =caseResolution.attemptResolution(gameState.getPlayer(),value);

        if (isCorrect){
            return "Congratulations! You correctly accused " + value + " and solved the case!";
        } else {
            gameState.reduceScore();
            gameState.reduceScore();
            return "Your accusation of " +value+ " was incorrect. The case remains unsolved.";

        }
    }

}
