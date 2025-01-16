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
public class Quit extends Command {
    public Quit() {
        this.commandType = CommandType.QUIT;
        this.value = null;
    }

    public String execute(GameState gameState) {
        StringBuilder finalMessage = new StringBuilder();
        Player currentPlayer = gameState.getPlayer();

        finalMessage.append(currentPlayer.toString());
        finalMessage.append("\nYou were in room:"+"\n"+gameState.getMansion().getCurrentLocation().getName());

        finalMessage.append("\nThanks for playing:)");
        return finalMessage.toString();
    }
}
