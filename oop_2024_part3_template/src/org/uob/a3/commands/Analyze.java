package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "analyze" command, allowing the player to analyze clues for further insights.
 *
 * <p>
 * The analyze command examines a specified clue or item in the player's notebook and provides
 * detailed information, including descriptions, keywords, relevance, and hints.
 * </p>
 */
public class Analyze extends Command {

    public Analyze(String topic) {
        this.value = topic;
        this.commandType =commandType.ANALYZE;
    }


    public String execute(GameState gameState) {
        Notebook notebook= gameState.getPlayer().getNotebook();

        for (Clue clue : notebook.getClues()) {
            if (clue.getName().equalsIgnoreCase(value)) {
                //return "Clue {id='" + id + "', name='" + name + "', description='" + description + "', keywords=" + keywords + ", relevance=" + relevance + "}";
                return "Clue {id='" + clue.getId() + "', name='" + clue.getName() + "', description='" + clue.getDescription() +
                        "', keywords=" + clue.getKeywords() + ", relevance=" + clue.getRelevance() + "}";
            }
        }

        return "The clue or item named '" + value + "' was not found in your notebook. Please check the name and try again.";
    }

}
