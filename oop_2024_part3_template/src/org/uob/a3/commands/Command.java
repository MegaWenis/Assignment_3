package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents an abstract command that can be executed within the game.
 *
 * <p>
 * Subclasses should define specific types of commands and their behavior by
 * implementing the {@link #execute(GameState)} method. Commands represent
 * player actions such as moving, collecting items, or analyzing clues.
 * </p>
 */
public abstract class Command {

    /**
     * The type of the command (e.g., MOVE, GET, DROP).
     */
    public CommandType commandType;

    /**
     * An optional value associated with the command, such as a target item or direction.
     */
    public String value;

    /**
     * Executes the command using the provided game state.
     *
     * <p>
     * Subclasses must implement this method to define the specific behavior
     * of the command when executed in the context of the given {@link GameState}.
     * </p>
     *
     * @param gameState the current state of the game, including player status and environment
     * @return a string describing the outcome of the command execution
     */
    public Command() {
    }

    public String toString() {
        return "command type: " + commandType + "with value: " + value;
    }

    public abstract String execute(GameState gameState);
}
