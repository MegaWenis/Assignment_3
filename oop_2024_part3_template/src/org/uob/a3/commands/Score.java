package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "quit" command, allowing the player to exit the game.
 *
 * <p>
 * The quit command signals the end of the game session and provides a summary of the player's
 * current status before termination.
 * </p>
 */
public class Score extends Command {
    public Score() {
        this.commandType = CommandType.SCORE;
        this.value = null;
    }

    public String execute(GameState gameState) {
        int currentScore = gameState.getScore();
        return "Your current score is: " + currentScore;

    }
}
