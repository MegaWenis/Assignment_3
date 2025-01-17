package org.uob.a3.commands;

/**
 * Represents the various types of commands that can be executed in the game.
 *
 * <p>
 * Each command type corresponds to a specific player action or game functionality.
 * The enum provides a structured way to categorize and handle player commands.
 * </p>
 */
public enum CommandType {

    /**
     * Represents a command to move the player to a different location.
     */
    MOVE,

    /**
     * Represents a command to collect a clue or item.
     */
    COLLECT,

    /**
     * Represents a command to view all collected clues in the notebook.
     */
    NOTEBOOK,

    /**
     * Represents a command to look around the current location or inspect an object.
     */
    LOOK,

    /**
     * Represents a command to check the player's current status.
     */
    STATUS,

    /**
     * Represents a command to analyze collected clues and make deductions.
     */
    ANALYZE,

    /**
     * Represents a command to make an accusation about the case.
     */
    ACCUSE,

    /**
     * Represents a command to interact with a feature or environment element.
     */
    INTERACT,

    /**
     * Represents a command to display help information.
     */
    HELP,

    /**
     * Represents a command to quit the game.
     */
    QUIT,

    SCORE
    //returns the score


}
